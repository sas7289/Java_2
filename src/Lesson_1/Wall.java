package Lesson_1;

import java.util.Random;

public class Wall {
    Random random = new Random();
    int currentHeight;

    public Wall(){
        this.currentHeight = random.nextInt(2);
    }

    public boolean attemptToJump (Jump jumping){
        if (jumping.jump(currentHeight)){
            return true;
        }
        return false;
    }
}
