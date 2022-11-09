package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
//        int value = 5;
//        switch (value) {
//            case 1:
//                System.out.println("Value was 1");
//                break;
//            case 2:
//                System.out.println("Value was 2");
//                break;
//            case 3: case 4: case 5:
//                System.out.println("Value was 3, or 4 or 5");
//                System.out.println("Actually it was a " + value);
//                break;
//            default:
//                System.out.println("Value was not 1, 2, 3, 4 or 5");
//                break;
//        }
        printDayOfTheWeek(-1);
        printDayOfTheWeek(0);
        printDayOfTheWeek(2);
        printDayOfTheWeek(6);
        printDayOfTheWeek(8);

    }

    private static void printDayOfTheWeek(int day) {

        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Day");
        }
    }
}
