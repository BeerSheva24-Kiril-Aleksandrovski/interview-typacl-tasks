package telran.interview;

import java.time.LocalDate;
import java.util.*;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        boolean res = false;
        int i = 0;
        Set<Integer> numToIndexMap = new HashSet<>();
        while (i < array.length && !res) {
            int diff = sum - array[i];
            if (numToIndexMap.contains(diff)) {
                res = true;
            }
            numToIndexMap.add(array[i]);
            i++;
        }
        return res;
    }

    /**
     * returns maximal positive value for which exists negative one with the same
     * abs value
     * if no pair of positive and negative values with the same abs value the method
     * returns -1
     * complexity O[N] only one pass over the elements
     */
    static public int getMaxWithNegativePresentation(int[] array) {
        Integer maxPos = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(-array[i])) {
                int absNum = Math.abs(array[i]);
                if (maxPos < absNum) {
                    maxPos = absNum;
                }
            }
            set.add(array[i]);
        }
        return maxPos;
    }

    /**
     * rolesHistory is the list containing dates and roles assigned to the employees
     * at the appropriate dates
     * for example, date => 2019-01-01, role => Developer means that some employee
     * (no matter who) was taken
     * role Developer at 2019-01-01
     * create List<DateRole> with roles matching with the given dates
     * most effective data structure
     * 
     * @param rolesHistory
     * @param dates
     * @return
     */
    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        TreeMap<LocalDate, String> history = new TreeMap<>();
        rolesHistory.forEach(i -> history.put(i.date(), i.role())); // O(log n)

        List<DateRole> roles = dates.stream().map(date -> { // O(n)
            LocalDate floorKey = history.floorKey(date);   //O(lon n)                 //greatest key less than or equal to the given key, or null if there is no such key.
            String role = floorKey != null ? history.get(floorKey) : null;
            return new DateRole(date, role);
        }).toList();

        return roles;
    }

    /**
     * returns true if "anagram" string contains all
     * letters from "word" in another order (case sensitive)
     * O[N] (sorting is disallowed)
     */
    public static boolean isAnagram(String word, String anagram) {
        return word.length() == anagram.length() && !word.equals(anagram) && checkLetters(word, anagram);
    }

    private static boolean checkLetters(String word, String anagram) {
        boolean res = true;
        Map<Character, Integer> counterWord = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char chWord = word.charAt(i);
            counterWord.put(chWord, counterWord.getOrDefault(chWord, 0) + 1);
        }

        int j = 0;
        while (res && j < anagram.length()) {
            char letter = anagram.charAt(j);
            int count = counterWord.getOrDefault(letter, 0);
            if (count > 0) {
                counterWord.put(letter, count - 1);
                j++;
            } else {
                res = false;
            }
        }

        return res;
    }
}
