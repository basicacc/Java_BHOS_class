import java.util.Random;

public class numbers {
    public static void main(String[] args) {
        int[] guessed_numbers = new int[100];
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        System.out.println("What is your name?");
        String name = System.console().readLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Let the game begin!");
        while (true) {
            System.out.println("Enter a number:");
            int guess = Integer.parseInt(System.console().readLine());
            guessed_numbers[guess] = 1;
            if (guess < number) {
                System.out.println("The number is greater than " + guess);
            } else if (guess > number) {
                System.out.println("The number is less than " + guess);
            } else {
                System.out.println("Congratulations, " + name + "!");
                break;
            }
            System.out.println("Guessed numbers:");
            for (int i = 1; i < 100; i++) {
                if (guessed_numbers[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}