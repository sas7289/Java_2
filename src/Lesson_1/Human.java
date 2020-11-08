package Lesson_1;

import java.util.Random;

public class Human implements Run, Jump {
    Random random = new Random();
    int limitHeight;
    int limitLenght;

    public Human (){
        this.limitHeight = random.nextInt(1) + 1;
        this.limitLenght = random.nextInt(950) + 50;
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}
