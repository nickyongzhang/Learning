public class BarkingDog {
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (barking && (hourOfDay >= 0 && hourOfDay < 8) || (hourOfDay<=23 && hourOfDay > 22)) {
            return true;
        } else {
            return false;
        }
    }
}
