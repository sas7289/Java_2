package Lesson_1;

import java.util.Random;

public class Wall implements OvercomeObstacles{
    Random random = new Random();
    int currentHeight;

    public Wall(){
        this.currentHeight = random.nextInt(2);
    }

    @Override
    public boolean overcome (Member member){
        if (member.jump(currentHeight)){
            return true;
        }
        return false;
    }
}
