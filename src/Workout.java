import java.util.Timer;

public class Workout {
    private int workoutDuration;
    private Timer timer;
    private int remainingTime;
    private SynchronizationLock syncLock;

    public Workout(int durationInSeconds){
        this.workoutDuration = durationInSeconds;
        this.remainingTime = durationInSeconds;
        this.timer = new Timer();
        this.syncLock = new SynchronizationLock();
    }

    public void startWorkout(){
        System.out.println("Workout started!");
        System.out.println("Duration: " + formatTime(workoutDuration));
        WorkoutTimerTask task = new WorkoutTimerTask(this);
        timer.scheduleAtFixedRate(task, 0, 1000);
        syncLock.waitForCompletion();
    }

    public void tick() {
        if(remainingTime>0){
            System.out.print("\rTime left: " + formatTime(remainingTime));
            remainingTime--;
        }
        else{
            System.out.println("\nWorkout complete!");
            timer.cancel();
            syncLock.notifyCompletion();
        }
    }
    private String formatTime(int totalSeconds) {
        return TimeFormatter.formatTime(totalSeconds);
    }
}
