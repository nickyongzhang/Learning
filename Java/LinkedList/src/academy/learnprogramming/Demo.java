package academy.learnprogramming;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        visit(placesToVisit);


    }

    public static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting "+i.next());
        }
        System.out.println("============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison==0) {
                // equal, do no add
                System.out.println(newCity+" is already included as a destination");
                return false;
            } else if (comparison>0) {
                // new city should appear before this one
                // Brisbane -> Adelaide
                stringListIterator.previous(); // in lin 40, next() has already moved iterator forward
                stringListIterator.add(newCity);
                return true;
            }
        }

        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
        } else {
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    // add a direction house-keeper because the listIterator does not fall
                    // on the element in the list but between elements
                    // https://docs.oracle.com/javase/7/docs/api/java/util/ListIterator.html
                    if (!goingForward) {  // change direction
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
//                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) { // change direction
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting "+listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
//                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                    "1 - go to next city\n" +
                    "2 - go to previous city\n" +
                    "3 - print menu options");
    }
}
