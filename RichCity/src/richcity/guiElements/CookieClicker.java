package richcity.guiElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class CookieClicker extends JFrame{
	
	private static final long serialVersionUID = 1L;
	MoneyTracker money;
	int idW = 4;

	public CookieClicker(int width, int height, MoneyTracker money) {
		
		/*
		 * moneyLabel Settings
		 */
		JLabel moneyLabel = new JLabel("0.00,-$");
		moneyLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 45));
		moneyLabel.setSize(200, 100);
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setVisible(true);
		moneyLabel.setLocation((width/2)+290,(height/2)+170);
		
		/*
		 * logo Settings
		 */
		JLabel logo = new JLabel();
		logo.setBackground(Color.red);
		logo.setOpaque(false);
		logo.setIcon(ResizeElements.resizeIcon("assets/cookieClicker/title.png", 500, 120));
		logo.setSize(500, 100);
		logo.setVisible(true);
		logo.setLocation((width/2)-250,(height/2)-260);
		
		/*
		 * cookie Settings
		 */
		JButton cookie = new JButton(ResizeElements.resizeIcon("assets/cookieClicker/cookie.png", 240, 240));
		cookie.setSize(240, 240);
		cookie.setVisible(true);
		cookie.setLocation((width/2)-100,(height/2)-130);
		cookie.setOpaque(false);
		cookie.setContentAreaFilled(false);
		cookie.setBorderPainted(false);
		
		/* 
		 * cookie function ( 1 click = 1 �)
		 */
		cookie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				money.addMoney(1);
				moneyLabel.setText(money.getMoney()+"$");
			}
		});
				
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
		    	SelectGameWindow sgw = new SelectGameWindow(1000, 600, money);
				sgw.showMe(true);
				dispose();
		    }
		});
		
		/*
		 * set background
		 */
		try {
			BufferedImage bcImage = ImageIO.read(new File("assets/cookieClicker/cookieclicker-background.png"));
			this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height-30));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		/*
		 * Window Settings
		 */
		this.setTitle("Rich City - Cookie Clicker");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		/*
		 * Implement it.
		 */
		this.add(logo);
		this.add(cookie);
		this.add(backB);
		this.add(moneyLabel);
	}
	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
}
