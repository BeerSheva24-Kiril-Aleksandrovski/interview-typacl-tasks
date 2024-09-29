package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interview.InterviewTasks.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
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
}
