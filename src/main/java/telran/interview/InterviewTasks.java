package telran.interview;

import java.util.*;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        boolean res = false;
        int i = 0;
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        while (!res && i < array.length) {
            int diff = sum - array[i];
            if(numToIndexMap.containsKey(diff)) {
                res = true;
            }
            numToIndexMap.put(array[i], i);
            i++;
        }
        return res;
    }
}
