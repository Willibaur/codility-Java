package main;

import java.time.Duration;
import java.time.LocalTime;

import static java.lang.StrictMath.ceil;

public class CarPark {

    public int till(String strEntryTime, String strExitTime) {
        int total;
        int totalHours;

        LocalTime entryTime;
        LocalTime exitTime;

        entryTime = formatter(strEntryTime);
        exitTime  = formatter(strExitTime);

        totalHours = timeCalculator(entryTime, exitTime);

        total = priceCalculator(totalHours);

        return total;
    }

    private int priceCalculator(int totalHours) {
        int entryFee   = 2;
        int firstHour  = 3;
        int secondHour = 4;
        int totalBill;

        if (totalHours < 1) {
            totalBill = 0;
        } else if (totalHours == 1) {
            totalBill = entryFee + firstHour;
        } else {
            totalBill = entryFee + firstHour + (totalHours-1)*secondHour;
        }
        return totalBill;
    }

    private int timeCalculator(LocalTime entryTime, LocalTime exitTime) {
        Duration duration;
        Duration previousDayDuration;
        Duration nextDayDuration;
        int totalHours;
        int previousDayHours;
        int nextDayHours;

        duration = Duration.between(entryTime, exitTime);

        if ((float)duration.toMinutes() < 0) {
            previousDayDuration = Duration.between(entryTime, formatter("23:59"));
            nextDayDuration = Duration.between(formatter("00:00"), exitTime);
            previousDayHours = (int)(ceil((float)previousDayDuration.toMinutes()/60));
            nextDayHours = (int)(ceil((float)nextDayDuration.toMinutes()/60));
            totalHours = previousDayHours + nextDayHours;
        } else {
            totalHours = (int)(ceil((float)duration.toMinutes()/60));
        }
        return totalHours;
    }

    private LocalTime formatter(String stringTime) {
        return LocalTime.parse(stringTime);
    }
}
