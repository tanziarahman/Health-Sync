public class ShowBMI {
    private BMICalculator bmiCalculator;

    private static final double UNDERWEIGHT_THRESHOLD = 18.5;
    private static final double NORMAL_THRESHOLD = 24.9;
    private static final double OVERWEIGHT_THRESHOLD = 29.9;
    private static final double OBESITY_1_THRESHOLD = 34.9;
    private static final double OBESITY_2_THRESHOLD = 39.9;

    public ShowBMI(BMICalculator bmiCalculator){
        this.bmiCalculator = bmiCalculator;
    }

    public String showBMI(){
        StringBuilder st = new StringBuilder();
        double bmi = bmiCalculator.getBmi();
        String formattedBMI = String.format("Your BMI is %.2f", bmi);
        st.append(formattedBMI+"\n"+"Category: ");
        if (bmi>=OBESITY_2_THRESHOLD) {
            st.append("Severe Obesity");
        } else if (bmi>=OBESITY_1_THRESHOLD) {
            st.append("Obesity II");
        } else if (bmi>=OVERWEIGHT_THRESHOLD) {
            st.append("Obesity I");
        } else if (bmi>=NORMAL_THRESHOLD) {
            st.append("Overweight");
        } else if (bmi>=UNDERWEIGHT_THRESHOLD) {
            st.append("Normal");
        } else {
            st.append("Underweight");
        }
        return st.toString();
    }
}
