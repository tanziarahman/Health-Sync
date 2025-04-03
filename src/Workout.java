import java.util.Timer;
import java.util.TimerTask;

public class Workout {
    private int workoutDuration; // Duration in seconds
    private Timer timer;
    private int remainingTime;

    // Constructor to initialize workout duration
    public Workout(int durationInSeconds) {
        this.workoutDuration = durationInSeconds;
        this.remainingTime = durationInSeconds;
        this.timer = new Timer();
    }

    // Start the timer
    public void startWorkout() {
        System.out.println("Workout started!"+"\n" +"Duration: " + formatTime(workoutDuration));

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (remainingTime > 0) {
                    System.out.print("\rTime left: " + formatTime(remainingTime));
                    remainingTime--;
                } else {
                    System.out.println("\nWorkout complete!");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    // Format time as MM:SS
    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}