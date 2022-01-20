import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GenericsTest {

    @Test
    public void checkCountElementsForEvenInteger() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(2, Generics.countElements(list, p -> p % 2 == 0));
    }

    @Test
    public void checkCountElementsForPalindrome() {
        List<String> list = Arrays.asList("test", "Dot saw I was Tod", "abba", "not palindrome", null);
        assertEquals(2, Generics.countElements(
                list, p -> p.toLowerCase().equals(new StringBuilder(p.toLowerCase()).reverse().toString())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCountElementsWithEmptyCollection() {
        Generics.countElements(new ArrayList<>(), p -> (int) p % 2 == 0);
    }

    @Test
    public void checkChangeElementsForInt() {
        Object[] initArray = {1, 2, 3, 4, 5};
        Object[] expectedArray = {1, 4, 3, 2, 5};
        assertArrayEquals(expectedArray, Generics.exchangeElements(initArray, 1, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCountElementsWithEmptyArray() {
        Object[] initArray = {};
        Generics.exchangeElements(initArray, 1, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCountElementsWithSamePosition() {
        Object[] initArray = {1, 2, 3, 4, 5};
        Generics.exchangeElements(initArray, -1, 1);
    }

    @Test
    public void checkFindMaxForString() {
        List<String> list = Arrays.asList("aaa", "aab", "abb", "bbb", "a", "b");
        assertEquals("bbb", Generics.findMax(list, 2, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindMaxForEndLessThanStart() {
        List<String> list = Arrays.asList("aaa", "aab", "abb", "bbb", "a", "b");
        Generics.findMax(list, 3, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindMaxForEmptyList() {
        List<String> list = new ArrayList<>();
        Generics.findMax(list, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindMaxForBeginLessThanNil() {
        List<String> list = Arrays.asList("aaa", "aab", "abb", "bbb", "a", "b");
        Generics.findMax(list, -2, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindMaxForEndMoreThanMaxBound() {
        List<String> list = Arrays.asList("aaa", "aab", "abb", "bbb", "a", "b");
        Generics.findMax(list, 2, 10);
    }

    @Test
    public void checkFindFirst() {
        List<Integer> list1 = Arrays.asList(3, null, 6, 8, 11, 15, 28, 32);
        List<Integer> list2 = Arrays.asList(7, 18, 19, 25, null);
        Predicate<Integer> p = new PrimePredicate(list2);

        assertEquals(4, Generics.findFirst(list1, 0, 6, p));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPrimePredicatePredicate() {
        new PrimePredicate(new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindFirstForEndMoreThanMaxBound() {
        List<Integer> list1 = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        List<Integer> list2 = Arrays.asList(7, 18, 19, 25);
        Predicate<Integer> p = new PrimePredicate(list2);

        Generics.findFirst(list1, 2, 10, p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindFirstForInvalidBounds() {
        List<Integer> list1 = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
        List<Integer> list2 = Arrays.asList(7, 18, 19, 25);
        Predicate<Integer> p = new PrimePredicate(list2);

        Generics.findFirst(list1, 5, 1, p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkFindFirstForEmptyList() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(7, 18, 19, 25);
        Predicate<Integer> p = new PrimePredicate(list2);

        Generics.findFirst(list1, 1, 6, p);
    }
}
