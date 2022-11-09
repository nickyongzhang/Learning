package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 8000;
        int levelCompleted = 5;
        int bonus = 100;

//        if (score <= 5000 && score>1000) {
//            System.out.println("Your score was less than 5000 but greater than 1000");
//        } else if (score < 1000) {
//            System.out.println("Your score was less than 1000");
//        } else {
//            System.out.println("Got there");
//        }

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus); // can access variable outside the code block
            System.out.println("Your final score was " + finalScore);
        }
//        int savedFinalScore = finalScore; // Error: cannot access variable inside the above code block


    }
}
