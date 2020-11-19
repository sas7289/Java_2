package Lesson_3;

import java.util.*;

public class Main {
    static int DEFAULT_COUNT = 1;
    public static void main(String[] args) {
        String[] arr = {"GitHub", "GitLab", "Opera", "Firefox", "Ubuntu", "FreeBSD", "Git", "GitLab", "KaliLinux",
        "Windows NT", "Windows Millennium", "Android", "Symbian OS"};
        Map<String, Integer> findOriginal = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!findOriginal.containsKey(arr[i])){
                findOriginal.put(arr[i], DEFAULT_COUNT);
            }
            else {
                findOriginal.put(arr[i], findOriginal.get(arr[i]) + 1);
            }
        }
        phoneBook phoneBook = new phoneBook();
        phoneBook.add("Котовский", "899911556", "1111111", "33131113");
        phoneBook.add("Собакевич", "123");
        ArrayList<String> temp = phoneBook.get("Котовский");
        ArrayList<String> temp2 = phoneBook.get("Овечкин");



        for (int i = 0; i < 3; i++) {
            phoneBook.add();
        }
        for (int i = 0; i < 3; i++) {
            phoneBook.get();
        }
    }
}

