import java.util.List;

public class HeartRateLogPresenter{
    public void displayLogs(List<HeartRateLog> logs){
        if (logs == null || logs.isEmpty()) {
            System.out.println("No heart rate logs found.");
            return;
        }
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-15s | %-20s |\n", "Date", "Heart Rate (bpm)");
        System.out.println("--------------------------------------------------");

        for (HeartRateLog log : logs) {
            System.out.printf("| %-15s | %-20d |\n", log.getDate(), log.getHeartRate());
        }
        System.out.println("--------------------------------------------------");
    }
}
