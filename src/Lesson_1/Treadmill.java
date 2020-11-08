package Lesson_1;

import java.util.Random;

public class Treadmill extends Barrier {
    Random random = new Random();
    int lenght;

    public Treadmill(){
        this.lenght = random.nextInt(95) + 5;
    }

    public void attemptToJump (Jump jumping){

    }


}
