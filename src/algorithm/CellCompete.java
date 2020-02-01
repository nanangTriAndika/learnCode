/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nanang
 */
public class CellCompete {

    private List<Integer> finalStates = new ArrayList<>();

    public static void main(String[] args) {
        // int arr[] = { 1, 0, 0, 0, 0, 1, 0, 0 };
        // int days = 1;
        CellCompete eightHousePuzzle = new CellCompete();
        int arr[] = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        eightHousePuzzle.cellCompete(arr, days);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

    public List<Integer> cellCompete(int[] states, int days) {
        List<Integer> stateList = new ArrayList<Integer>(states.length);

        for (int i : states) {
            stateList.add(i);
        }

        return getCellStateAfterNDays(stateList, days);
    }

    private List<Integer> getCellStateAfterNDays(List<Integer> currentCellStates, int days) {
        List<Integer> changedCellStates = new ArrayList<>();
        int stateUnoccupied = 0;
        if (days != 0) {
            for (int i1 = 0; i1 < currentCellStates.size(); i1++) {
                if (i1 == 0) {
                    changedCellStates.add(calculateCellState(stateUnoccupied, currentCellStates.get(i1 + 1)));

                } else if (i1 == 7) {
                    changedCellStates.add(calculateCellState(currentCellStates.get(i1 - 1), stateUnoccupied));

                } else {
                    changedCellStates
                            .add(calculateCellState(currentCellStates.get(i1 - 1), currentCellStates.get(i1 + 1)));
                }
            }
            if (days == 1) {
                finalStates = new ArrayList<>(changedCellStates);
                return finalStates;
            }
            days = days - 1;
            getCellStateAfterNDays(changedCellStates, days);
        }
        return finalStates;
    }

    private int calculateCellState(int previousLeft, int previousRight) {
        if ((previousLeft == 0 && previousRight == 0) || (previousLeft == 1 && previousRight == 1)) {
            return 0;
        }
        return 1;
    }

    public static void runningModule() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of array : ");
        int t = scan.nextInt();
        int arr[] = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.print("Enter how many days : ");
        int d = scan.nextInt();

        scan.close();
        CellCompete eightHousePuzzle = new CellCompete();
        eightHousePuzzle.cellCompete(arr, d);

        for (int i = 0; i < eightHousePuzzle.finalStates.size(); i++) {
            System.out.print(eightHousePuzzle.finalStates.get(i));
            System.out.print(" ");
        }
    }
}
