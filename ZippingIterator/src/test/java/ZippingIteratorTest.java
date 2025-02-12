import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

import com.bobocode.ZippingIterator;
import org.junit.jupiter.api.Test;

class ZippingIteratorTest {

    @Test
    void givenTwoIterators_whenZipping_thenCombinesElements() {
        List<Integer> listA = Arrays.asList(1, 2, 3);
        List<String> listB = Arrays.asList("a", "b", "c");

        Iterator<Integer> iterA = listA.iterator();
        Iterator<String> iterB = listB.iterator();

        BiFunction<Integer, String, String> combiner = (num, str) -> num + str;
        ZippingIterator<Integer, String, String> zipIter = new ZippingIterator<>(iterA, iterB, combiner);

        assertEquals("1a", zipIter.next());
        assertEquals("2b", zipIter.next());
        assertEquals("3c", zipIter.next());
        assertFalse(zipIter.hasNext());
    }

    @Test
    void givenUnequalLengthIterators_whenZipping_thenStopsAtShortest() {
        List<Integer> listA = Arrays.asList(1, 2);
        List<String> listB = Arrays.asList("a", "b", "c");

        Iterator<Integer> iterA = listA.iterator();
        Iterator<String> iterB = listB.iterator();

        BiFunction<Integer, String, String> combiner = (num, str) -> num + str;
        ZippingIterator<Integer, String, String> zipIter = new ZippingIterator<>(iterA, iterB, combiner);

        assertEquals("1a", zipIter.next());
        assertEquals("2b", zipIter.next());
        assertFalse(zipIter.hasNext());
    }

    @Test
    void givenEmptyIterators_whenZipping_thenHasNoElements() {
        List<Integer> listA = Arrays.asList();
        List<String> listB = Arrays.asList();

        Iterator<Integer> iterA = listA.iterator();
        Iterator<String> iterB = listB.iterator();

        BiFunction<Integer, String, String> combiner = (num, str) -> num + str;
        ZippingIterator<Integer, String, String> zipIter = new ZippingIterator<>(iterA, iterB, combiner);

        assertFalse(zipIter.hasNext());
    }
}
