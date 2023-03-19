Sure! Here's the updated code with comments using the `@param` and `/**` styles:

        ```java
// importing the DecimalFormat class for formatting the output
import java.text.DecimalFormat;

/**
 * Represents a clock that stores and manipulates time
 */
public class Clock {

    // instance variables to store seconds, minutes, hours, day of month, month, and year
    private int seconds;
    private int minutes;
    private int hours;
    private int dayOfMonth;
    private int month;
    private int year;

    // constants for seconds, minutes, and hours
    public static final int SECONDSINMINUTE = 60 ;
    public static final int SECONDSINHOUR = 3600;
    public static final int SECONDSINDAY = 84600;
    public static final int MINUTESINHOUR = 60;
    public static final int MINUTESINDAY= 1440;
    public static final int HOURSINDAY=24;
    public static final int HOUR12CLOCK= 12;
    public static final int HOUR24CLOCK=24;

    // boolean to represent if the clock is on 24-hour format
    private boolean is24HourClock = false;

    /**
     * Default constructor that initializes seconds, minutes, and hours to zero
     */
    public Clock(){
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }

    /**
     * Constructor that sets the time of the clock from parameters
     * @param seconds the seconds of the time
     * @param minutes the minutes of the time
     * @param hours the hours of the time
     */
    public Clock(int seconds,int minutes,int hours){
        // calculate seconds
        this.seconds+= seconds % SECONDSINMINUTE;
        // calculate minutes
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+= seconds /SECONDSINDAY;

        // calculate minutes
        this.minutes+= minutes % MINUTESINHOUR;
        this.hours+= minutes/MINUTESINHOUR;
        this.dayOfMonth+= minutes/MINUTESINDAY;

        // calculate hours
        this.hours += hours % HOURSINDAY;
        this.dayOfMonth += hours/HOURSINDAY;
    }

    /**
     * Constructor that sets the time of the clock from parameters in double format
     * @param seconds the seconds of the time
     * @param minutes the minutes of the time
     * @param hours the hours of the time
     */
    public Clock(double seconds,double minutes,double hours){
        // calculate seconds
        this.seconds += seconds % SECONDSINMINUTE;
        // calculate minutes
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+= seconds /SECONDSINDAY;

        // calculate day of month and minutes
        this.dayOfMonth+= minutes/MINUTESINDAY;
        this.minutes += (int)minutes % MINUTESINHOUR;
        this.hours+= (int)minutes/MINUTESINHOUR;
        double secs = (minutes - (int)minutes);
        this.seconds = (int) (SECONDSINMINUTE * secs);

        // calculate day of month, hours, and minutes
        this.dayOfMonth += hours/HOURSINDAY;
        this.hours+=hours % MINUTESINHOUR;
        double mins = (hours - (int)hours);
        this.minutes = (int) (MINUTESINHOUR * mins);

        // calculate hours
        this.hours += hours;
    }

    // getter methods for instance variables
    public int getSeconds() {
        return seconds;
    }
    public int getMinutes() {
        return minutes;
    }
    public int getHours() {
        return hours;
    }
    public int getDayOfMonth() {
        return dayOfMonth;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    /**
     * Returns whether the clock is on 24-hour format
     * @return <code>true</code> if the clock is on 24-hour format, <code>false</code> otherwise
     */
    public boolean isIs24HourClock() {
        return is24HourClock;
    }

    /**
     * Sets whether the clock is on 24-hour format
     * @param is24HourClock <code>true</code> if the clock should be on 24-hour format, <code>false</code> otherwise
     */
    public void setIs24HourClock(boolean is24HourClock) {
        this.is24HourClock = is24HourClock;
    }

    // setter methods for instance variables
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Adds seconds to the clock
     * @param seconds the number of seconds to add
     */
    public void addSeconds(int seconds){
        this.seconds+= seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+=seconds/ SECONDSINDAY;
    }

    /**
     * Adds minutes to the clock
     * @param minutes the number of minutes to add
     */
    public void addMinutes(int minutes){
        this.minutes+= minutes % MINUTESINHOUR;
        this.hours+= minutes/MINUTESINHOUR;
    }

    /**
     * Overloaded method that adds decimal minutes to the clock
     * @param minutes the decimal minutes to add
     */
    public void addMinutes(double minutes){
        this.dayOfMonth+=minutes/MINUTESINDAY;
        this.minutes+= (int)minutes % MINUTESINHOUR;
        this.hours+= (int)minutes/MINUTESINHOUR;
        double secs = (minutes - (int)minutes);
        this.seconds = (int) (SECONDSINMINUTE * secs);
    }

    /**
     * Adds hours to the clock
     * @param hours the number of hours to add
     */
    public void addHours(int hours){
        this.hours+=hours % MINUTESINHOUR;
        this.dayOfMonth+=hours /HOURSINDAY;
        checkHours();
    }

    /**
     * Overloaded method that adds decimal hours to the clock
     * @param hours the decimal hours to add
     */
    public void addHours(double hours){
        this.dayOfMonth+=hours /HOURSINDAY;
        this.hours+=hours % MINUTESINHOUR;
        double mins = (hours - (int)hours);
        this.minutes = (int) (MINUTESINHOUR * mins);
        checkHours();
    }

    /**
     * Returns the time in string format
     * @return the time in string format
     */
    public String getTime(){
        checkHours();
        // create a DecimalFormat object with 2 digits
        DecimalFormat twoDigitFormat = new DecimalFormat("00");
        return "Current Time is (HH:MM:SS) - "
                + twoDigitFormat.format(getHours())+":"
                + twoDigitFormat.format(getMinutes())+":"
                + twoDigitFormat.format(getSeconds());
    }

    // method to check if the clock is on 24-hour format
    // if it is, adjust the hours accordingly
    private void checkHours(){
        if(is24HourClock)
        {
            this.dayOfMonth+=this.hours / HOUR24CLOCK;
            this.hours = this.hours % HOUR24CLOCK;
        }
        else
        {
            this.dayOfMonth+=this.hours / HOUR12CLOCK;
            this.hours = this.hours % HOUR12CLOCK;
        }
    }
}
