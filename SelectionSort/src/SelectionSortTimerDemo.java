import java.util.*;

public class SelectionSortTimerDemo {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
//         System.out.print("Enter array size: ");
//         int n = in.nextInt();
        for (int n = 1000; n <= 20000; n = n + 1000) {
            int [] a = ArrayUtil.randomIntArray(n, 100);
            Sorter sorter = new Sorter(a);
            StopWatch timer = new StopWatch();
            
            timer.start();
            sorter.sort();
            timer.stop(); 
            
            System.out.println(" Items: " + n + "  Elapsed time: "+ timer.getElapsedTime() + " milliseconds.");
            in.close();  
        }
    }
}