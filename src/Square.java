
public class Square {
	private boolean empty = true;
	private String contents = " ";
	
	public boolean getEmpty(){
		return empty;
	}
	
	public void fill_X(){
		contents = "X";
		empty = false;
	}
	
	public void fill_O(){
		contents = "O";
		empty = false;
	}
	
	public String toString(){
		return contents;
	}
}
