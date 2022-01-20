/**
 * @ author 
 * ▀▀█▀▀ ▀█▀ ▒█▀▄▀█ 　 ▒█░▒█ ▒█▀▀▀ ▒█▀▀▀ ▒█▀▀█ ▒█▀▀▀ 
 *░ ▒█░░ ▒█░ ▒█▒█▒█ 　 ▒█▀▀█ ▒█▀▀▀ ▒█▀▀▀ ▒█▄▄▀ ▒█▀▀▀ 
 * ░▒█░░ ▄█▄ ▒█░░▒█ 　 ▒█░▒█ ▒█▄▄▄ ▒█▄▄▄ ▒█░▒█ ▒█▄▄▄
 * @projectname RichCity
 * 
 * @setting RichCity spielt in New York, da jeder versucht Reich in dieser Stadt zu werden
 * @copy
 *
 */

package richcity.core;
import richcity.guiElements.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		int currentlyOpen = 0;
		MoneyTracker money = new MoneyTracker();
		StartWindow sw = new StartWindow(1000, 600, money);
		InfoWindow iw = new InfoWindow(1000, 600);
		HelpWindow hw = new HelpWindow(1000, 600, money);
		CookieClicker cc = new CookieClicker(1000, 600, money);
		Casino ca = new Casino(1000, 600, money);
		GameOverWindow gow = new GameOverWindow(1000, 600, money);
		
		//timer
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int countdownStarter = 600;	//10 mins
            public void run() {
                countdownStarter--;
                if (countdownStarter < 0) {
                    System.out.println("Game Over!");
                    sw.showMe(false);iw.showMe(false);hw.showMe(false);cc.showMe(false);ca.showMe(false);
                    gow.showMe(true);
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    
	    // Start Screen
	    //StartWindow sw = new StartWindow(1000, 600, money);
	    //sw.showMe(true);
	    
	    // Info Screen
	    //InfoWindow iw = new InfoWindow(1000, 600);
	    //iw.showMe(true);
	    
	    
	    // Help Screen
	    //HelpWindow hw = new HelpWindow(1000, 600, money);
	    //hw.showMe(true);
	    
	    // Cookie Clicker Screen
	    //CookieClicker cc = new CookieClicker(1000, 600, money);
	    //cc.showMe(true);
	    
        currentlyOpen = ca.showMe(true);
  	}

}