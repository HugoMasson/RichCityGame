package richcity.core;

import richcity.guiElements.CookieClicker;
import richcity.guiElements.StartWindow;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		MoneyTracker money = new MoneyTracker();
		//int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		//int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		//StartWindow sw = new StartWindow(1000, 600);
		//sw.showMe(true);

		CookieClicker cc = new CookieClicker(1000, 600, money);
		cc.showMe(true);
	}

}
