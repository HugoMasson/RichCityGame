package richcity.tools;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JComponent {
	private static final long serialVersionUID = 1L;
	private Image image;
	private int targetWidth, targetHeight, sPosX, sPosY;
    public ImagePanel(Image _image, int _sPosX, int _sPosY, int _targetWidth, int _targetHeight) {
        this.image = _image;
        this.sPosX = _sPosX;
        this.sPosY = _sPosY;
        this.targetWidth  = _targetWidth;
        this.targetHeight = _targetHeight;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(image, sPosX, sPosY, targetWidth, targetHeight, null);
        graphics2D.dispose();
        g.drawImage(resizedImage, sPosX, sPosY, this);
    }
}

