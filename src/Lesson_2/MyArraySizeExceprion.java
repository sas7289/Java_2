package Lesson_2;

class MyArraySizeException extends IndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Размер массива не соответствует размерности 4 х 4");
    }
}
