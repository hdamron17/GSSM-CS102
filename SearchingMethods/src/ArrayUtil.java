import java.util.*;

/**
 * 
 */
public class ArrayUtil
{

   private static Random generator = new Random();
   
   public static int[] randomIntArray(int length, int n)
   {
       int [] a = new int[length];
       for( int k = 0; k < a.length; k++)
       {
           a[k] = generator.nextInt(n);
        }
        return a;
    }
   
   /**
    * Generates a pre-sorted array (not for arrays larger than 250,000,000
    * @param length Length of array
    * @return Sorted array
    */
   public static int[] randomSortedArray(int length) {
//	   if(length > 250000000)
//		   length = 250000000;
	   int[] a = new int[length];
	   a[length - 1] = 1;
	   for(int k = a.length - 2; k >= 0 && a[k] < Integer.MAX_VALUE - 4; k--) {
		   a[k] = a[k+1] + generator.nextInt(4);
	   }
	   for(int k = 0; a[k] == 0; k++) {
		   a[k] = Integer.MAX_VALUE;
	   }
	   return a;
   }
}