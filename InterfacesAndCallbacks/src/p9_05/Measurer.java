/**
 * Measures the value of specific class
 * @author Big Java
 * //Measurable.java
 */
package p9_05;

public interface Measurer<E> {
	double measure(E x);
}
