import java.util.Timer;

public class Workout {
    private int workoutDuration;
    private Timer timer;
    private int remainingTime;
    private SynchronizationLock syncLock;
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
    public Workout(int durationInSeconds){
        this.workoutDuration = durationInSeconds;
        this.remainingTime = durationInSeconds;
        this.timer = new Timer();
        this.syncLock = new SynchronizationLock();
    }

    public void startWorkout(){
        System.out.println(CYAN+"Workout started!");
        System.out.println(CYAN+"Duration: " + PURPLE+formatTime(workoutDuration));
        WorkoutTimerTask task = new WorkoutTimerTask(this);
        timer.scheduleAtFixedRate(task, 0, 1000);
        syncLock.waitForCompletion();
    }

    public void tick() {
        if(remainingTime>0){
            System.out.print(CYAN+"\rTime left: " + RED+formatTime(remainingTime));
            remainingTime--;
        }
        else{
            System.out.println(GREEN+"\nWorkout complete!");
            timer.cancel();
            syncLock.notifyCompletion();
        }
    }
    private String formatTime(int totalSeconds) {
        return TimeFormatter.formatTime(totalSeconds);
    }
}
