public class week_planner {
    public static void main(String[] args) {
        boolean true_input;
        String[][] schedule = new String[7][2];
        schedule[0][0] = "sunday";
        schedule[0][1] = "do your homework";
        schedule[1][0] = "monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "tuesday";
        schedule[2][1] = "go to the gym";
        schedule[3][0] = "wednesday";
        schedule[3][1] = "go to the courses";
        schedule[4][0] = "thursday";
        schedule[4][1] = "go to the gym";
        schedule[5][0] = "friday";
        schedule[5][1] = "go to the courses";
        schedule[6][0] = "saturday";
        schedule[6][1] = "go to the cinema";

        while (true) { 
            System.out.println("Please, input the day of the week:");
            String day = System.console().readLine();
            day = day.toLowerCase();
            switch (day){
                case "exit":
                    System.out.println("Goodbye!");
                    return;
                default:
                true_input = false;
                for (int i = 0; i < 7; i++) {
                    if (schedule[i][0].equals(day)) {
                        true_input = true;
                        System.out.println("You have to " + schedule[i][1]);
                        break;
                    }
                }
                if (!true_input) {
                    System.out.println("Sorry, I don't understand you, please try again.");
                }
            }
        }
    }
}
