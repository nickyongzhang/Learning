package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        int result = 1 + 2;
        int previousResult = result;
        System.out.println("previousResult = " + previousResult);

        result = result - 1;
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult = " + previousResult); // previousResult and result are independent of each other

        result = result * 10;
        System.out.println("2 * 10 = " + result);

        result = result / 5 ; // 20/5=4
        System.out.println("20 / 5 = " + result);

        result = result % 3; // 4 % 3 = 1
        System.out.println("4 % 3 = " + result);

        result++; // result = result + 1
        System.out.println("1 + 1 = " + result);

        result--; // result = result - 1

        result += 2; // result = result + 2

        result *= 3; // result = result * 3

        result /= 3; // result = result / 3

        result -= 2; // result = result - 2

        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("It is not an alien");
            System.out.println("And I am scared of aliens");
        }

        int topScore = 100;
        if (topScore == 100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 60;
        if ((topScore > secondTopScore) && (topScore <= 100)) {
            System.out.println("Greater than second score and less than 100!");
        }

        int thirdTopScore = 81;
        if ((topScore > thirdTopScore) || (topScore <= 100)) {
            System.out.println("Greater than third score or less than 100!");
        }

        boolean isCar = false;
        if (isCar = true) { // isCar is assigned to be true
            System.out.println("This is not supposed to happen");
        }

        isCar = true;
        boolean wasCar = isCar ? true : false;
        if (wasCar) {
            System.out.println("wasCar is true");
        }

        double myFirstValue = 20.00d;
        double mySecondValue = 80.00d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00d;
        System.out.println("MyValuesTotal = " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;
        System.out.println("theRemainder = " + theRemainder);

        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("isNoRemainder = " + isNoRemainder);

        if (!isNoRemainder) {
            System.out.println("Got some remainder");
        }

    }
}
