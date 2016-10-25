package upwork;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class LogicBomb {

    public static void main(String[] args) {
        long count = 0;
        int number;
        String currentDay = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Integer currentDateInt = Integer.valueOf(currentDay);
        do {
            number = ThreadLocalRandom.current().nextInt(99999999);
            count++;
        }
        while (number != currentDateInt);

        System.out.println("It is your lucky day!\nThe count is " + count);
    }
}
