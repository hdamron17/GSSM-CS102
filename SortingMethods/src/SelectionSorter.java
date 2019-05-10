
public class SelectionSorter extends Sorter{
    public SelectionSorter(int[] array)
    {
        super(array);
    }

    /**
    Sorts the array managed by this selection sorter.
     */
    public int[] sort()
    {
        for (int current = 0; current < array.length; current++)  // go thru the list of values 
        {  
            int pos = current;
            for (int k = current + 1; k < array.length; k++)
            {
                if (array[k] < array[pos]) 
                    pos = k;
            } 
            int temp = array[pos];
            array[pos] = array[current];
            array[current] = temp;
        }
        return array;
    }
}
