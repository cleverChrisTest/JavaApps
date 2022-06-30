/**
 * A collection of time counters. 
 * @author cristian diaz
 */
public class Cronos {
    byte hour, min, sec;

    public Cronos() {
    }
    
    /**
    * Counts from 00:00:00 to 23:59:59, hh:mm:ss.
    */
    public void countup() {
        byte i;
        
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
    
    public void printTime(byte hour, byte min, byte sec){
        System.out.format("%02d", hour);
        System.out.format(":%02d:", min);
        System.out.format("%02d%n", sec);
    }
  
    public void timer(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
}
