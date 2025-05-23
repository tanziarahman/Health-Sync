import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HealthQuoteGenerator{
    private List<String> quotes;
    private Random random;
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";

    public HealthQuoteGenerator() {
        quotes = Arrays.asList(
                "Self-care is how you take your power back.",
                "Rest is productive.",
                "You can't pour from an empty cup. Take care of yourself first.",
                "Self-care isn’t selfish, it’s survival.",
                "Your health is your greatest wealth.",
                "Slow down. Breathe. You’re doing just fine.",
                "Healing is not linear, and that’s okay.",
                "Taking time for yourself is never a waste.",
                "Your body deserves your love and respect.",
                "Peace begins with a healthy mind.",
                "Nourish your body, nurture your soul.",
                "Being kind to yourself is a radical act.",
                "It's okay to rest. Your worth isn’t measured by productivity.",
                "You are allowed to be both a masterpiece and a work in progress.",
                "A healthy life is built one small habit at a time.",
                "Self-care is the foundation of strength."
        );
        random = new Random();
    }
    public void showRandomQuote() {
        int index = random.nextInt(quotes.size());
        System.out.println(PURPLE+"\n💬 Health Tip:");
        System.out.println(CYAN+"\"" + quotes.get(index) + "\"\n");
    }
}
