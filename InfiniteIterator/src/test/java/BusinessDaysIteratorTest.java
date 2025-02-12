import com.bobocode.BusinessDaysIterator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessDaysIteratorTest {
    @Test
    void givenSaturday_whenNext_thenSkipsToMonday() {
        Iterator<LocalDate> iter = new BusinessDaysIterator(LocalDate.of(2022, 1, 1));

        assertEquals(LocalDate.of(2022, 1, 3), iter.next());
    }

    @Test
    void givenFriday_whenNext_thenReturnsMonday() {
        Iterator<LocalDate> iter = new BusinessDaysIterator(LocalDate.of(2022, 1, 7));

        assertEquals(LocalDate.of(2022, 1, 10), iter.next());
    }

    @Test
    void givenWeekday_whenNext_thenReturnsNextDay() {
        Iterator<LocalDate> iter = new BusinessDaysIterator(LocalDate.of(2022, 1, 3));

        assertEquals(LocalDate.of(2022, 1, 4), iter.next());
    }

    @Test
    void givenFriday_whenNextTwice_thenReturnsTuesday() {
        Iterator<LocalDate> iter = new BusinessDaysIterator(LocalDate.of(2022, 1, 7));

        iter.next();
        assertEquals(LocalDate.of(2022, 1, 11), iter.next());
    }
}
