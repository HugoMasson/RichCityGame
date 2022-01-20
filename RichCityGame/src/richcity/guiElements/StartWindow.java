package richcity.guiElements;
import java.awt.*;
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

public class StartWindow extends JFrame{

  private static final long serialVersionUID = 1L;
  int idW = 1;
  
  public StartWindow(int width, int height, MoneyTracker money) {
	 
	/*
	 * Logo Settings
	 */
    JLabel logo = new JLabel();
    logo.setBackground(Color.pink);
    logo.setOpaque(false);
    logo.setIcon(ResizeElements.resizeIcon("assets/general/logo.png", 400, 150));
    logo.setSize(400, 200);
    logo.setVisible(true);
    logo.setLocation((width/2)-200,(height/2)-250);
    
    /*
     * Start Button Settings
     */
    JButton startB = new JButton(ResizeElements.resizeIcon("assets/startWindow/start-button.png", 350, 80));
    startB.setBackground(Color.red);
    startB.setOpaque(false);
    startB.setSize(350, 80);
    startB.setVisible(true);
    startB.setFocusPainted(false);
    startB.setBorder(null);
    startB.setLocation((width/2)-180,(height/2)-50);
    
    /*
     * Info Button Settings
     */
    JButton infoB = new JButton(ResizeElements.resizeIcon("assets/startWindow/infos-button.png", 300, 65));
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
      BufferedImage bcImage = ImageIO.read(new File("assets/startWindow/background.jpg"));
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
    this.add(logo);
    this.add(startB);
    this.add(infoB);
    
    
  }
  
  public int showMe(boolean b) {
    this.setVisible(b);
    return idW;
  }
  
  
}
