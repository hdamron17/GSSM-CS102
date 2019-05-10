/**
 * Sorts arrays of various sizes and graphs the efficiency
 * @author Hunter Damron
 * //SorterTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SorterGraph extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		double y = 0, maxY = 0;
		int maxX = 420000, scaledX, scaledY, oldX = 0, 
				oldY = getHeight(), decrement = 20000, elapsedTime;
		int[] array;
		Sorter sorter;
		StopWatch timer;
		
		g2.setBackground(Color.GREEN);
		g2.clearRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.MAGENTA);
		g2.setStroke(new BasicStroke(3.0f));
		array = ArrayUtil.randomIntArray(maxX, 42);
		sorter = new Sorter(array);
		timer = new StopWatch();
		timer.start();
		sorter.sort();
		timer.stop();
		//maxX is given
		maxY = timer.getElapsedTime();
		oldX = getWidth();
		oldY = 0;
		elapsedTime = (int) maxY;
		
		for(int x = maxX - 100; x > 0; x -= decrement) {
			array = ArrayUtil.randomIntArray(x, 42);
			sorter = new Sorter(array);
			timer = new StopWatch();
			timer.start();
			sorter.sort();
			timer.stop();
			//x is given
			y = timer.getElapsedTime();
			scaledX = x * getWidth() / maxX;
			scaledY = (int) (getHeight() * (1 - y / maxY));
			g2.drawLine(oldX, oldY, scaledX, scaledY);
			oldX = scaledX; oldY = scaledY;
			if(x <= 100000)
				decrement = 10000;
			else if(x <= 20000) 
				decrement = 1000;
			else if(x <= 10000)
				decrement = 500;
			else if(x <= 5000)
				decrement = 100;
			else if(x <= 1000)
				decrement = 10;
		}
		g2.drawLine(oldX, oldY, 0, getHeight());
		g2.setFont(new Font(g2.getFont().getName(), Font.BOLD, 16));
		g2.drawString("Your 420000 element array was sorted in " + elapsedTime + " milliseconds. "
						+ "Here's a graph of sorting efficiency.", 50, 100);
	}
}
