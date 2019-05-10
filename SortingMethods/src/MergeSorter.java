/**
   This class sorts an array, using the merge sort algorithm.
 */
public class MergeSorter extends Sorter{
	private int visitCount;

	/**
      Constructs a merge sorter.
      @param anArray the array to sort
	 */
	public MergeSorter(int[] array)
	{
		super(array);
	}

	/**
      Sorts the array managed by this merge sorter.
	 * @return 
	 */
	public int[] sort() {  
		if (array.length <= 1) return array;
		int[] first = new int[array.length / 2];
		int[] second = new int[array.length - first.length];
		System.arraycopy(array, 0, first, 0, first.length);
		visitCount += 2 * first.length;
		System.arraycopy(array, first.length, second, 0, second.length);
		visitCount += 2 * second.length;
		MergeSorter firstSorter = new MergeSorter(first);
		MergeSorter secondSorter = new MergeSorter(second);
		firstSorter.sort();
		secondSorter.sort();
		visitCount += firstSorter.getVisitCount();
		visitCount += secondSorter.getVisitCount();
		merge(first, second);
		return array;
	}

	/**
      Merges two sorted arrays into the array managed by this
      merge sorter. 
      @param first the first sorted array
      @param second the second sorted array
	 */
	private void merge(int[] first, int[] second) {  
		// Merge both halves into the temporary array

		int iFirst = 0;
		// Next element to consider in the first array
		int iSecond = 0;
		// Next element to consider in the second array
		int j = 0; 
		// Next open position in a

		// As long as neither iFirst nor iSecond past the end, move
		// the smaller element into a
		while (iFirst < first.length && iSecond < second.length) {  
			if (first[iFirst] < second[iSecond]) {  
				array[j] = first[iFirst];
				iFirst++;
			}
			else {  
				array[j] = second[iSecond];
				iSecond++;
			}
			j++;
			visitCount += 4;
		}

		// Note that only one of the two calls to arraycopy below
		// copies entries

		// Copy any remaining entries of the first array
		System.arraycopy(first, iFirst, array, j, first.length - iFirst);
		visitCount += 2 * (first.length - iFirst);

		// Copy any remaining entries of the second half
		System.arraycopy(second, iSecond, array, j, second.length - iSecond);
		visitCount += 2 * (second.length - iSecond);
	}

	public int getVisitCount() {
		return visitCount; 
	}
}