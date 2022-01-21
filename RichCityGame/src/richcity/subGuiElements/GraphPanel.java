package richcity.subGuiElements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	int width, height;
	ArrayList<Integer[]> values;
	Random rand;
	final static float dash1[] = {10.0f};
	final static BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
	
	public GraphPanel(ArrayList<Integer[]> _values, int width, int height) {	//values = 5,-2,2,-3,4 -> 5 value / -2 & 2 size of the rect / -3 & 4 size line
		
		this.width  = width;
		this.height = height;
		this.values = _values;
		
		//update graph
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            public void run() {
            	int ba = -rInt(5,30);
            	int bb = rInt(5,30);
            	Integer[] arr = {rInt(0,height),ba,bb,rInt(10,40),rInt(10,40)};
            	values.add(arr);
            	repaint();
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
        
        this.setSize(width, height);
	}
	
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.green);
		if(values.size() > 45) {
			values = new ArrayList<Integer[]>();
		}
		for(int i = 0; i < values.size(); i++) {
			if(i > 0 && values.get(i)[0] < values.get(i-1)[0]) {
				g.setColor(Color.red);
			} else {
				g.setColor(Color.green);
			}
			Integer[] cv = values.get(i);
			g.fillRect(8*i, -cv[2]-cv[0]+(height), 5, cv[2]-cv[1]);
			g.drawLine(8*i+2, -cv[4]-cv[0]+(height), 8*i+2, cv[3]-cv[0]+(height));
			if(i > 0) {
				//g.setColor(Color.darkGray);
				//g.drawLine(8*(i-1)+5, height-values.get(i-1)[0], 8*i, height-cv[0]);
			}
		}
		
	}
	
	public int rInt(int min, int max) {
		return min + (int)(Math.random() * ((max - min) + 1));
	}
	
}
