package Lesson_1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Object[] barriers = new Object[]{new Wall(), new Treadmill(), new Wall(), new Treadmill(), new Wall(), new Treadmill()};
        Object[] members = new Jump[]{new Human(), new Human(), new Human(), new Human(), new Cat(),
                new Cat(),new Cat(),new Cat(), new Robot(),new Robot(),new Robot(),new Robot()};
        ArrayList <Object> winners = new ArrayList<Object>();
        boolean win = false;
        for (Object member : members) {
            for (Object barrier : barriers) {
                if (barrier instanceof Wall){
                    if (!((Wall) barrier).attemptToJump((Jump)member)){
                        win = false;
                        break;
                    }
                }
                else {
                    if (!((Treadmill) barrier).attemptToRun((Run)member)){
                        break;
                    }
                    win = true;
                }
            }
            if (win) {
                System.out.println("These " + member + " won");
                winners.add(member);
            }
        }

        System.out.println("Winners:");
        for (Object winner : winners) {
            System.out.println(winner);
        }
    }


}
