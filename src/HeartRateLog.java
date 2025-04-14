import java.time.LocalDate;
public class HeartRateLog{
    private LocalDate date;
    private int heartRate;

    public HeartRateLog(LocalDate date, int heartRate){
        this.date = date;
        this.heartRate = heartRate;
    }
    public LocalDate getDate(){
        return date;
    }
    public int getHeartRate(){
        return heartRate;
    }
    @Override
    public String toString(){
        return "Date: " + date + ", Heart Rate: " + heartRate + " bpm";
    }
}
