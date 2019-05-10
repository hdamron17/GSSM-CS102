/**
 * Demos the modified DataSet to compare Rectangles by 
 * 		minimum and maximum (modified from Big Java)
 * @author Hunter Damron (and Big Java)
 * //DataSetTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_05;

import java.awt.Rectangle;

public class DataSetTester {

	public static void main(String[] args) {		
		DataSet<Rectangle> data = 
				new DataSet<Rectangle>(new RectangleMeasurer());
		data.add(new Rectangle(5, 10, 20, 30));
		data.add(new Rectangle(10, 20, 30, 40));
		data.add(new Rectangle(20, 30, 5, 15));
		
		System.out.println("Average Area: " + data.getAverage());
		System.out.println("Expected: 625\n");
		
		System.out.println("Maximum area rectangle: " + data.getMaximum());
		System.out.println("Expected: "
				+ "java.awt.Rectangle[x=10,y=20,width=30,height=40]\n");
		
		System.out.println("Minimum area rectangle: " + data.getMinimum());
		System.out.println("Expected: "
				+ "java.awt.Rectangle[x=20,y=30,width=5,height=15]");
	}
}
