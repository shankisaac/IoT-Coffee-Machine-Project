import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class CoffeeMachineScheduler {

    private static final String API_URL = "http://localhost:8080/schedule";
    private final RelayControl relayControl;

    public CoffeeMachineScheduler() {
        this.relayControl = new RelayControl();
    }

    public static void main(String[] args) {
        CoffeeMachineScheduler scheduler = new CoffeeMachineScheduler();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                scheduler.checkSchedule();
            }
        }, 0, 60000); // Check every minute
    }

    private void checkSchedule() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String scheduleTime = response.toString();
            LocalTime now = LocalTime.now();
            LocalTime schedule = LocalTime.parse(scheduleTime);

            if (now.isAfter(schedule.minusMinutes(10)) && now.isBefore(schedule)) {
                relayControl.start();
            } else {
                relayControl.stop();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
