package academy.learnprogramming;

import java.util.HashMap;
import java.util.Map;

public class MyMap {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "a compiled high level, platform independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object-oriented, high-lev3el programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners All purposes Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

//        System.out.println(languages.get("Java"));
        // put return the exiting value corresponding the key
        System.out.println(languages.put("Java", "this course is about Java"));
        System.out.println(languages.get("Java"));

        System.out.println("=============================================");

        // remove a key in map
//        languages.remove("Lisp");
        // remove key/value pair in map
        if (languages.remove("Algo", "a family of algorithmic languages")) {
            System.out.println("Algo removed");
        } else {
            System.out.println("Algo not removed, key/value pair not found");
        }

        // replace key value
        System.out.println(languages.replace("Lisp", "a functional programming language with imperative features."));

        if (languages.replace("Lisp", "This will not work", "a functional programming language with imperative features.")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        System.out.println(languages.replace("Scala", "this will not be added")); // no existing key, no replace


        // loop map
        for (String key: languages.keySet()) {
            System.out.println(key+" : "+languages.get(key));
        }
    }
}
