/**
 * This is a JButton which counts the number of times it is clicked
 * @author Hunter Damron
 * //ClickCounter.java
 * //Honor Code: I neither gave nor received any unauthorized help 
 * 		on this assignment
 */
package p9_14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClickCounter extends JButton implements ActionListener{
	private int n;
	
	/**
	 * Constructs ClickCounter button and sets it to be visible
	 */
	public ClickCounter() {
		addActionListener(this);
		setText("Click me! I haven't been clicked yet.");
		setVisible(true);
	}
	
	/**
	 * Gets the number of times the button has been clicked
	 * @return Returns number of clicks
	 */
	public int numClicks() {
		return n;
	}
	
	/**
	 * Method from ActionListener interface increments number of 
	 * clicks and updates button name
	 */
	public void actionPerformed(ActionEvent event) {
		n++;
		setText("Click me! I've been clicked " + n + " times!");
	}

}
