public class Sorter
{
    private int[] a;

    public Sorter(int[] anArray)
    {
        a = anArray;
    }

    /**
    Sorts the array managed by this selection sorter.
     */
    public void sort()
    {  
        for (int current = 0; current < a.length; current++)  // go thru the list of values 
        {  
            int pos = current;
            for (int k = current + 1; k < a.length; k++)
            {
                if (a[k] > a[pos]) 
                    pos = k;
            } 
            int temp = a[pos];
            a[pos] = a[current];
            a[current] = temp;
        }
    }
    
    public int[] getSorted()
    {  
        sort();
        return a;
    }

    private int miniumumPosition(int from)  // find the smallest value at index from + 1 to end
    {  
        int minPos = from;
        for (int k = from + 1; k < a.length; k++)
            if (a[k] < a[minPos]) 
                minPos = k;
        return minPos;
    }

    /**
    Swaps two entries of the array.
    @param i the first position to swap
    @param j the second position to swap
     */
    private void swap(int i, int j)      //swap the item at i with the item at j
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}