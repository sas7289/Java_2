package Lesson_1;

import java.util.Random;

public class Cat implements Run, Jump{
    Random random = new Random();
    int limitHeight;
    int limitLen;

    public Cat (){
        this.limitHeight = random.nextInt(5) + 1;
        this.limitLen = random.nextInt(650) + 50;
    }

    @Override
    public boolean jump(int currentHeight) {
        if (currentHeight < limitHeight) {
            System.out.println("Cat jump");
            return true;
        }
        return false;
    }

    @Override
    public boolean run(int currentLen) {
        if (currentLen < limitLen) {
            System.out.println("Cat run");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
