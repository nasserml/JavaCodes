package greetingthreadrunner;
import java.util.Date;
// A runnable that repeatedly prints greerting
public class GreetingRunnable implements Runnable {
    private static final int REPETITIONS = 10;
    private static final int DELAY = 1000;
    
    private String greeting;
    
    // Constructs the runnable objects
    // @param aGreating the greeting to display
    public GreetingRunnable(String aGreeting){
        greeting = aGreeting;
    }
    
    public void run()
    {
        try
        {
            for(int i = 1 ; i <= REPETITIONS ; i++){
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(DELAY);
            }
            
        }
        catch(InterruptedException exception)
        {
            
        }
    }
    
}
