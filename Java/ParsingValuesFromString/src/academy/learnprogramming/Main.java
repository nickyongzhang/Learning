package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        String numberAsString = "2018.1";
        System.out.println("numberAsString = " + numberAsString);

        double number = Double.parseDouble(numberAsString);

        numberAsString += 1;
        number += 1;

        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);


    }
}