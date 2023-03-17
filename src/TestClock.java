public class TestClock {
    public static void main(String[] args){
        Clock digital = new Clock();
        Clock analog1 = new Clock(900,600.65,34.5);
        Clock analog2 = new Clock(900,600,34);
        System.out.println(digital.getTime());
        System.out.println(analog1.getTime());
        System.out.println(analog2.getTime());
        System.out.println(digital.getSeconds());
        System.out.println(digital.getMinutes());
        System.out.println(digital.getHours());
        System.out.println(digital.getDayOfMonth());
        System.out.println(digital.getMonth());
        System.out.println(digital.getYear());

    }
}
