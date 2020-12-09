import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class GUI {
	private JFrame window;
	
	public GUI(JTable table){
		window = new JFrame("Connect 5: A Game by Thilo Goss");
		window.setContentPane(table);
		window.setSize(880,997);
		window.setLocation(0,0);
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	
	public void close(){
		window.dispose();
	}
	
}
