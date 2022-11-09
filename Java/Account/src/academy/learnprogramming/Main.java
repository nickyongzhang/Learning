package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Account bobsAccount = new Account("12345", 0.0, "Bobs",
//                "xyz@gmail.com", "206-542524");
//
//        bobsAccount.withdrawal(100);
//
//        bobsAccount.deposit(50.0);
//        bobsAccount.withdrawal(100.0);
//
//        bobsAccount.deposit(51.0);
//        bobsAccount.withdrawal(100.0);
//
//        Account timsAccount  = new Account("Time", "Tim@gmail.com", "12345");
//        System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());

        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("Bob", 25000.00);
        System.out.println(person2.getName());

        VipPerson person3 = new VipPerson("Tim", 100.00, "tim@gmail.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmailAddress());


    }
}
