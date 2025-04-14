import java.time.LocalDate;

public class HeartRateTracker{
    private HeartRateLogStorage logStorage;

    public HeartRateTracker(HeartRateLogStorage logStorage){
        this.logStorage = logStorage;
    }

    public void trackHeartRate(LocalDate date, int heartRate) {
        try{
            String conditionMessage = checkHeartRateCondition(heartRate);
            System.out.println(conditionMessage);
            logStorage.addHeartRateLog(date, heartRate);
        }
        catch(DuplicateDateException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String checkHeartRateCondition(int heartRate){
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
