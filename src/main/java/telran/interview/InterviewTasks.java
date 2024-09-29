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
        Set<Integer> numToIndexMap = new HashSet<>();
        while (!res && i < array.length) {
            int diff = sum - array[i];
            if(numToIndexMap.contains(diff)) {
                res = true;
            }
            numToIndexMap.add(array[i]);
            i++;
        }
        return res;
    }
}
