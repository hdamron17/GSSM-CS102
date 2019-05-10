/**

 */
public class InsertionSorter extends Sorter {

	public InsertionSorter(int[] array)
	{
		super(array);
	}

	/**
      Sorts the array managed by this insertion sorter.
	 */
	public int[] sort()
	{  
		for (int i = 1; i < array.length; i++)
		{

			int next = array[i];
			int j = i;
			while(j > 0 && array[j - 1] > next)
			{
				array[j] = array[j - 1];
				j--;
			}
			array[j] = next;
		}
		return array;
	}
}