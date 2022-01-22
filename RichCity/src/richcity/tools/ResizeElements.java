package richcity.tools;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ResizeElements {
	
	public static Icon resizeIcon(String path, int w, int h) {
		Icon icon = new ImageIcon(path);
		Image startImg = ((ImageIcon) new ImageIcon(path)).getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(startImg);
		return icon;
	}
}
