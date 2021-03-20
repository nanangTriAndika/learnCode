/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nanang
 */
public class OptimizeMemoryUsage {

    public static List<int[]> optimizeMemoryUsageFunction(int[] foregroundTasks, int[] backgroundTasks, int K) {
        List<int[]> result = new ArrayList<>();
        if (K == 0 || (foregroundTasks.length == 0 && backgroundTasks.length == 0)) {
            result.add(new int[]{-1, -1});
        }

        List<int[]> foregroundTaskList = new ArrayList<>();
        List<int[]> backgroundTaskList = new ArrayList<>();

        for (int i = 0; i < foregroundTasks.length; i++) {
            foregroundTaskList.add(new int[]{i, foregroundTasks[i]});
        }

        for (int i = 0; i < backgroundTasks.length; i++) {
            backgroundTaskList.add(new int[]{i, backgroundTasks[i]});
        }

        foregroundTaskList.sort((p1, p2) -> p1[1] - p2[1]);
        backgroundTaskList.sort((p1, p2) -> p1[1] - p2[1]);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < foregroundTasks.length; i++) {
            if (foregroundTaskList.get(i)[1] == K) {
                result.add(new int[]{foregroundTaskList.get(i)[0], -1});
                max = foregroundTaskList.get(i)[1];
            }
        }

        for (int i = backgroundTasks.length - 1; i >= 0; i--) {
            if (backgroundTaskList.get(i)[1] == K) {
                result.add(new int[]{-1, backgroundTaskList.get(i)[0]});
                max = backgroundTaskList.get(i)[1];
            }
        }

        if (foregroundTasks.length > 0 && backgroundTasks.length == 0) {
            for (int i = 0; i < foregroundTasks.length; i++) {
                if (foregroundTaskList.get(i)[1] < K) {
                    result.add(new int[]{foregroundTaskList.get(i)[0], -1});
                }
            }

            return result;
        }

        if (backgroundTasks.length > 0 && foregroundTasks.length == 0) {
            for (int i = backgroundTasks.length - 1; i >= 0; i--) {
                if (backgroundTaskList.get(i)[1] < K) {
                    result.add(new int[]{-1, backgroundTaskList.get(i)[0]});
                }
            }

            return result;
        }

        int i = 0;
        int j = backgroundTasks.length - 1;
        while (i < foregroundTasks.length && j >= 0) {
            int sum = foregroundTaskList.get(i)[1] + backgroundTaskList.get(j)[1];

            if (sum > K) {
                j = j - 1;
            } else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{foregroundTaskList.get(i)[0], backgroundTaskList.get(j)[0]});
                    int index = j - 1;
                    while (index >= 0
                            && backgroundTaskList.get(index)[1] == backgroundTaskList.get(index + 1)[1]) {
                        result.add(new int[]{foregroundTaskList.get(i)[0], backgroundTaskList.get(index)[0]});
                        index--;
                    }
                }
                ++i;
            }
        }

        return result;

    }

    public static void runningModule() {

        List<int[]> result = new ArrayList<>();

        result = optimizeMemoryUsageFunction(new int[]{1, 7, 2, 4, 5, 6}, new int[]{3, 1, 2}, 6);
        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(Arrays.toString(result.get(i)) + " ");
        }
        System.out.println("");

        List<int[]> result2 = result = new ArrayList<>();

        result2 = optimizeMemoryUsageFunction(new int[]{1, 7, 2, 4, 5, 6}, new int[]{1, 1, 2}, 10);

        for (int i = 0; i < result2.size(); i++) {
            System.out.println(Arrays.toString(result2.get(i)));
        }

    }
}
