package richcity.guiElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import richcity.core.MoneyTracker;
import richcity.subGuiElements.GraphPanel;
import richcity.tools.ResizeElements;
import richcity.tools.TypeConvertor;

public class Crypto extends JFrame{

	private static final long serialVersionUID = 1L;
	ArrayList<Integer[]> bitcoinVal;
	ArrayList<Integer[]> ethVal;
	ArrayList<Integer[]> dodgeVal;
	GraphPanel bitcoinGraph;
	GraphPanel ethGraph;
	GraphPanel dodgeGraph;
	int idW = 4;
	
	double owned_BTC;
	double owned_ETH;
	double owned_DODGE;
	
	public Crypto(int width, int height, MoneyTracker money) {
		
		DecimalFormat df = new DecimalFormat("#.####");
		df.setRoundingMode(RoundingMode.CEILING);
		
		this.setLayout(null);
		
		//get crypto wallet
		owned_BTC	= money.getBTC();
		owned_ETH	= money.getETH();
		owned_DODGE	= money.getDODGE();
		
		bitcoinVal 	= new ArrayList<Integer[]>();
		ethVal 		= new ArrayList<Integer[]>();
		dodgeVal 	= new ArrayList<Integer[]>();
		
		bitcoinGraph 	= new GraphPanel(bitcoinVal, 370, 220, 30000, 2000.0);
		ethGraph 		= new GraphPanel(ethVal, 370, 220, 3000, 400.0);
		dodgeGraph 		= new GraphPanel(dodgeVal, 370, 220, 10, 0.5);
		
		/*
		 * Panel Settings
		 */
		bitcoinGraph.setLocation(width/2 + 20, 20);
		ethGraph.setLocation(width/2 + 20, 275);
		dodgeGraph.setLocation(width/2 + 20, 530);
		
		/*
		 * Labels crypto / money
		 */
		JLabel moneyLabel = new JLabel(money.getMoney()+"-$");
		moneyLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		moneyLabel.setSize(250, 100);
		moneyLabel.setForeground(Color.BLACK);
		moneyLabel.setVisible(true);
		moneyLabel.setLocation((width/2)-400,(height/2)+290);
		
		JLabel btcLabel = new JLabel(money.getBTC()+"-BTC");
		btcLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 20));
		btcLabel.setSize(500, 100);
		btcLabel.setForeground(Color.BLACK);
		btcLabel.setVisible(true);
		btcLabel.setLocation((width/2)-450,(height/2)-350);
		
		JLabel ethLabel = new JLabel(money.getETH()+"-ETH");
		ethLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 20));
		ethLabel.setSize(500, 100);
		ethLabel.setForeground(Color.BLACK);
		ethLabel.setVisible(true);
		ethLabel.setLocation((width/2)-450,(height/2)-100);
		
		JLabel dodgeLabel = new JLabel(money.getDODGE()+"-DODGE");
		dodgeLabel.setFont(new Font("Fixedsys Standard", Font.BOLD, 20));
		dodgeLabel.setSize(500, 100);
		dodgeLabel.setForeground(Color.BLACK);
		dodgeLabel.setVisible(true);
		dodgeLabel.setLocation((width/2)-450,(height/2)+100);
		
		/*
		 * Bet Amount Entries
		 */
		JTextField amountBitcoin = new JTextField(20);
		amountBitcoin.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountBitcoin.setSize(108, 60);
		amountBitcoin.setForeground(Color.WHITE);
		amountBitcoin.setBackground(Color.black);
		amountBitcoin.setVisible(true);
		amountBitcoin.setLocation((width/2)-430,(height/2)-250);
		
		JTextField amountEth = new JTextField(20);
		amountEth.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountEth.setSize(108, 60);
		amountEth.setForeground(Color.WHITE);
		amountEth.setBackground(Color.black);
		amountEth.setVisible(true);
		amountEth.setLocation((width/2)-430,(height/2));
		
		JTextField amountDodge = new JTextField(20);
		amountDodge.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountDodge.setSize(108, 60);
		amountDodge.setForeground(Color.WHITE);
		amountDodge.setBackground(Color.black);
		amountDodge.setVisible(true);
		amountDodge.setLocation((width/2)-430,(height/2)+250);
		
		/*
		 * Buy / Sell buttons
		 */
		JButton buyBitcoin = new JButton("Buy");
		buyBitcoin.setSize(100, 60);
		buyBitcoin.setVisible(true);
		buyBitcoin.setLocation((width/2)-320,(height/2)-250);
		buyBitcoin.setOpaque(false);
		//buyBitcoin.setContentAreaFilled(false);
		//buyBitcoin.setBorderPainted(false);
		
		JButton buyEth = new JButton("Buy");
		buyEth.setSize(100, 60);
		buyEth.setVisible(true);
		buyEth.setLocation((width/2)-320,(height/2));
		buyEth.setOpaque(false);
		//buyEth.setContentAreaFilled(false);
		//buyEth.setBorderPainted(false);
		
		JButton buyDodge = new JButton("Buy");
		buyDodge.setSize(100, 60);
		buyDodge.setVisible(true);
		buyDodge.setLocation((width/2)-320,(height/2)+250);
		buyDodge.setOpaque(false);
		//buyDodge.setContentAreaFilled(false);
		//buyDodge.setBorderPainted(false);
		
		JButton sellBitcoin = new JButton("Sell");
		sellBitcoin.setSize(100, 60);
		sellBitcoin.setVisible(true);
		sellBitcoin.setLocation((width/2)-220,(height/2)-250);
		sellBitcoin.setOpaque(false);
		//buyBitcoin.setContentAreaFilled(false);
		//buyBitcoin.setBorderPainted(false);
		
		JButton sellEth = new JButton("Sell");
		sellEth.setSize(100, 60);
		sellEth.setVisible(true);
		sellEth.setLocation((width/2)-220,(height/2));
		sellEth.setOpaque(false);
		//buyEth.setContentAreaFilled(false);
		//buyEth.setBorderPainted(false);
		
		JButton sellDodge = new JButton("Sell");
		sellDodge.setSize(100, 60);
		sellDodge.setVisible(true);
		sellDodge.setLocation((width/2)-220,(height/2)+250);
		sellDodge.setOpaque(false);
		//buyDodge.setContentAreaFilled(false);
		//buyDodge.setBorderPainted(false);
		
		/*
		 * Button events
		 */
		
		buyBitcoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int invAmount = TypeConvertor.tryToConvTextToInt(amountBitcoin.getText());
				if(money.getMoney() >= invAmount) {
					if(invAmount != -1 && invAmount >= 50) {
						money.takeMoney(invAmount);
						money.addBTC(invAmount/bitcoinGraph.getLastValue());
						moneyLabel.setText(money.getMoney()+"-$");
						btcLabel.setText(money.getBTC()+"-BTC");
						amountBitcoin.setText("");
					}
				}
			}
		});
		
		buyEth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int invAmount = TypeConvertor.tryToConvTextToInt(amountEth.getText());
				if(money.getMoney() >= invAmount) {
					if(invAmount != -1 && invAmount >= 50) {
						money.takeMoney(invAmount);
						money.addETH(invAmount/ethGraph.getLastValue());
						moneyLabel.setText(money.getMoney()+"-$");
						ethLabel.setText(money.getETH()+"-ETH");
						amountEth.setText("");
					}
				}
			}
		});
		
		buyDodge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int invAmount = TypeConvertor.tryToConvTextToInt(amountDodge.getText());
				if(money.getMoney() >= invAmount) {
					if(invAmount != -1 && invAmount >= 50) {
						money.takeMoney(invAmount);
						money.addDODGE(invAmount/dodgeGraph.getLastValue());
						moneyLabel.setText(money.getMoney()+"-$");
						dodgeLabel.setText(money.getDODGE()+"-DODGE");
						amountDodge.setText("");
					}
				}
			}
		});
		
		sellBitcoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		sellEth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		sellDodge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		/*
		 * Window Settings
		 */
		this.setTitle("Rich City - Crypto Trader");
	    this.setIconImage(Toolkit.getDefaultToolkit().getImage("assets/general/icon.png"));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.add(bitcoinGraph);
		this.add(ethGraph);
		this.add(dodgeGraph);
		
		this.add(amountBitcoin);
		this.add(amountEth);
		this.add(amountDodge);
		
		this.add(buyBitcoin);
		this.add(buyEth);
		this.add(buyDodge);
		
		this.add(sellBitcoin);
		this.add(sellEth);
		this.add(sellDodge);
		
		this.add(moneyLabel);
		this.add(btcLabel);
		this.add(ethLabel);
		this.add(dodgeLabel);
	}

	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
}
