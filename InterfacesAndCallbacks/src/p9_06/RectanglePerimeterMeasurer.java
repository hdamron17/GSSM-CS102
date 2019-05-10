/**
 * Implements Measurer to measure perimeter of rectangles
 * @author Hunter Damron
 * //RectanglePerimeterMeasurer.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_06;

import java.awt.Rectangle;

import p9_05.Measurer;

public class RectanglePerimeterMeasurer implements Measurer<Rectangle> {
	/**
	 * Implementation of Measurer measure method to return perimeter
	 * 		(Must only accept Rectangles
	 * @return Returns the perimeter of the passed Rectangle
	 */
	public double measure(Rectangle x) {
		Rectangle rect = x;
		double perimeter = 2 * rect.getWidth() + 2 * rect.getHeight();
		return perimeter;
	}
}
