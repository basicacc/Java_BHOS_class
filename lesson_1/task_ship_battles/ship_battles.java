import java.util.Random;
public class ship_battles {
    public static void main(String[] args) {
        boolean game_over;
        Random random = new Random();
        int[][] war_field = new int[5][5];
        char[][] shots = new char[5][5];

        System.out.println("All set. Get ready to rumble!");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                war_field[i][j] = random.nextInt(2);
                shots[i][j] = '-';
            }
        }
        while (true) {
            System.out.println("Enter a row number:");
            int row = Integer.parseInt(System.console().readLine()) - 1;
            System.out.println("Enter a column number:");
            int column = Integer.parseInt(System.console().readLine()) -1;
            if (shots[row][column] == '*') {
                System.out.println("You have already shot here!");
            } else {
                shots[row][column] = '*';
                System.out.println("Miss!");
            }
            System.out.println("The war field:");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(shots[i][j] + " ");
                }
                System.out.println();
            }
            game_over = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (war_field[i][j] == 1 && shots[i][j] == '-') {
                        game_over = false;
                    }
                }
            }
            if (game_over) {
                System.out.println("Game over!");
                break;
            }
        }
    }
}
