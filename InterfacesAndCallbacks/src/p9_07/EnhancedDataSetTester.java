/**
 * Demos the EnhancedDataSet which measures Measurable objects
 * @author Hunter Damron
 * //EnhancedDataSetTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_07;

public class EnhancedDataSetTester {

	public static void main(String[] args) {		
		EnhancedDataSet data = new EnhancedDataSet();
		data.add(new ExampleMeasurable(18));
		data.add(new ExampleMeasurable(120));
		data.add(new ExampleMeasurable(42));
		
		System.out.println("Average Value: " + data.getAverage());
		System.out.println("Expected: 60.0\n");
		
		System.out.println("Maximum Value Object: " + data.getMaximum());
		System.out.println("Expected: ExampleMeasurable[value=120.0]\n");
		
		System.out.println("Minimum Value Object: " + data.getMinimum());
		System.out.println("Expected: ExampleMeasurable[value=18.0]");
	}
}
