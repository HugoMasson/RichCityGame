package richcity.guiElements;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import richcity.core.MoneyTracker;
import richcity.tools.ImagePanel;
import richcity.tools.ResizeElements;

public class HelpWindow extends JFrame{

  private static final long serialVersionUID = 1L;
	MoneyTracker money;
	int idW = 3;
  
  public HelpWindow(int width, int height, MoneyTracker money) {
	  
	/*
	 * logo Settings
	 */
	JLabel logo = new JLabel();
    logo.setBackground(Color.pink);
    logo.setOpaque(false);
    logo.setIcon(ResizeElements.resizeIcon("assets/general/logo.png", 400, 150));
    logo.setSize(400, 200);
    logo.setVisible(true);
    logo.setLocation((width/2)-200,(height/2)+70);
    
    /*
     * back Button Settings
     */
    JButton backB = new JButton(ResizeElements.resizeIcon("assets/general/back-button.png", 240, 70));
    backB.setBorder(null);
    backB.setSize(240, 80);
    backB.setBackground(Color.red);
	backB.setOpaque(false);
	backB.setFocusPainted(false);
	backB.setVisible(true);
	backB.setLocation((width/2)-500,(height/2)+180);
	/*
	 * back Button function (go back)
	 */
	backB.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	SelectGameWindow sw = new SelectGameWindow(1000, 600, money);
			sw.showMe(true);
			dispose();
	    }
	});
	
	/*
	 * help Button Settings
	 */
    JButton helpB = new JButton(ResizeElements.resizeIcon("assets/helpWindow/help-button.png", 240, 70));
	helpB.setBorder(null);
	helpB.setSize(240, 80);
	helpB.setBackground(Color.red);
	helpB.setOpaque(false);
	helpB.setFocusPainted(false);
	helpB.setVisible(true);
	helpB.setLocation((width/2)+250,(height/2)+180);
			/*
			 * help Button function (give 1000�)
			 */
			helpB.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			    	// Cooldown of 1 minutes because its spamming
			    	money.addMoney(1000);
			    }
			});

    /*
     * Set background
     */
    try {
      BufferedImage bcImage = ImageIO.read(new File("assets/helpWindow/background.png"));
      this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    
    /*
     * Window Settings
     */
    this.setTitle("Rich City - Ben�tigst du Hilfe?");
    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    
    /*
     * Implement it.
     */
    this.add(logo);
    this.add(backB);
    this.add(helpB);
    
    
  }
  
  public int showMe(boolean b) {
    this.setVisible(b);
    return idW;
  }
  
  
}
