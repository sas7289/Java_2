package Lesson_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        String[] arr = {"GitHub", "GitLab", "Opera", "Firefox", "Ubuntu", "FreeBSD", "Git", "GitLab", "KaliLinux",
        "Windows NT", "Windows Millennium", "Android", "Symbian OS"};
        Map <String, Integer> result = CountString.calcCount(arr);




        phoneBook phoneBook = new phoneBook();
        phoneBook.add("Котовский", "899911556", "1111111", "33131113");
        phoneBook.add("Собакевич", "123");

        try {
            ArrayList<String> temp = phoneBook.get("Котовский");
        } catch (NullNumbers e){
            e.printStackTrace();
        }

        try {
            ArrayList<String> temp2 = phoneBook.get("Овечкин");
        } catch (NullNumbers e){
            e.printStackTrace();
        }


        //Вариант с консолью))
        for (int i = 0; i < 3; i++) {
            phoneBook.add();
        }
        for (int i = 0; i < 3; i++) {
            phoneBook.get();
        }
    }
}

