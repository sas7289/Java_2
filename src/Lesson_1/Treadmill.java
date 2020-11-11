package Lesson_1;

import java.util.Random;

public class Treadmill implements OvercomeObstacles {
    Random random = new Random();
    int currentLen;

    public Treadmill(){
        this.currentLen = random.nextInt(95) + 5;
    }

    @Override
    public boolean overcome (Member member){
        if (member.run(currentLen)){
            return true;
        }
        return false;
    }



}
