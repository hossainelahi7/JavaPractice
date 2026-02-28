/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Duc Ta
 * @author: Anika Hossain Sharna
 * **********************************************
 */

package assignment02partB;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class Timer {

    //
    // Instance Data Fields
    //
    private TimeZone timeZone;

    //
    // Constructors
    //
    public Timer() {

        this.timeZone = TimeZone.getTimeZone("PST");
    }

    public Timer(String timeZoneId) {
        this.timeZone = TimeZone.getTimeZone(timeZoneId);
    }

    //
    // Static Methods
    //


    public static Timer setTimeZonePreference() {
        Timer timer=new Timer();
        System.out.println("Time Zone: "+timer.timeZone.getID());

        return timer;
    }

    //
    // Instance Methods
    //


    public String getTimeZoneFormatted() {
        return this.timeZone.getDisplayName() + " (" + this.timeZone.getID() + ")";
    }


    public String getChatTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss [SSS 'ms'] a z");
        sdf.setTimeZone(this.timeZone);
        return sdf.format(new Date());
    }
}