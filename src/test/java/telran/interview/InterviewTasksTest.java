package telran.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interview.InterviewTasks.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    private static final LocalDate DATE1 = LocalDate.of(2019, 12, 31);
    private static final LocalDate DATE2 = LocalDate.of(2021, 10, 30);
    private static final LocalDate DATE3 = LocalDate.of(2021, 12, 31);
    private static final LocalDate DATE4 = LocalDate.of(2024, 1, 1);
    private static final String ROLE1 = "Developer";
    private static final String ROLE2 = "Senior Developer";
    private static final String ROLE3 = "Manager";

    @Test
    void hasSumTwoTrueTest() {
        int[] array = { 1, 2, 3, 4, 5 };
        assertTrue(hasSumTwo(array, 5));

        int[] arrayWithNeg = { -1, -4, -5 };
        assertTrue(hasSumTwo(arrayWithNeg, -5));

        int[] arrayWithZero = { 0, 0, 0, 0, 0 };
        assertTrue(hasSumTwo(arrayWithZero, 0));

        int[] largeArray = new int[100000];
        Random random = new Random();
        int sum = largeArray[random.nextInt(100000)] + largeArray[random.nextInt(100000)]; // Large sum
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = random.nextInt(1000000) - 500000; // Large numbers
        }
        assertTrue(hasSumTwo(largeArray, sum));

        int[] arrayWithDuplicates = { 1, 2, 3, 2, 1 };
        assertTrue(hasSumTwo(arrayWithDuplicates, 4));

        int[] arrayWithZeroDuplicates = { 0, 0, 0, 0, 0, 0 };
        assertTrue(hasSumTwo(arrayWithZeroDuplicates, 0));
    }

    @Test
    void hasSumTwoFalseTest() {
        int[] emptyArray = {};
        assertFalse(hasSumTwo(emptyArray, 5));

        int[] arrayWithoutSum = { 1, 3, 5, 7, 9 };
        assertFalse(hasSumTwo(arrayWithoutSum, 13));

        int[] singleElementArray = { 5 };
        assertFalse(hasSumTwo(singleElementArray, 10));
    }

    @Test
    void getMaxWithNegativePresentation() {
        int[] array1 = { 200, 10, -10, 1, 2, 3, -3, -200 };
        int[] array2 = { -200, -200, 100, 10, 10 };
        int[] array3 = { -200, 10, -10, 1, 2, 3, -3, 200 };
        assertEquals(200, InterviewTasks.getMaxWithNegativePresentation(array1));
        assertEquals(-1, InterviewTasks.getMaxWithNegativePresentation(array2));
        assertEquals(200, InterviewTasks.getMaxWithNegativePresentation(array3));
    }

    @Test
    void assignRoleDatesTest() {
        List<DateRole> history = List.of(
                new DateRole(LocalDate.of(2020, 1, 1), ROLE1),
                new DateRole(LocalDate.of(2021, 1, 1), ROLE2),
                new DateRole(LocalDate.of(2022, 1, 1), ROLE3));
        List<LocalDate> dates = List.of(
                DATE1,
                DATE2,
                DATE3,
                DATE4);

        List<DateRole> expected = List.of(
                new DateRole(DATE1, null),
                new DateRole(DATE2, ROLE2),
                new DateRole(DATE3, ROLE2),
                new DateRole(DATE4, ROLE3));
        assertIterableEquals(expected, InterviewTasks.assignRoleDates(history, dates));
    }

    @Test
    void isAnagramTest() {
        String word = "hello";
        assertTrue(InterviewTasks.isAnagram(word, "olleh"));
        assertTrue(InterviewTasks.isAnagram(word, "elloh"));
        assertTrue(InterviewTasks.isAnagram(word, "hleol"));
        assertFalse(InterviewTasks.isAnagram(word, word));
        assertFalse(InterviewTasks.isAnagram(word, "olle"));
        assertFalse(InterviewTasks.isAnagram(word, "ollhh"));
        assertFalse(InterviewTasks.isAnagram(word, "olehd"));
    }
}
