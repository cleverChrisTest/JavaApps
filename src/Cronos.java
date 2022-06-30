/**
 * A collection of time counters. 
 * @author cristian diaz
 */
public class Cronos {
    int hour, min, sec;

    public Cronos() {}

    public Cronos(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    
    /**
     * Counts from 00:00:00 to 23:59:59.
     */
    public void countup(){
        
        while(true){
            System.out.format("%02d", hour);
            System.out.format(":%02d:", min);
            System.out.format("%02d%n", sec);
            sec++;
            timer(1000);
            if(sec == 60){
                min++;
                sec = 0;
            }
            if(min == 60){
                hour++;
                min = 0;
            }
            if(hour == 24){
                break;
            }
        }
    }
    
    /**
     * Counts down from the introduced time.
     * @param hr
     * @param mn
     * @param sc 
     */
    public void countDown(int hr, int mn, int sc) {
        hour = hr;
        min = mn;
        sec = sc;

        while (true) {
            sec--;
            //timer(1000);
            if (hour > 0 && min == 0 && sec < 0) {
                hour--;
                min = 59;
                sec = 59;
            } else if (hour > 0 && min > 0 && sec < 0) {
                min--;
                sec = 59;
            } else if (hour == 0 && min > 0 && sec < 0){
                min--;
                sec = 59;
            } else if (hour == 0 && min == 0 && sec == 0) {
                printTime(hour, min, sec);
                break;
            }
            printTime(hour, min, sec);
        }
    }
    
    /**
     * Prints the time in a specific pattern.
     * @param hour
     * @param min
     * @param sec 
     */
    public void printTime(int hour, int min, int sec){
        System.out.format("%02d", hour);
        System.out.format(":%02d:", min);
        System.out.format("%02d%n", sec);
    }
    
    /**
     * The program wait the specified milliseconds for the next step.
     * @param ms 
     */
    public void timer(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
    
    /**
     * Adds the time to the fields without overflowing. For example if you add
     * 30 min to 40 min it will give you 1 hour and 10 min.
     * @param hr
     * @param mn
     * @param sc 
     */
    public void addTime(int hr, int mn, int sc){
        hour += hr;
        min += mn;
        sec += sc;
        
        if(sec >= 60){
            min++;
            sec -= 60;
        }
        if(min >= 60){
            hour++;
            min -= 60;
        }
        if(hour > 24){
            hour -= 24;
        }
    }
    
    /**
     * Formatted getter.
     */
    public void giveTime(){
        printTime(hour, min, sec);
    }
}
