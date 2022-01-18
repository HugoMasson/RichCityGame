package richcity.guiElements;

import java.awt.Color;
import java.awt.Font;
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

	public CookieClicker(int width, int height, MoneyTracker money) {
		
		JLabel moneyLabel = new JLabel("0$");
		moneyLabel.setFont(new Font("Serif", Font.BOLD, 45));
		moneyLabel.setSize(100, 100);
		moneyLabel.setVisible(true);
		moneyLabel.setLocation((width/2)+300,(height/2)+100);
		JLabel logo = new JLabel();
		logo.setBackground(Color.red);
		logo.setOpaque(true);
		logo.setIcon(ResizeElements.resizeIcon("assets/cookieClicker/title.png", 500, 100));
		logo.setSize(500, 100);
		logo.setVisible(true);
		logo.setLocation((width/2)-250,(height/2)-260);
		JButton cookie = new JButton(ResizeElements.resizeIcon("assets/cookieClicker/cookie.png", 360, 360));
		cookie.setSize(360, 360);
		cookie.setVisible(true);
		cookie.setLocation((width/2)-180,(height/2)-150);
		cookie.setOpaque(false);
		cookie.setContentAreaFilled(false);
		cookie.setBorderPainted(false);
		
		cookie.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	money.addMoney(1);
		        moneyLabel.setText(money.getMoney()+"$");
		    }
		});
		
		JButton back = new JButton(ResizeElements.resizeIcon("assets/cookieClicker/back-button.png", 180, 55));
		back.setSize(180, 55);
		back.setVisible(true);
		back.setLocation((width/2)-400,(height/2)+150);
		
		back.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//change  JFrame create class to handle that
		    }
		});
		
		try {
			BufferedImage bcImage = ImageIO.read(new File("assets/cookieClicker/cookieclicker-background.png"));
			this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height-30));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		this.setTitle("Rich City");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.add(logo);
		this.add(cookie);
		this.add(back);
		this.add(moneyLabel);
	}
	
	public void showMe(boolean b) {
		this.setVisible(b);
	}
}
