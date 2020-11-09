package Lesson_1;

import java.util.Random;

public class Human implements Run, Jump {
    Random random = new Random();
    int limitHeight;
    int limitLen;

    public Human (){
        this.limitHeight = random.nextInt(2) + 1;
        this.limitLen = random.nextInt(950);
    }

    @Override
    public boolean jump(int currentHeight) {
        if (currentHeight < limitHeight) {
            System.out.println("Human jump");
            return true;
        }
        System.out.println("These people are soft");
        return false;
    }

    @Override
    public boolean run(int currentLen) {
        if (currentLen < limitLen) {
            System.out.println("Human run");
            return true;
        }
        System.out.println("These people are soft");
        return false;
    }

    @Override
    public String toString() {
        return "Human";
    }
}
