package academy.learnprogramming;

public class ScopeCheck {
    public int publicVar = 0;
    private int var1 = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = "+publicVar+": var1 = "+ var1);
    }

    public int getVar1() {
        return var1;
    }

    public void timesTwo() {
        int var2 = 2;
        for (int i=0;i<10;i++) {
            System.out.println(i+ " times two is "+i*var2); // use the most local scope printVar=2
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("var3 from outer class: "+innerClass.var3);
    }

    public class InnerClass {
        private int var3 = 3;

        public InnerClass() {
            System.out.println("ScopeCheck created, var1 is " + var1 + " and var3 is "+ var3);
        }

        public void timesTwo() {
            System.out.println("var1 is still available here: "+var1);
            for (int i=0;i<10;i++) {
                System.out.println(i+ " times two is "+i* var3); // use the most local scope printVar=2
            }
        }
    }
}
