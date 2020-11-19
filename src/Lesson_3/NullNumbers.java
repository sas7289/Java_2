package Lesson_3;

import java.io.IOException;

public class NullNumbers extends IOException {
    public NullNumbers(String name) {
        super("Контакт " + name + " отсутствует");
    }
}
