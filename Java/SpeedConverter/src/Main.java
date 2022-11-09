public class Main {

    public static void main(String[] args) {

        long milesPerHour = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + milesPerHour);

        SpeedConverter.printConversion(10.5);
    }
}
