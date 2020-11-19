package Lesson_3;

import java.lang.reflect.Array;
import java.util.*;

public class phoneBook {
    Scanner scanner = new Scanner(System.in);
    Map <String, ArrayList<String>> phoneBook;

    public phoneBook (){
        phoneBook = new HashMap<>();
    }
    public void add (String name, String ... numbers) {
        phoneBook.put(name, new ArrayList<String>(Arrays.<String>asList(numbers)));
    }

    public ArrayList<String> get (String name){
        if (!phoneBook.containsKey(name)){
            System.out.println("Данный контакт отсутствует или неправильно набран");
        }
        return phoneBook.get(name);
    }



    public void add (){
        System.out.println("Введите имя контакта:");
        String name = scanner.nextLine();
        System.out.println("Введите один или несколько номеров телефонов через пробел:");
        String lineOfNumbers = scanner.nextLine();
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(lineOfNumbers.split(" ")));
        phoneBook.put(name, numbers);
    }

    public void get (){
        System.out.println("Введите необходимый контакт");
        String findResult = scanner.nextLine();
        if (phoneBook.containsKey(findResult)){
            for (String s : phoneBook.get(findResult)) {
                System.out.println(s);
            }
        } else {
            System.out.println("Данный контакт отсутствует или неправильно набран");
        }
    }
}
