/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nanang
 */
public class NearestCity {

    public String[] findNearestCities(int numOfPoints, String[] points, int[] xCoordinates,
            int[] yCoordinates, int numOfQueriedPoints, String[] queriedPoints) {

        Map<Integer, List<Integer>> xToyMap = new HashMap<>();
        Map<Integer, List<Integer>> yToxMap = new HashMap<>();
        Map<String, String> idxToNameMap = new HashMap<>();
        Map<String, int[]> nameToIdxMap = new HashMap<>();

        for (int i = 0; i < numOfPoints; i++) {
            int x = xCoordinates[i];
            int y = yCoordinates[i];
            if (!xToyMap.containsKey(x)) {
                xToyMap.put(x, new ArrayList<Integer>());
            }

            xToyMap.get(x).add(y);
            if (!yToxMap.containsKey(y)) {
                yToxMap.put(y, new ArrayList<Integer>());
            }

            yToxMap.get(y).add(x);
            idxToNameMap.put(x + "_" + y, points[i]);
            nameToIdxMap.put(points[i], new int[]{x,y});
        }

        String[] res = new String[numOfQueriedPoints];

        for (int i = 0; i < numOfQueriedPoints; i++) {
            res[i] = getDistance(xToyMap, yToxMap, idxToNameMap, nameToIdxMap, queriedPoints[i]);
        }

        return res;
    }

    public static String getDistance(Map<Integer, List<Integer>> xMap, Map<Integer, List<Integer>> yMap,
            Map<String, String> idxMap, Map<String, int[]> nameMap, String query) {
        int[] location = nameMap.get(query);
        int res = Integer.MAX_VALUE;
        int[] cand = new int[2];

        for (int x : yMap.get(location[1])) {
            if (x == location[0]) {
                continue;
            }
            int distance = Math.abs(x - location[0]);
            if (distance < res) {
                res = distance;
                cand[0] = x;
                cand[1] = location[1];
            }
        }

        for (int y : xMap.get(location[0])) {
            if (y == location[1]) {
                continue;
            }
            int distance = Math.abs(y - location[1]);
            if (distance < res) {
                res = distance;
                cand[0] = location[0];
                cand[1] = y;
            }
        }

        return res == Integer.MAX_VALUE ? null : idxMap.get(cand[0] + "_" + cand[1]);
    }
    
    public static void runningModule() {
       
 
    }
}
