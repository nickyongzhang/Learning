package academy.learnprogramming;

import java.util.SortedMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric.replaceAll(".","Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));

        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blanks and\ta tab, and also a new line\n";
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));

        // pad word boundary
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

        System.out.println(newAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe*", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("^abcDe{2,5}", "YYY"));
        System.out.println(newAlphanumeric.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph</p>");
        htmlText.append("<p>This is another paragraph.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary</p>");

        String h2Patten = "<h2>";
        Pattern pattern = Pattern.compile(h2Patten);
        Matcher matcher = pattern.matcher(htmlText);
        // below output false cause matcher.matches expect full text match
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence "+count+" : "+matcher.start()+" to "+matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        groupMatcher.reset();
        while(groupMatcher.find()) {
            System.out.println("Occurrence: "+groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrrence: "+h2TextMatcher.group(2));
        }

        // RegExp or
        System.out.println("harry potter".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry potter".replaceAll("[H|h]arry", "Larry"));

        // RegExp not
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            System.out.println("Occurrence: "+count+" : "+tNotVMatcher.start()+" to "+tNotVMatcher.end());
        }

        String phone1 = "123456780";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-78980";
        String phone4 = "(123)456-7890";

        String phonePattern = "^(\\([0-9]{3}\\) [0-9]{3}\\-[0-9]{4})$";
        System.out.println("phone1 = "+phone1.matches(phonePattern));
        System.out.println("phone2 = "+phone2.matches(phonePattern));
        System.out.println("phone3 = "+phone3.matches(phonePattern));
        System.out.println("phone4 = "+phone4.matches(phonePattern));

    }
}

