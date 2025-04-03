public class BMICalculator {
    private double height;
    private double weight;
    private double bmi;

    public BMICalculator(double weight, double height){
        this.height = height;
        this.weight = weight;
        calculateBMI();
    }
    public double getBmi(){
        return  bmi;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
    private void calculateBMI(){
        this.bmi = (weight/(height*height));
    }
}
