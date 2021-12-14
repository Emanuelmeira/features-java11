package estudos.date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RunWith(JUnit4.class)
public class DateTest {

    @Test
    public void differenceBetweenDay() {
        var pastDate = LocalDate.of(2021, 9, 1);
        System.out.println(ChronoUnit.DAYS.between(pastDate, LocalDate.now()));
    }

    @Test
    public void differenceBetweenMonth() {
        var pastDate = LocalDate.of(2021, 9, 1);
        System.out.println(ChronoUnit.DAYS.between(pastDate, LocalDate.now()));
    }

}
