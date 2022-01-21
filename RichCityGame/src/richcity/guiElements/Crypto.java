package richcity.guiElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import richcity.core.MoneyTracker;
import richcity.subGuiElements.GraphPanel;
import richcity.tools.ResizeElements;

public class Crypto extends JFrame{

	private static final long serialVersionUID = 1L;
	ArrayList<Integer[]> bitcoinVal;
	ArrayList<Integer[]> ethVal;
	ArrayList<Integer[]> dodgeVal;
	GraphPanel bitcoinGraph;
	GraphPanel ethGraph;
	GraphPanel dodgeGraph;
	int idW = 4;
	
	public Crypto(int width, int height, MoneyTracker money) {
		
		this.setLayout(null);
		
		bitcoinVal 	= new ArrayList<Integer[]>();
		ethVal 		= new ArrayList<Integer[]>();
		dodgeVal 	= new ArrayList<Integer[]>();
		
		bitcoinGraph 	= new GraphPanel(bitcoinVal, 370, 220);
		ethGraph 		= new GraphPanel(ethVal, 370, 220);
		dodgeGraph 		= new GraphPanel(dodgeVal, 370, 220);
		
		/*
		 * Panel Settings
		 */
		bitcoinGraph.setLocation(width/2 + 20, 20);
		ethGraph.setLocation(width/2 + 20, 275);
		dodgeGraph.setLocation(width/2 + 20, 530);
		
		/*
		 * Bet Amount Entries
		 */
		JTextField amountBitcoin = new JTextField(20);
		amountBitcoin.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountBitcoin.setSize(108, 60);
		amountBitcoin.setForeground(Color.WHITE);
		amountBitcoin.setBackground(Color.black);
		amountBitcoin.setVisible(true);
		amountBitcoin.setLocation((width/2)-200,(height/2)-250);
		
		JTextField amountEth = new JTextField(20);
		amountEth.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountEth.setSize(108, 60);
		amountEth.setForeground(Color.WHITE);
		amountEth.setBackground(Color.black);
		amountEth.setVisible(true);
		amountEth.setLocation((width/2)-200,(height/2));
		
		JTextField amountDodge = new JTextField(20);
		amountDodge.setFont(new Font("Fixedsys Standard", Font.BOLD, 25));
		amountDodge.setSize(108, 60);
		amountDodge.setForeground(Color.WHITE);
		amountDodge.setBackground(Color.black);
		amountDodge.setVisible(true);
		amountDodge.setLocation((width/2)-200,(height/2)+250);
		
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
	}

	
	public int showMe(boolean b) {
		this.setVisible(b);
		return idW;
	}
}
