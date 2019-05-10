/**
 * Modified version of the DataSet found in Big Java
 * 		Modified to find the minimum valued object
 * 		and use parameterization to prevent illegal casting
 * @author Hunter Damron (and Big Java)
 * //DataSet.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_05;

public class DataSet<E> {
	private double sum;
	private E maximum, minimum;
	private int count;
	private Measurer<E> measurer;
	
	public DataSet(Measurer<E> aMeasurer) {
		sum = 0;
		count = 0;
		maximum = null;
		minimum = null;
		measurer = aMeasurer;
	}
	
	public void add(E x) {
		sum += measurer.measure(x);
		if(count == 0 || measurer.measure(maximum) < measurer.measure(x))
			maximum = x;
		if(count == 0 || measurer.measure(minimum) > measurer.measure(x))
			minimum = x;
		count++;
	}
	
	public double getAverage() {
		if(count == 0) return 0;
		else return sum / count;
	}
	
	public Object getMaximum() {
		return maximum;
	}
	
	/**
	 * Addition to DataSet which allows the minimum object
	 * @return Returns object with minimum value
	 */
	public Object getMinimum() {
		return minimum;
	}
}
