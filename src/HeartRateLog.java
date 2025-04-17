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
    public String checkHeartRateCondition(int heartRate){
        if(heartRate<60){
            return "Your heart rate is lower than normal. It could be due to bradycardia or over-rest.";
        }
        else if(heartRate>100){
            return "Your heart rate is higher than normal. You might be overexerted or have tachycardia.";
        }
        else{
            return "Your heart rate is normal. Keep maintaining it!";
        }
    }
}
