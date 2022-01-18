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

import richcity.tools.ImagePanel;
import richcity.tools.ResizeElements;

public class StartWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	public StartWindow(int width, int height) {
		JLabel logo = new JLabel();
		JButton startB = new JButton(ResizeElements.resizeIcon("assets/startWindow/start-button.png", 250, 70));
		JButton infoB = new JButton(ResizeElements.resizeIcon("assets/startWindow/infos-button.png", 180, 55));
		
		logo.setBackground(Color.pink);
		logo.setOpaque(true);
		logo.setIcon(ResizeElements.resizeIcon("assets/startWindow/logo.png", 400, 150));
		logo.setSize(400, 200);
		logo.setVisible(true);
		logo.setLocation((width/2)-250,(height/2)-350);
		startB.setSize(250, 70);
		startB.setVisible(true);
		startB.setLocation((width/2)-125,(height/2)+50);
		infoB.setSize(180, 55);
		infoB.setVisible(true);
		infoB.setLocation((width/2)-90,(height/2)+150);
		
		try {
			BufferedImage bcImage = ImageIO.read(new File("assets/startWindow/background.jpg"));
			this.setContentPane(new ImagePanel(bcImage, 0, 0, width, height));
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
		this.add(startB);
		this.add(infoB);
		
		
	}
	
	public void showMe(boolean b) {
		this.setVisible(b);
	}
	
	
}
