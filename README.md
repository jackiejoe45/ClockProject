## JavaClockProject
This is a class called "Clock" which has various properties and methods to represent and manipulate time.


## Properties:

seconds: an integer representing the seconds in the current time
minutes: an integer representing the minutes in the current time
hours: an integer representing the hours in the current time
dayOfMonth: an integer representing the day of the month
month: an integer representing the month
year: an integer representing the year
is24HourClock: a boolean indicating whether the clock is in 24-hour or 12-hour format

## Constants:

SECONDSINMINUTE: number of seconds in a minute
SECONDSINHOUR: number of seconds in an hour
SECONDSINDAY: number of seconds in a day
MINUTESINHOUR: number of minutes in an hour
MINUTESINDAY: number of minutes in a day
HOURSINDAY: number of hours in a day
HOUR12CLOCK: number of hours in a 12-hour clock
HOUR24CLOCK: number of hours in a 24-hour clock

## Methods:

<p>Clock(): a default constructor which initializes seconds, minutes, and hours to 0
</p><p>Clock(int seconds, int minutes, int hours): a constructor which takes seconds, minutes, and hours as parameters and initializes the corresponding properties
</p><p>Clock(double seconds, double minutes, double hours): a constructor which takes seconds, minutes, and hours as parameters and initializes the corresponding properties. The parameters are treated as decimal fractions of the corresponding unit of time.
</p><p>getSeconds(), getMinutes(), getHours(), getDayOfMonth(), getMonth(), getYear(): getter methods for the corresponding properties
</p><p>isIs24HourClock(), setIs24HourClock(boolean is24HourClock): getter and setter methods for the is24HourClock property
</p><p>setSeconds(int seconds), setMinutes(int minutes), setHours(int hours), setDayOfMonth(int dayOfMonth), setMonth(int month), setYear(int year): setter methods for the corresponding properties
</p><p>addSeconds(int seconds), addMinutes(int minutes), addMinutes(double minutes), addHours(int hours), addHours(double hours): methods to add the given amount of time to the corresponding properties. The addMinutes(double minutes) and addHours(double hours) methods accept decimal fractions of the corresponding unit of time.
</p><p>getTime(): a method which returns a string representing the current time in a format of "HH:MM:SS". Also, checks the hours to convert it from 24-hour to 12-hour format if needed.
</p><p>checkHours(): a method which checks the hours and converts them from 24-hour to 12-hour format if the is24HourClock property is false. It also adjusts the dayOfMonth property accordingly.

