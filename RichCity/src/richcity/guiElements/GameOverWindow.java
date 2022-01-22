package richcity.guiElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import richcity.core.MoneyTracker;
import richcity.tools.ImagePanel;
import richcity.tools.ResizeElements;

public class GameOverWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	int idW = 6;
	
	public GameOverWindow(int width, int height, MoneyTracker money) {
		 /*
		* You Died Settings
		*/
		JLabel youdied = new JLabel();
		youdied.setBackground(Color.pink);
		youdied.setOpaque(false);
		youdied.setIcon(ResizeElements.resizeIcon("assets/deadWindow/youdied.png", 600, 400));
		youdied.setSize(600, 400);
		youdied.setVisible(true);
		youdied.setLocation((width/2)-310,(height/2)-300);

		/*
		 * Earned Money Settings
		 */
		JLabel earnedmoney = new JLabel("0.00,-€");
		earnedmoney.setFont(new Font("Fixedsys Standard", Font.BOLD, 45));
		earnedmoney.setSize(200, 100);
		earnedmoney.setText(money.getMoney()+"€");
		earnedmoney.setForeground(Color.RED);
		earnedmoney.setVisible(true);
		earnedmoney.setLocation((width/2)-30,(height/2)-150);
		 
		/*
		 * Logo Settings
		 */
	    JLabel logo = new JLabel();
	    logo.setBackground(Color.pink);
	    logo.setOpaque(false);
	    logo.setIcon(ResizeElements.resizeIcon("assets/general/logo.png", 400, 200));
	    logo.setSize(400, 200);
	    logo.setVisible(true);
	    logo.setLocation((width/2)-200,(height/2)+100);
	    
	    /*
	     * Start Button Settings
	     */
	    JButton startB = new JButton(ResizeElements.resizeIcon("assets/deadWindow/restart-button.png", 350, 65));
	    startB.setBackground(Color.red);
	    startB.setOpaque(false);
	    startB.setSize(350, 65);
	    startB.setVisible(true);
	    startB.setFocusPainted(false);
	    startB.setBorder(null);
	    startB.setLocation((width/2)-180,(height/2)-50);
	    
	    /*
	     * Info Button Settings
	     */
	    JButton infoB = new JButton(ResizeElements.resizeIcon("assets/deadWindow/exit-button.png", 300, 65));
	    infoB.setBackground(Color.red);
	    infoB.setOpaque(false);
	    infoB.setSize(350, 65);
	    infoB.setFocusPainted(false);
	    infoB.setBorder(null);
	    infoB.setVisible(true);
	    infoB.setLocation((width/2)-180,(height/2)+50);
	    
	    /*
	     * Set Background
	     */
	    try {
	      BufferedImage bcImage = ImageIO.read(new File("assets/deadWindow/background.jpg"));
	      this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height));
	    } catch (IOException e) {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    
	    /*
	     * Window Settings
	     */
	    this.setTitle("Rich City - Die Stadt die DICH Reich macht!");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(width, height);
	    this.setLocationRelativeTo(null);
	    
	    /*
	     * Implement it
	     */
	    this.add(youdied);
	    this.add(earnedmoney);
	    this.add(logo);
	    this.add(startB);
	    this.add(infoB);
	}
	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
	
}
