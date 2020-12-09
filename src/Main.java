import javax.swing.JOptionPane;
public class Main {
	
	private static Game game;
	private static boolean end = false;
	public static void main(String[] args){
		 game = new Game();
		
		
		while(!end == true){
			if(game.getWon()){
				newGame();
			}
		}
	}
	
	public static void newGame(){
		int n = JOptionPane.showOptionDialog(null, "Congratulations Player " + game.getWinner() + "!" + " Would you like to play again?", "Connect 5 by Thilo Goss",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if(n == 0){
			game.close();
			game.getStats();
			game = new Game();
		}else{
			end = true;
			game.close();
			game.getStats();
			System.exit(0);
		}
	}
}
