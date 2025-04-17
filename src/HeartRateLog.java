import java.time.LocalDate;
public class HeartRateLog{
    private LocalDate date;
    private int heartRate;
    private static final String RESET = "\u001B[0m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

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
            return YELLOW+"Your heart rate is lower than normal. It could be due to bradycardia or over-rest.";
        }
        else if(heartRate>100){
            return RED+"Your heart rate is higher than normal. You might be overexerted or have tachycardia.";
        }
        else{
            return GREEN+"Your heart rate is normal. Keep maintaining it!";
        }
    }
}
