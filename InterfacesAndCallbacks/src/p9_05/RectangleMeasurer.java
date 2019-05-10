/**
 * Implements Measurer to measure Rectangles based on area
 * @author Big Java
 * //RectangleMeasurer.java
 */
package p9_05;

import java.awt.Rectangle;

public class RectangleMeasurer implements Measurer<Rectangle> {
	public double measure(Rectangle x) {
		Rectangle rect = x;
		double area = rect.getWidth() * rect.getHeight();
		return area;
	}

}
