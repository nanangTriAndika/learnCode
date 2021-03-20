/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nanang
 */
public class UtilizationChecks {

    public static int finalInstances(int instances, int[] averageUtil) {
        for (int i = 0; i < averageUtil.length; i++) {

            if (averageUtil[i] < 25 && instances > 1) {
                instances = (int) (Math.ceil(instances / 2.0));
                i += 10;
            }
            if (i < averageUtil.length && averageUtil[i] > 60 && instances < 200000000) {
                instances *= 2;
                i += 10;
            }
        }

        return instances;
    }

    public static void runningModule() {

        System.out.println(finalInstances(2, new int[]{25, 23, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 76, 80}));
        System.out.println(finalInstances(5, new int[]{6, 30, 5, 4, 8, 19, 89}));
    }
}
