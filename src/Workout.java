import java.util.Timer;

public class Workout {
    private int workoutDuration;
    private Timer timer;
    private int remainingTime;

    public Workout(int durationInSeconds) {
        this.workoutDuration = durationInSeconds;
        this.remainingTime = durationInSeconds;
        this.timer = new Timer();
    }

    public void startWorkout() {
        System.out.println("Workout started!");
        System.out.println("Duration: " + formatTime(workoutDuration));

        WorkoutTimerTask task = new WorkoutTimerTask(this);
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void tick() {
        if (remainingTime > 0) {
            System.out.print("\rTime left: " + formatTime(remainingTime));
            remainingTime--;
        } else {
            System.out.println("\nWorkout complete!");
            timer.cancel();
        }
    }
    
    private String formatTime(int totalSeconds) {
        return TimeFormatter.formatTime(totalSeconds);
    }
}