import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HeartRateLogStorage{
    private List<HeartRateLog> heartRateLogs;

    public HeartRateLogStorage(){
        heartRateLogs = new ArrayList<>();
    }

    public void addHeartRateLog(HeartRateLog heartRateLog) throws DuplicateDateException{
        for (HeartRateLog log : heartRateLogs) {
            if (log.getDate().equals(heartRateLog.getDate())) {
                throw new DuplicateDateException("Heart rate already recorded for this date: " + heartRateLog.getDate());
            }
        }
        heartRateLogs.add(heartRateLog);
    }
    public List<HeartRateLog> getHeartRateLogs(){
        return heartRateLogs;
    }

}
