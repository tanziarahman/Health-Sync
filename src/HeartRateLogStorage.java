import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HeartRateLogStorage{
    private List<HeartRateLog> heartRateLogs;

    public HeartRateLogStorage(){
        heartRateLogs = new ArrayList<>();
    }

    public void addHeartRateLog(LocalDate date, int heartRate) throws DuplicateDateException{
        for (HeartRateLog log : heartRateLogs) {
            if (log.getDate().equals(date)) {
                throw new DuplicateDateException("Heart rate already recorded for this date: " + date);
            }
        }
        heartRateLogs.add(new HeartRateLog(date, heartRate));
    }
    public List<HeartRateLog> getHeartRateLogs(){
        return heartRateLogs;
    }

}
