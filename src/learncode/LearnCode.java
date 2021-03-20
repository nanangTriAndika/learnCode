/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learncode;

import algorithm.BFS;
import algorithm.BalanceBrackets;
import algorithm.CellCompete;
import algorithm.Djikstra;
import algorithm.GCD;
import algorithm.HeightofTree;
import algorithm.LevelOrderTransversal;
import algorithm.MoviesOnFlight;
import algorithm.NearestCity;
import algorithm.OptimizeMemoryUsage;
import algorithm.UtilizationChecks;
import algorithm.cloudfrontCaching;
import algorithm.criticalConnections;
import algorithm.fizzBuzz;
import algorithm.robotCycleMove;
import algorithm.throttlingGateway;
import algorithm.zombieMatrix;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author nanang
 */
public class LearnCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Learning Algorithm ! You can see the source code for learn how the algorithm work");
        System.out.println("Please choose Algoritm you want to try");
        System.out.println("1. BFS ( https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem )");
        System.out.println("2. Dijkstra ( https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/ )");
        System.out.println("3. Heigh of tree ( https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree )");
        System.out.println("4. Level Order Transversal ( https://www.hackerrank.com/challenges/tree-level-order-traversal )");
        System.out.println("5. Balance brackets ( https://www.hackerrank.com/challenges/balanced-brackets )");
        System.out.println("6. Cell compete scenario 8 puzzle ");
        System.out.println("7. GCD scenario ");
        System.out.println("8. Movies on Flight ( https://aonecode.com/amazon-online-assessment-utilization-checks )");
        System.out.println("9. fizzBuzz ( https://www.hackerrank.com/test/681nbpt0q5b/questions/521e954e6ff11 ) ");
        System.out.println("10. utilizationChecks ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("11. optimizeMemoryUsage ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("12. criticalConnections ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("13. nearestCity ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("14. throttlingGateway ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("15. zombieMatrix ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("16. cloudfronCaching ( https://aonecode.com/amazon-online-assessment-utilization-checks ) ");
        System.out.println("17. robotBoundedInCycle ( https://leetcode.com/problems/robot-bounded-in-circle ) ");
        System.out.print("Enter command : ");
        Scanner scanner = new Scanner(System.in);

        int command = scanner.nextInt();
        switch (command) {
            case 1:
                BFS.runningModule();
                break;
            case 2:
                Djikstra.runningModule();
                break;
            case 3:
                HeightofTree.runningModule();
                break;
            case 4:
                LevelOrderTransversal.runningModule();
                break;
            case 5:
                BalanceBrackets.runningModule();
                break;
            case 6:
                CellCompete.runningModule();
                break;
            case 7:
                GCD.runningModule();
                break;
            case 8:
                MoviesOnFlight.runningModule();
                break;
            case 9:
                fizzBuzz.runningModule();
                break;
            case 10:
                UtilizationChecks.runningModule();
                break;
            case 11:
                OptimizeMemoryUsage.runningModule();
                break;
            case 12:
                criticalConnections.runningModule();
                break;
            case 13:
                NearestCity.runningModule();
                break;
            case 14:
                throttlingGateway.runningModule();
                break;
            case 15:
                zombieMatrix.runningModule();
                break;
            case 16:
                cloudfrontCaching.runningModule();
                break;
            case 17:
                robotCycleMove.runningModule();
                break;
            default:
                System.out.println("Wrong command");
                break;
        }

    }

}
