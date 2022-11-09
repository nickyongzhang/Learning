package academy.learnprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnable1 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };
        System.out.println(lambdaFunction.apply("12345678"));

        System.out.println(everySecondCharacter(lambdaFunction, "12345678"));

        Supplier<String> iLoveJava = () -> "I love Java!";
//        Supplier<String> iLoveJava = () -> {return "I love Java!";};

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase()+name.substring(1))
                .sorted(String::compareTo )
                .forEach(System.out::println);

        long namesBeginningWithA = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase()+name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println(namesBeginningWithA);

    }

    public static String everySecondCharacter(Function<String, String> func, String source) {
        return func.apply(source);
    }
}
