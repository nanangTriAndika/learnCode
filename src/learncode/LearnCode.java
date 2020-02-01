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
            default:
                System.out.println("Wrong command");
                break;
        }

    }

}
