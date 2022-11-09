package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {

//        for (int i=2; i<9; i++) {
//            System.out.println("10,000 at " + i +"% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
//        }
//
//        System.out.println("********");
//
//        for (int i=8; i>1; i--) {
//            System.out.println("10,000 at " + i +"% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
//        }
//
//        System.out.println("********");
//
//        int cnt = 0;
//        for (int i=50; i<100; i++) {
//            if (isPrime(i)) {
//                System.out.println("Number "+i+" is a prime number");
//                cnt++;
//            }
//            if (cnt==3) {
//                System.out.println("Found 3 prime numbers already");
//                break;
//            }
//        }

        System.out.println("********");

        int count = 0;
        int sum = 0;
        for (int i=1; i<=1000; i++) {
            if (i%3==0 && i%5==0) {
                sum += i;
                count += 1;
                System.out.println("Found number = " + i);
            }

            if (count==5) {
                break;
            }
        }

        System.out.println("Sum = " + sum);
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate/100);
    }

    public static boolean isPrime(int n) {
        if (n==1) {
            return false;
        }

        for (int i=2; i<=(long) Math.sqrt(n); i++) {
            if (n%i==0) {
                return false;
            }
        }

        return true;
    }
}
