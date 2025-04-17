import java.util.List;

public class HeartRateLogPresenter{
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String PURPLE = "\u001B[35m";
    public void displayLogs(List<HeartRateLog> logs){
        if (logs == null || logs.isEmpty()) {
            System.out.println("No heart rate logs found.");
            return;
        }
        System.out.println(PURPLE+"--------------------------------------------------");
        System.out.printf(PURPLE+"| %-15s | %-20s |\n", "Date", "Heart Rate (bpm)");
        System.out.println(PURPLE+"--------------------------------------------------");

        for (HeartRateLog log : logs) {
            System.out.printf(PURPLE+"| %-15s | %-20d |\n", log.getDate(), log.getHeartRate());
        }
        System.out.println(PURPLE+"--------------------------------------------------");
    }
}
