import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Game implements MouseListener{
	
private Square[][] field = new Square[50][50];
private String[] headers= new String[50];

private JTable board;

private GUI gui;

private String winner;

private boolean turn = true;
private boolean won = false;

private int xMoves = 0;
private int oMoves = 0;


	public Game(){
		
		for(int row = 0; row <field.length; row++){
			headers[row] = "" + row;
			for(int col = 0; col<field[0].length; col++){
				field[row][col] = new Square();
			}
		}
		
		board = new JTable(field,headers);
		board.addMouseListener(this);
		board.setDefaultEditor(Object.class, null);
		
		board.setFont(new Font("Serif", 0, 18));
		board.setRowHeight(19);
		board.setVisible(true);
		
		gui = new GUI(board);
		
		playGame();
	
	}
	
	public void playGame(){
		outer:
		while(!won == true){
			for(int row = 0; row < field.length; row++){
				for(int col = 0; col<field[0].length; col++){
					if(!field[row][col].toString().equals(" ")){
						if(checkNextRight(row, col, field[row][col].toString()) + checkNextLeft(row, col, field[row][col].toString())-1>= 5){
							won = true;
							System.out.println("Congratulations player " + field[row][col].toString() + " you've won!");
							System.out.println();
							
							checkNextRight(row, col, field[row][col].toString());
							checkNextLeft(row, col, field[row][col].toString());
							
							winner = field[row][col].toString();
							break outer;
						}
						
						if(checkNextUp(row, col, field[row][col].toString()) + checkNextDown(row, col, field[row][col].toString())-1>= 5){
							won = true;
							System.out.println("Congratulations player " + field[row][col].toString() + " you've won!");
							System.out.println();
							
							checkNextUp(row, col, field[row][col].toString());
							checkNextDown(row, col, field[row][col].toString());
							
							winner = field[row][col].toString();
							break outer;
						}
						
						if(checkNextUpRight(row, col, field[row][col].toString()) + checkNextDownLeft(row, col, field[row][col].toString())-1>= 5){
							won = true;
							System.out.println("Congratulations player " + field[row][col].toString() + " you've won!");
							System.out.println();
							
							checkNextUpRight(row, col, field[row][col].toString());
							checkNextDownLeft(row, col, field[row][col].toString());
							
							winner = field[row][col].toString();
							break outer;
						}
						
						if(checkNextUpLeft(row, col, field[row][col].toString()) + checkNextDownRight(row, col, field[row][col].toString())-1>= 5){
							won = true;
							System.out.println("Congratulations player " + field[row][col].toString() + " you've won!");
							System.out.println();
							
							checkNextUpLeft(row, col, field[row][col].toString());
							checkNextDownRight(row, col, field[row][col].toString());
							
							winner = field[row][col].toString();
							break outer;
						}
					}
				}
			}
		}
	}
	
	public int checkNextRight(int r, int c, String contents){
		if(c == field[0].length-1 && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;	
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextRight(r, c+1, contents);
		}
		
	}
	
	public int checkNextLeft(int r, int c, String contents){
		if(c == 0 && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextLeft(r, c-1, contents);
		}
		
	}
	
	public int checkNextUp(int r, int c, String contents){
		if(r == 0 && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextUp(r-1, c, contents);
		}
		
	}
	
	public int checkNextDown(int r, int c, String contents){
		if(r == field.length-1 && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextDown(r+1, c, contents);
		}
		
	}
	
	public int checkNextUpRight(int r, int c, String contents){
		if((r == 0 || c == field[0].length-1) && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextUpRight(r-1, c+1, contents);
		}
		
	}
	
	public int checkNextDownLeft(int r, int c, String contents){
		if((r == field.length-1 || c == 0) && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextDownLeft(r+1, c-1, contents);
		}
		
	}
	
	public int checkNextDownRight(int r, int c, String contents){
		if((r == field.length-1 || c == field[0].length-1) && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextDownRight(r+1, c+1, contents);
		}
		
	}
	
	public int checkNextUpLeft(int r, int c, String contents){
		if((r == 0 || c == 0) && contents.equals(field[r][c].toString())){
			System.out.print(r + " , " + c + " ");
			return 1;
		}
		if(!field[r][c].toString().equals(contents)){
			return 0;
		}else{
			System.out.print(r + " , " + c + " ");
			return 1 + checkNextUpLeft(r-1, c-1, contents);
		}
		
	}

	public boolean getWon(){
		return won;
	}
	
	public void close(){
		gui.close();
	}
	
	public String getWinner(){
		return winner;
	}
	
	public void getStats(){
		String message = "";
		if(getWinner().equals("X")){
			message = "**************************************** \n *The winner was " + getWinner() +
							  " who won in " + xMoves + " moves  * \n ****************************************";
			
			System.out.println("****************************************");
			System.out.println("*The winner was " + getWinner() + " who won in " + xMoves + " moves   *");
			System.out.println("****************************************");
		}else{
			message = "**************************************** \n *The winner was " + getWinner() +
					  " who won in " + xMoves + " moves  * \n ****************************************";
			System.out.println("****************************************");
			System.out.println("The winner was " + getWinner() + " who won in " + xMoves + " moves");
			System.out.println("****************************************");		
		}
		
		JOptionPane.showMessageDialog(new JFrame(), message);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(turn == true){
			Square temp = new Square();
			temp.fill_X();

			if(field[board.getSelectedRow()][board.getSelectedColumn()].toString().equals(" ")){
				board.setValueAt(temp, board.getSelectedRow(), board.getSelectedColumn());	
				turn = false;
				xMoves++;
			}
			
		}else if(turn == false){
			Square temp = new Square();
			temp.fill_O();
			
			if(field[board.getSelectedRow()][board.getSelectedColumn()].toString().equals(" ")){
				board.setValueAt(temp, board.getSelectedRow(), board.getSelectedColumn());	
				turn = true;
				oMoves++;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
