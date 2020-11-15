package Lesson_2;

public class Example {
    public static int transform (String[][] arr) throws MyArrayDataException, MyArraySizeException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < arr.length; i++) {
                for (j = 0; j < arr[0].length; j++) {
                    sum += Integer.parseInt(arr[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException(i, j);
        }
        return sum;
    }
}
