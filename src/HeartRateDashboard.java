import java.time.LocalDate;
import java.util.Scanner;

public class HeartRateDashboard {
    private static final String BLUE = "\u001B[34m";
    HeartRateLogStorage heartRateLogStorage = new HeartRateLogStorage();
    HeartRateLogPresenter heartRateLogPresenter = new HeartRateLogPresenter();
    Scanner scanner = new Scanner(System.in);
    public void addHeartRate() {
        System.out.print("Enter date (e.g., 2025-04-14): ");
        String dateString = scanner.nextLine();
        LocalDate date = convertLocalDate(dateString);
        System.out.print("Enter heart rate (bpm): ");
        int rate = scanner.nextInt();
        HeartRateLog heartRateLog = new HeartRateLog(date,rate);
        ExceptionHandle(heartRateLog);

    }

    public void showHeartRateHistory(){
        heartRateLogPresenter.displayLogs(heartRateLogStorage.getHeartRateLogs());
    }

    private LocalDate convertLocalDate(String date){
        LocalDate dateConvert = LocalDate.parse(date);
        return dateConvert;
    }

    private void ExceptionHandle(HeartRateLog heartRateLog){
        try{
            heartRateLogStorage.addHeartRateLog(heartRateLog);
            String regard = heartRateLog.checkHeartRateCondition(heartRateLog.getHeartRate());
            System.out.println();
            System.out.println(regard);
            System.out.println();

            scanner.nextLine();
        }
        catch (DuplicateDateException e){
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
