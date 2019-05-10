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
}