/**
 * Extends DataSet to provide a default constructor which 
 * 		compares Measurable objects
 * @author Hunter Damron
 * //EnhancedDataSet.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package p9_07;

import p9_05.DataSet;
import p9_05.Measurer;

public class EnhancedDataSet extends DataSet<Measurable>{
	/**
	 * Default constructor implements measurable to accept all measurable objects
	 */
	public EnhancedDataSet() {
		super(new Measurer<Measurable>() {
			public double measure(Measurable x) {
				return x.getMeasure();
			}
		});
	}
}
