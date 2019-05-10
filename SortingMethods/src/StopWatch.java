public class StopWatch
{
    private long elapsedTime;
    private long elapsedTimeNanos;
    private long startTime;
    private long startTimeNanos;
    private boolean isRunning;

    public StopWatch()
    {
        reset();
    }

    public void start()
    {
        if(isRunning)
            return;
        isRunning = true;
        startTime = System.currentTimeMillis();
        startTimeNanos = System.nanoTime();
    }

    public void stop()
    {
        if(!isRunning)
            return;
        isRunning = false;
        long endTimeNanos = System.nanoTime();
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
        elapsedTimeNanos = elapsedTimeNanos + endTimeNanos - startTimeNanos;
    }
    
    public 
    long getElapsedTime()
    {
        if (isRunning)
        {
            long endTime = System.currentTimeMillis();
            return elapsedTime + endTime - startTime;
        }
        else
            return elapsedTime;
    }
    
    public 
    long getElapsedTimeNanos()
    {
        if (isRunning)
        {
            long endTimeNanos = System.nanoTime();
            return elapsedTimeNanos + endTimeNanos - startTimeNanos;
        }
        else
            return elapsedTimeNanos;
    }

    public void reset()
    {
        elapsedTime = 0;
        elapsedTimeNanos = 0;
        isRunning = false;
    }
}
        