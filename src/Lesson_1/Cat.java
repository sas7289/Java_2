package Lesson_1;

import java.util.Random;

public class Cat implements Run, Jump{
    Random random = new Random();
    int limitHeight;
    int limitLenght;

    public Cat (){
        this.limitHeight = random.nextInt(5) + 1;
        this.limitLenght = random.nextInt(650) + 50;
    }

    @Override
    public void jump() {

    }

    @Override
    public void run() {

    }
}
