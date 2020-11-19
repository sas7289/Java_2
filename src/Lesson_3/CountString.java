package Lesson_3;

import java.util.HashMap;
import java.util.Map;

public class CountString {
    static int DEFAULT_COUNT = 1;
    public static Map<String, Integer> calcCount(String[] arr) {
        Map<String, Integer> findOriginal = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!findOriginal.containsKey(arr[i])) {
                findOriginal.put(arr[i], DEFAULT_COUNT);
            } else {
                findOriginal.put(arr[i], findOriginal.get(arr[i]) + 1);
            }
        }
        return findOriginal;
    }
}
