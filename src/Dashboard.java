import java.util.Scanner;

public class Dashboard{
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    HeartRateDashboard heartRateDashboard = new HeartRateDashboard();
    HealthQuoteGenerator healthQuoteGenerator = new HealthQuoteGenerator();
    Scanner sc = new Scanner(System.in);
    public void run(){
        while(true){
            System.out.println(BLUE + "══════════════════════════════");
            System.out.println(BLUE + "         HEALTH SYNC");
            System.out.println(BLUE + "══════════════════════════════");

            System.out.println(GREEN + "[1] Calculate BMI");
            System.out.println("[2] Check Heart Condition");
            System.out.println("[3] Workout Timer");
            System.out.println("[4] Get Random Health Tip");
            System.out.println("[5] Get Heart Rate History");
            System.out.println("[6] Exit");
            System.out.println();

            System.out.print("Enter your choice (1-6): ");
            String choice = sc.nextLine();
            choiceSelection(choice);

        }
    }

    private void choiceSelection(String choice){
        switch (choice){
            case "1":
                calculateBMI();
                promptBack();
                break;
            case "2":
                heartRateDashboard.addHeartRate();
                promptBack();
                break;
            case "3":
                System.out.print(BLUE+"Enter workout time in min: ");
                int min = sc.nextInt();
                Workout workout = new Workout(min*60);
                sc.nextLine();
                workout.startWorkout();
                promptBack();
                break;
            case "4":
                healthQuoteGenerator.showRandomQuote();
                promptBack();
                break;
            case "5":
                heartRateDashboard.showHeartRateHistory();
                promptBack();
                break;
            case "6":
                System.out.println();
                System.out.println(CYAN+"Thank you for using Health Sync. Stay healthy!");
                System.exit(0);
            default:
                System.out.println();
                System.out.println(RED+"Invalid choice!");
                System.out.println();
                run();

        }
    }

    private void calculateBMI(){
        System.out.print(CYAN+ "Enter your weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print(CYAN+"Enter your height (metre): ");
        double height = sc.nextDouble();
        sc.nextLine();
        BMICalculator bmiCalculator = new BMICalculator(weight,height);
        ShowBMI showBMI = new ShowBMI(bmiCalculator);
        showBMI.showBMI();
    }

    private void promptBack() {
        System.out.println();
        System.out.print(YELLOW+"Press enter to continue..."+RESET);
        sc.nextLine();
    }
}
