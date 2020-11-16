package Lesson_2;

public class Main {
    public static void main(String[] args) {
        String[][] testWrongSize = {{ "23123", "231", "2"},
                {"qwe", "4", "123q", "98"},
                {"b", "90", "231", "2"},
                {"q", "2x2", "231", "2"}};
        String[][] testWrongType = {{ "23123", "231", "2", "42"},
                {"qwe", "4", "123q", "98"},
                {"b", "90", "231", "2"},
                {"q", "2x2", "231", "2"}};
        String[][] testRight = {{ "23123", "231", "2", "42"},
                {"1", "4", "123", "98"},
                {"3", "90", "231", "2"},
                {"55", "22", "231", "2"}};


        try {
//            System.out.println(Example.transform(testWrongSize));
//            System.out.println(Example.transform(testWrongType));
            System.out.println(Example.transform(testRight));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }
}
