/**
 * Serves as an example for testing of EnhancedDataSet
 * @author Hunter Damron
 * //ExampleMeasurable.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_07;

public class ExampleMeasurable implements Measurable {
	private double x;
	
	public ExampleMeasurable(double value) {
		x = value;
	}
	
	public double getMeasure() {
		return x;
	}
	
	public String toString() {
		return "ExampleMeasurable[value=" + x + "]";
	}
}
