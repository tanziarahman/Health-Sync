public class Main {
    public static void main(String[] args) {
        Workout workout = new Workout(5);
        workout.startWorkout();
        HealthQuoteGenerator healthQuoteGenerator = new HealthQuoteGenerator();
        healthQuoteGenerator.showRandomQuote();
    }
}