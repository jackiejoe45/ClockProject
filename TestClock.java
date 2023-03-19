public class TestClock {
    public static void main(String[] args){
        Clock digital = new Clock(901,600,34);
        Clock analog1 = new Clock(920,600.65,37.5);
        Clock analog2 = new Clock(920,600.65,37.5);
        analog1.setIs24HourClock(true);
        analog2.setIs24HourClock(false);
        System.out.println(digital.getTime());
        System.out.println(analog1.getTime());
        System.out.println(analog2.getTime());
    }
}
