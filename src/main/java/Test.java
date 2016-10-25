import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author emorenkov
 */
public class Test {

    public static void main(String[] args) {
        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
        time.schedule(st, 0, 60 * 60000); // Create Repetitively task for every 1 hour
    }

    static class ScheduledTask extends TimerTask {
        private Path lastFilePath = null;
        private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy_hh_mm");

        // Add your task here
        public void run() {
            try {
                if (lastFilePath != null) {
                    Files.delete(lastFilePath);
                }
                LocalDateTime date = LocalDateTime.now();
                String fileName = date.format(dtf);
                lastFilePath = Paths.get(fileName);
                Files.createFile(lastFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
