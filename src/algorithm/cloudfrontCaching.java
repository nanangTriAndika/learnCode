/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author nanang
 */
public class cloudfrontCaching {

    static Map<Integer, List<Integer>> g;
    static boolean[] visited;

    private static int doBFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            if (!g.containsKey(cur)) {
                continue;
            }
            for (int next : g.get(cur)) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return (int) (Math.ceil(Math.sqrt(cnt)));
    }

    public static int getEfficiencyOfCloudFrontCaching(int N, int[][] edges) {
        g = new HashMap<>();
        visited = new boolean[N];
        for (int i = 0; i < edges.length; ++i) {
            int src = edges[i][0] - 1, dest = edges[i][1] - 1;
            if (!g.containsKey(src)) {
                g.put(src, new ArrayList<>());
            }
            if (!g.containsKey(dest)) {
                g.put(dest, new ArrayList<>());
            }
            g.get(src).add(dest);
            g.get(dest).add(src);
        }

        int res = 0;
        for (int i = 0; i < N; ++i) {
            if (!visited[i]) {
                res += doBFS(i);
            }
        }
        return res;
    }

    public static void runningModule() {
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 4}, {3, 5}, {7, 8}};
        System.out.println(getEfficiencyOfCloudFrontCaching(10, edges1));
        int[][] edges2 = {{1, 2}, {1, 4}};
        System.out.println(getEfficiencyOfCloudFrontCaching(4, edges2));
        int[][] edges3 = {{8, 1}, {5, 8}, {7, 3}, {8, 6}};
        System.out.println(getEfficiencyOfCloudFrontCaching(8, edges3));
    }

}
