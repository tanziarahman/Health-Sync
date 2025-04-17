public class ShowBMI {
    private BMICalculator bmiCalculator;

    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 24.9;
    private static final double OVERWEIGHT_THRESHOLD = 29.9;
    private static final double OBESITY_1_THRESHOLD = 34.9;
    private static final double OBESITY_2_THRESHOLD = 39.9;
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";

    public ShowBMI(BMICalculator bmiCalculator){
        this.bmiCalculator = bmiCalculator;
    }

    public void showBMI() {
        double bmi = bmiCalculator.getBmi();
        System.out.println();
        System.out.printf(PURPLE + "Your BMI is %.2f%n", bmi);
        System.out.print(PURPLE + "Category: ");

        if (bmi >= OBESITY_2_THRESHOLD) {
            System.out.println(RED + "Severe Obesity");
        } else if (bmi >= OBESITY_1_THRESHOLD) {
            System.out.println(RED + "Obesity II");
        } else if (bmi >= OVERWEIGHT_THRESHOLD) {
            System.out.println(RED + "Obesity I");
        } else if (bmi >= NORMAL_THRESHOLD) {
            System.out.println(GREEN + "Overweight");
        } else if (bmi >= UNDERWEIGHT_THRESHOLD) {
            System.out.println(GREEN + "Normal");
        } else {
            System.out.println(YELLOW + "Underweight");
        }
    }

}
