package Lesson_1;

import java.util.Random;

public class Treadmill {
    Random random = new Random();
    int currentLen;

    public Treadmill(){
        this.currentLen = random.nextInt(95) + 5;
    }


    public boolean attemptToRun (Run running){
        if (running.run(currentLen)){
            return true;
        }
        return false;
    }



}
