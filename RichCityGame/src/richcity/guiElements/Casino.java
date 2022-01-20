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
import javax.swing.JTextField;

import richcity.core.MoneyTracker;
import richcity.tools.ImagePanel;
import richcity.tools.ResizeElements;

public class Casino  extends JFrame {

	private static final long serialVersionUID = 1L;
	int betAmount;
	int winRate;
	int idW = 5;
	
	public Casino(int width , int height, MoneyTracker money) {
		betAmount = 0;
		winRate = 33;	//in percent
		JTextField amountToBet = new JTextField(20);
		amountToBet.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountToBet.setSize(108, 60);
		amountToBet.setForeground(Color.WHITE);
		amountToBet.setBackground(Color.black);
		amountToBet.setVisible(true);
		amountToBet.setLocation((width/2)+380,(height/2)+118);
		/*
		 * moneyLabel Settings
		 */
		JLabel moneyLabel = new JLabel(money.getMoney()+"-$");
		moneyLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 45));
		moneyLabel.setSize(200, 100);
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setVisible(true);
		moneyLabel.setLocation((width/2)+290,(height/2)+170);
		
		/*
		 * Bet Buttons
		 */
		JButton red = new JButton(ResizeElements.resizeIcon("assets/casino/button-red.png", 180, 250));
		red.setBackground(Color.red);
		red.setSize(180, 250);
		red.setVisible(true);
		red.setLocation((width/2)-215,(height/2)-110);
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				betAmount = tryToConvTextToInt(amountToBet.getText());	//positive int or -1 if invalid entry
				if(money.getMoney() >= betAmount) {
					if(betAmount != -1) {
						if((int)(Math.random() * (100)) < winRate) {	//win bet
							money.addMoney(betAmount*2);
						} else {										//lost bet
							money.addMoney(-betAmount);
						}
						moneyLabel.setText(money.getMoney()+"-$");
					}
				}
			}
		});
		
		JButton black = new JButton(ResizeElements.resizeIcon("assets/casino/button-black.png", 180, 250));
		black.setBackground(Color.red);
		black.setSize(180, 250);
		black.setVisible(true);
		black.setLocation((width/2)+30,(height/2)-110);
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				betAmount = tryToConvTextToInt(amountToBet.getText());	//positive int or -1 if invalid entry
				if(money.getMoney() >= betAmount) {
					if(betAmount != -1) {
						if((int)(Math.random() * (100)) < winRate) {	//win bet
							money.addMoney(betAmount*2);
						} else {								//lost bet
							money.addMoney(-betAmount);
						}
						moneyLabel.setText(money.getMoney()+"-$");
					}
				}
			}
		});
		
		/*
		 * set background
		 */
		try {
			BufferedImage bcImage = ImageIO.read(new File("assets/casino/casino.png"));
			this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height-30));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		this.setTitle("Rich City - Casino");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		
		this.add(red);
		this.add(black);
		this.add(amountToBet);
		this.add(moneyLabel);
	}

	public int tryToConvTextToInt(String txt) {
		
		try{
			int nbr = Integer.parseInt(txt);
			if(nbr > 0) {
				return Integer.parseInt(txt);
			} 
        } catch (NumberFormatException ex){
            ex.printStackTrace();
            
        }return -1;
	}
	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
}
