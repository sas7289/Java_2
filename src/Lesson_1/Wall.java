package Lesson_1;

import java.util.Random;

public class Wall extends Barrier {
    Random random = new Random();
    int height;

    public Wall(){
        this.height = random.nextInt(9) +1;
    }
}
