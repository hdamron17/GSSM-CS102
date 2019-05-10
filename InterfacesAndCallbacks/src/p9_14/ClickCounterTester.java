/**
 * Demos ClickCounter in a JFrame
 * @author Hunter Damron
 * //ClickCounterTester.java
 * //Honor Code: I neither gave nor received any unauthorized help 
 * 		on this assignment
 */
package p9_14;

import javax.swing.JFrame;

public class ClickCounterTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ClickCounter button = new ClickCounter();
		frame.setSize(250, 60);
		frame.setResizable(false);
		frame.setTitle("Click Counter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button);
		frame.setVisible(true);
	}
}
