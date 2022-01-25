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

public class SelectGameWindow extends JFrame{

  private static final long serialVersionUID = 1L;
  
  int idW = 9;
  
  public SelectGameWindow(int width, int height, MoneyTracker money) {
	  
		/*
		* moneyLabel Settings
		*/
		JLabel moneyLabel = new JLabel(money.getMoney()+",-$");
		moneyLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 45));
		moneyLabel.setSize(200, 100);
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setVisible(true);
		moneyLabel.setLocation((width/2)+290,(height/2)+170);
	
		 
		/*
		* Title Settings
		*/
		JLabel title = new JLabel();
		title.setBackground(Color.pink);
		title.setOpaque(false);
		title.setIcon(ResizeElements.resizeIcon("assets/selectGameWindow/title.png", 400, 150));
		title.setSize(400, 200);
		title.setVisible(true);
	    title.setLocation((width/2)-200,(height/2)-270);
		 
		/*
		 * Logo Settings
		 */
	    JLabel logo = new JLabel();
	    logo.setBackground(Color.pink);
	    logo.setOpaque(false);
	    logo.setIcon(ResizeElements.resizeIcon("assets/general/logo.png", 400, 150));
	    logo.setSize(400, 200);
	    logo.setVisible(true);
	    logo.setLocation((width/2)-200,(height/2)+110);
	    
	    /*
	     * First Row - KRYPTO Button Settings
	     */
	    JButton kryptoB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/krypto-button.png", 350, 80));
	    kryptoB.setBackground(Color.red);
	    kryptoB.setOpaque(false);
	    kryptoB.setSize(350, 80);
	    kryptoB.setVisible(true);
	    kryptoB.setFocusPainted(false);
	    kryptoB.setBorder(null);
	    kryptoB.setLocation((width/2)-350,(height/2)-90);
	    
	    /*
	     * First Row - ARBEITEN Button Settings
	     */
	    JButton arbeitenB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/arbeiten-button.png", 350, 80));
	    arbeitenB.setBackground(Color.red);
	    arbeitenB.setOpaque(false);
	    arbeitenB.setSize(350, 80);
	    arbeitenB.setVisible(true);
	    arbeitenB.setFocusPainted(false);
	    arbeitenB.setBorder(null);
	    arbeitenB.setLocation((width/2)-350,(height/2)+0);
	    
	    /*
	     * First Row - HILFE Button Settings
	     */
	    JButton hilfeB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/hilfe-button.png", 350, 80));
	    hilfeB.setBackground(Color.red);
	    hilfeB.setOpaque(false);
	    hilfeB.setSize(350, 80);
	    hilfeB.setVisible(true);
	    hilfeB.setFocusPainted(false);
	    hilfeB.setBorder(null);
	    hilfeB.setLocation((width/2)-350,(height/2)+90);
	    
	    /*
	     * Second Row - Casino Button Settings
	     */
	    JButton casinoB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/casino-button.png", 350, 80));
	    casinoB.setBackground(Color.red);
	    casinoB.setOpaque(false);
	    casinoB.setSize(350, 80);
	    casinoB.setVisible(true);
	    casinoB.setFocusPainted(false);
	    casinoB.setBorder(null);
	    casinoB.setLocation((width/2)-40,(height/2)-90);
	    
	    /*
	     * Second Row - Mining Button Settings
	     */
	    JButton miningB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/mining-button.png", 350, 80));
	    miningB.setBackground(Color.red);
	    miningB.setOpaque(false);
	    miningB.setSize(350, 80);
	    miningB.setVisible(true);
	    miningB.setFocusPainted(false);
	    miningB.setBorder(null);
	    miningB.setLocation((width/2)-40,(height/2)+0);
	    
	    /*
	     * Second Row - Exit Button Settings
	     */
	    JButton exitB = new JButton(ResizeElements.resizeIcon("assets/selectGameWindow/exit-button.png", 350, 80));
	    exitB.setBackground(Color.red);
	    exitB.setOpaque(false);
	    exitB.setSize(350, 80);
	    exitB.setVisible(true);
	    exitB.setFocusPainted(false);
	    exitB.setBorder(null);
	    exitB.setLocation((width/2)-40,(height/2)+90);
	    
	    /*
	     * Button events
	     */
	    
	    kryptoB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Crypto cr = new Crypto(1000, 800, money);
				cr.showMe(true);
				dispose();
			}
		});
	    
	    arbeitenB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CookieClicker cc = new CookieClicker(1000, 600, money);
				cc.showMe(true);
				dispose();
			}
		});
	    
	    hilfeB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpWindow hw = new HelpWindow(1000, 600, money);
				hw.showMe(true);
				dispose();
			}
		});
	    
	    casinoB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Casino ca = new Casino(1000, 600, money);
				ca.showMe(true);
				dispose();
			}
		});
	    
	    exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(1);
			}
		});
	    
	    
	    /*
	     * Set Background
	     */
	    try {
	      BufferedImage bcImage = ImageIO.read(new File("assets/selectGameWindow/background.png"));
			this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height-30));
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
	    this.add(title);
	    this.add(logo);
	    this.add(kryptoB);
	    this.add(arbeitenB);
	    this.add(hilfeB);
	    this.add(casinoB);
	    this.add(miningB);
	    this.add(exitB);
		this.add(moneyLabel);
  	}
  
  public int showMe(boolean b) {
    this.setVisible(b);
    return idW;
  }
  
  
}
