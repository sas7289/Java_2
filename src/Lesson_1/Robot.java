package Lesson_1;

import java.util.Random;

public class Robot implements Member{
    Random random = new Random();
    int limitHeight;
    int limitLen;

    public Robot (){
        this.limitHeight = random.nextInt(15);
        this.limitLen = random.nextInt(1500);
    }

    @Override
    public boolean jump(int currentHeight) {
        if (currentHeight < limitHeight) {
            System.out.println("Robot jump");
            return true;
        }
        System.out.println("The robot is broken");
        return false;
    }

    @Override
    public boolean run(int currentLen) {
        if (currentLen < limitLen) {
            System.out.println("Robot run");
            return true;
        }
        System.out.println("The robot is broken");
        return false;
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
