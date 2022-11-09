package academy.learnprogramming;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()) {
            System.out.println("Occurrence: "+matcher8.group(1));
        }

        String challenge9 = "abcd.135uvqz.7tzik.999";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while (matcher9.find()) {
            System.out.println("Occurrence: "+matcher9.start(1) + " end = "+(matcher9.end(1)-1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("\\{(.+?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()) {
            System.out.println("Occurrence: "+matcher11.group(1));
        }
    }
}
