package Lesson_1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        OvercomeObstacles[] obstacles = new OvercomeObstacles[]{new Wall(), new Treadmill(), new Wall(), new Treadmill(), new Wall(), new Treadmill()};
        Member[] members = new Member[]{new Human(), new Human(), new Human(), new Human(), new Cat(),
                new Cat(),new Cat(),new Cat(), new Robot(),new Robot(),new Robot(),new Robot()};
        ArrayList <Member> winners = new ArrayList<Member>();
        boolean win = false;
        for (Member member : members) {
            for (OvercomeObstacles obstacle : obstacles) {
                    if (!obstacle.overcome(member)){
                        win = false;
                        break;
                    }
                    if (!obstacle.overcome(member)){
                        break;
                    }
                    win = true;
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
