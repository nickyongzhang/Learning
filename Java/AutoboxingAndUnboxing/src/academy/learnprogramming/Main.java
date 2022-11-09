package academy.learnprogramming;

import java.util.ArrayList;

class IntClass {
    private int integer;

    public IntClass(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }
}

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Time");

//        ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        Integer integer = new Integer(54);
        Double doubleValue = new Double(2.24);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i=0; i<=10; i++) {
            intArrayList.add(Integer.valueOf(i)); // take int i and boxing as Integer type
        }

        for (int i=0; i<=10; i++) {
            System.out.println(i + " --> "+ intArrayList.get(i)); //intValue unboxing the Integer to int
        }

        Integer myIntValue = 56; //autoboxing: Integer.valueOf(56)
        int myInt = 56; //unboxing: myIntValue.intValue()

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl=0.0; dbl<=10.0; dbl+=0.5) {
            myDoubleValues.add(Double.valueOf(dbl));
            // auto boxing: myDoubleValues.add(dbl);
        }

        for (int i=0; i<myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue();
            // auto unboxing: double value = myDoubleValues.get(i);
            System.out.println(i+" --> "+value);
        }



    }


}
