package Lesson_2;

public class MyArrayDataException extends ClassCastException {
    public MyArrayDataException(int i, int j) {
        super("Невозможно преобразовать в Integer значения, находящиеся в ячейке [" + i + "][" + j + "]");
    }
}
