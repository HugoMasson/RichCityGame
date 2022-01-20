package richcity.guiElements;

import java.awt.Toolkit;

import javax.swing.JFrame;

import richcity.core.MoneyTracker;

public class GameOverWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	int idW = 6;
	
	public GameOverWindow(int width, int height, MoneyTracker money) {
		this.setTitle("Rich City - Game Over");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(width, height);
	    this.setLocationRelativeTo(null);
	}
	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
	
}
