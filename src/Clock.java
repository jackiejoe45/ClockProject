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

    public Clock(){
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
    }
    public Clock(int seconds,int minutes,int hours){
        this.seconds+= seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;

        this.minutes+= minutes % MINUTESINHOUR;
        this.hours+= minutes/MINUTESINHOUR;

        this.hours += hours;

    }
    public Clock(double seconds,double minutes,double hours){
        this.seconds += seconds % SECONDSINMINUTE;
        this.minutes+= seconds / SECONDSINMINUTE;
        this.hours+= seconds / SECONDSINHOUR;

        this.minutes += (int)minutes % MINUTESINHOUR;
        this.hours+= (int)minutes/MINUTESINHOUR;
        double secs = (minutes - (int)minutes);
        this.seconds = (int) (SECONDSINMINUTE * secs);

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
    }
    public void addHours(double hours){
        this.dayOfMonth+=hours /HOURSINDAY;
        this.hours+=hours % MINUTESINHOUR;
        double mins = (hours - (int)hours);
        this.minutes = (int) (MINUTESINHOUR * mins);

    }
    public String getTime(){
        return "Current Time is (HH:MM:SS) - "
                + getHours()+":"
                + getMinutes()+":"
                + getSeconds();
    }
}
