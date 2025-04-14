import java.time.LocalDate;
import java.util.Scanner;

public class HeartRateDashboard {
    HeartRateLogStorage heartRateLogStorage = new HeartRateLogStorage();
    HeartRateLogPresenter heartRateLogPresenter = new HeartRateLogPresenter();
    private void addHeartRate() {
        System.out.print("Enter date (e.g., 2025-04-14): ");
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        LocalDate date = convertLocalDate(dateString);
        System.out.print("Enter heart rate (bpm): ");
        int rate = scanner.nextInt();

        HeartRateLog heartRateLog = new HeartRateLog(date,rate);
        ExceptionHandle(heartRateLog);

        scanner.nextLine();
    }

    private void showHeartRateHistory(){
        heartRateLogPresenter.displayLogs(heartRateLogStorage.getHeartRateLogs());
    }

    private LocalDate convertLocalDate(String date){
        LocalDate dateConvert = LocalDate.parse(date);
        return dateConvert;
    }

    private void ExceptionHandle(HeartRateLog heartRateLog){
        try{
            heartRateLogStorage.addHeartRateLog(heartRateLog);
        }
        catch (DuplicateDateException e){
            System.out.println(e.getMessage());
        }
    }
}
