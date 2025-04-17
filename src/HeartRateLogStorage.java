import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HeartRateLogStorage{
    private List<HeartRateLog> heartRateLogs;
    private static final String RED = "\u001B[31m";

    public HeartRateLogStorage(){
        heartRateLogs = new ArrayList<>();
    }

    public void addHeartRateLog(HeartRateLog heartRateLog) throws DuplicateDateException{
        for (HeartRateLog log : heartRateLogs) {
            if (log.getDate().equals(heartRateLog.getDate())) {
                throw new DuplicateDateException(RED+"Heart rate already recorded for " + heartRateLog.getDate());
            }
        }
        heartRateLogs.add(heartRateLog);
        writeLogsToCSV();
    }
    public List<HeartRateLog> getHeartRateLogs(){
        return heartRateLogs;
    }
    private void writeLogsToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Heart Rate Storage.csv"))) {
            for (HeartRateLog log : heartRateLogs) {
                writer.write(log.getDate() + "," + log.getHeartRate());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(RED+"Error writing to file: " + e.getMessage());
        }
    }

    public void readLogsFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Heart Rate Storage.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    int heartRate = Integer.parseInt(parts[1]);
                    addHeartRateLog(new HeartRateLog(date, heartRate));
                }
            }
        } catch (IOException | DuplicateDateException e) {
            System.out.println(RED+"Error reading from file: " + e.getMessage());
        }
    }

}
