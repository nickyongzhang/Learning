package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
//	    int count = 1;
//        while (count!=6) {
//            System.out.println("Count value was " + count);
//            count ++;
//        }

//        int count = 1;
//        do {
//            System.out.println("Count value was " + count);
//        } while (count!=6);

//        int number = 4;
//        int finishNumber = 20;
//        int count = 0;
//        while (number<=finishNumber) {
//            number++;
//            if (!isEvenNumber(number)) {
//                continue;
//            }
//
//            System.out.println("Even number " + number);
//            count++;
//            if (count == 5) {
//                break;
//            }
//        }
//        System.out.println("Total even numbers found = " + count);

        System.out.println(sumDigits(125));
        System.out.println(sumDigits(-12));
    }

    public static boolean isEvenNumber(int number) {
        if (number%2==0) {
            return true;
        } else {
            return false;
        }
    }

    private static int sumDigits(int number) {
        if (number<10) {
            return -1;
        }

        int sum = 0;
        while (number>0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
