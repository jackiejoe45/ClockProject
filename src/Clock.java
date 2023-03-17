import java.text.DecimalFormat;
public class Clock {
    private int seconds;
    private int minutes;
    private int hours;
    private int dayOfMonth;
    private int month;
    private int year;
    public static int SECONDSINMINUTE = 60 ;
    public static int SECONDSINHOUR = 3600;
    public static int SECONDSINDAY = 84600;
    public static int MINUTESINHOUR = 60;
    public static int MINUTESINDAY= 1440;
    public static int HOURSINDAY=24;
    public static int HOUR12CLOCK= 12;
    public static int HOUR24CLOCK=24;

    private boolean is24HourClock = false;

    public Clock(){
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }
    public Clock(int seconds,int minutes,int hours){
        this.seconds+= seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+= seconds /SECONDSINDAY;

        this.minutes+= minutes % MINUTESINHOUR;
        this.hours+= minutes/MINUTESINHOUR;
        this.dayOfMonth+= minutes/MINUTESINDAY;

        this.hours += hours % HOURSINDAY;
        this.dayOfMonth += hours/HOURSINDAY;

    }
    public Clock(double seconds,double minutes,double hours){
        this.seconds += seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+= seconds /SECONDSINDAY;

        this.dayOfMonth+= minutes/MINUTESINDAY;
        this.minutes += (int)minutes % MINUTESINHOUR;
        this.hours+= (int)minutes/MINUTESINHOUR;
        double secs = (minutes - (int)minutes);
        this.seconds = (int) (SECONDSINMINUTE * secs);

        this.dayOfMonth += hours/HOURSINDAY;
        this.hours+=hours % MINUTESINHOUR;
        double mins = (hours - (int)hours);
        this.minutes = (int) (MINUTESINHOUR * mins);

        this.hours += hours;

    }

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

    public boolean isIs24HourClock() {
        return is24HourClock;
    }

    public void setIs24HourClock(boolean is24HourClock) {
        this.is24HourClock = is24HourClock;
    }

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
    public void addSeconds(int seconds){
        this.seconds+= seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;
        this.dayOfMonth+=seconds/ SECONDSINDAY;
    }
    public void addMinutes(int minutes){
        this.minutes+= minutes % MINUTESINHOUR;
        this.hours+= minutes/MINUTESINHOUR;
    }
    public void addMinutes(double minutes){
        this.dayOfMonth+=minutes/MINUTESINDAY;
        this.minutes+= (int)minutes % MINUTESINHOUR;
        this.hours+= (int)minutes/MINUTESINHOUR;
        double secs = (minutes - (int)minutes);
        this.seconds = (int) (SECONDSINMINUTE * secs);
    }
    public void addHours(int hours){
        this.hours+=hours % MINUTESINHOUR;
        this.dayOfMonth+=hours /HOURSINDAY;
        checkHours();
    }
    public void addHours(double hours){
        this.dayOfMonth+=hours /HOURSINDAY;
        this.hours+=hours % MINUTESINHOUR;
        double mins = (hours - (int)hours);
        this.minutes = (int) (MINUTESINHOUR * mins);
        checkHours();

    }
    public String getTime(){
        checkHours();
        DecimalFormat twoDigitFormat = new DecimalFormat("00");
        return "Current Time is (HH:MM:SS) - "
                + twoDigitFormat.format(getHours())+":"
                + twoDigitFormat.format(getMinutes())+":"
                + twoDigitFormat.format(getSeconds());
    }
    public void checkHours(){
        if(is24HourClock == true)
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
