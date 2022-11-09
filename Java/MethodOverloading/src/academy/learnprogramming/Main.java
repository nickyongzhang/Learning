package academy.learnprogramming;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {

	    int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();

        calcFeetAndInchesToCentimeters(6, 0);
        calcFeetAndInchesToCentimeters(-1, 1);
        double centimeters = calcFeetAndInchesToCentimeters(6, -1);
        if (centimeters == -1) {
            System.out.println("Invalid Parameters");
        }

        calcFeetAndInchesToCentimeters(100);

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3601));
        System.out.println(getDurationString(-41));
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player s core");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet<0 || (inches<0 || inches>12)) {
            System.out.println("Invalid values");
            return -1;
        }

        double centimeters = (feet * 12 + inches) * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches<0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet " + remainingInches + " inches.");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);

    }

    private static String getDurationString(long minutes, long seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours<10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = remainingMinutes + "m";
        if (remainingMinutes<10) {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if (remainingMinutes<10) {
            secondsString = "0" + secondsString;
        }
        return hoursString + " " + minutesString + " " + secondsString + " ";
    }

    private static String getDurationString(long seconds) {
        if (seconds<0) {
            return INVALID_VALUE_MESSAGE;
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return getDurationString(minutes, remainingSeconds);
    }

}
