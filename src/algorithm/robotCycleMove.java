/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author nanang
 */
public class robotCycleMove {

    static boolean isCircular(String instructions) {
        int x = 0, y = 0;
        int dir = 0;

        String roboWalk = "";

        for (int j = 0; j < 4; j++) {
            roboWalk += instructions;
        }

        for (int i = 0; i < roboWalk.length(); i++) {
            char move = roboWalk.charAt(i);

            if (move == 'R') {
                dir = (dir + 1) % 4;
            } else if (move == 'L') {
                dir = (4 + dir - 1) % 4;
            } else {
                if (dir == 0) {
                    y++;
                } else if (dir == 1) {
                    x++;
                } else if (dir == 2) {
                    y--;
                } else // dir == 3 
                {
                    x--;
                }
            }
        }

        return (x == 0 && y == 0);
    }

    public static void runningModule() {
        System.out.println(isCircular("GGLLGG"));
        System.out.println(isCircular("GG"));
        System.out.println(isCircular("LL"));
    }

}
