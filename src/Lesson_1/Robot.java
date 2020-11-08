package Lesson_1;

import java.util.Random;

public class Robot implements Run, Jump {
    Random random = new Random();
    int limitHeight;
    int limitLenght;

    public Robot (){
        this.limitHeight = random.nextInt(5) + 15;
        this.limitLenght = random.nextInt(500) + 1500;
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}
