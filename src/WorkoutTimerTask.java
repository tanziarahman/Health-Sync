import java.util.TimerTask;

public class WorkoutTimerTask extends TimerTask {
    private Workout workout;

    public WorkoutTimerTask(Workout workout) {
        this.workout = workout;
    }

    @Override
    public void run() {
        workout.tick();
    }

}
