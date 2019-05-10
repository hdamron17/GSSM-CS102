/**
 * Demos the RectanglePerimeterMeasurer by comparing rectangles 
 * 		based on perimeter instead of area
 * @author Hunter Damron
 * //DataSetPerimeterTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_06;

import java.awt.Rectangle;

import p9_05.DataSet;

public class DataSetPerimeterTester {

	public static void main(String[] args) {		
		DataSet<Rectangle> data = 
				new DataSet<Rectangle>(new RectanglePerimeterMeasurer());
		data.add(new Rectangle(5, 10, 20, 30));
		data.add(new Rectangle(10, 20, 30, 40));
		data.add(new Rectangle(20, 30, 5, 15));
		
		System.out.println("Average Perimeter: " + data.getAverage());
		System.out.println("Expected: 93.3\n");
		
		System.out.println("Maximum perimeter rectangle: " + data.getMaximum());
		System.out.println("Expected: "
				+ "java.awt.Rectangle[x=10,y=20,width=30,height=40]\n");
		
		System.out.println("Minimum perimeter rectangle: " + data.getMinimum());
		System.out.println("Expected: "
				+ "java.awt.Rectangle[x=20,y=30,width=5,height=15]");
	}

}
