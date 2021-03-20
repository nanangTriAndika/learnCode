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
public class criticalConnections {

    static boolean[] visited;      // Whether we visited this node before
    static List<Integer>[] graph;  // Adjacent list of the graph
    static int[] low;              // Low value of this node: lowest id this node can reach
    static int[] ids;              // Id of this node
    static int id;                 // Current id
    static List<List<Integer>> ans;// List of all the critical connections

    private static void DFS(int at, int parent) {
        visited[at] = true;
        ids[at] = ++id;
        low[at] = ids[at];

        // For edge from "at" to "to"
        for (int to : graph[at]) {
            if (to == parent) {
                continue; // Avoid duplicates: [1, 3] and [3, 1]
            }
            if (!visited[to]) {
                DFS(to, at);
                low[at] = Math.min(low[at], low[to]); // Update low when children nodes reach nodes with lower id

                // If there is no other way between "at" and "to", this edge is a critical connection
                if (ids[at] < low[to]) {
                    ans.add(Arrays.asList(at, to));
                }

            } else {
                low[at] = Math.min(low[at], ids[to]); // Update low[at] because of the edge from "at" to "to"
                // ??: Can we use low[at] = Math.min(low[at], low[to]); here?
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // Init the instance variables
        visited = new boolean[n];
        graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        low = new int[n];
        ids = new int[n];
        id = 0;
        ans = new ArrayList<>();

        // Init the graph adjacent list
        for (List<Integer> c : connections) {
            graph[c.get(0)].add(c.get(1));
            graph[c.get(1)].add(c.get(0));
        }

        // Run DFS from every possible nodes in the graph
        id = 0;
        for (int i = 0; i < n; i++) {
            // Start DFS from node i with no parent
            if (!visited[i]) {
                DFS(i, -1);
            }
        }

        return ans;

    }

    public static void runningModule() {

        List<List<Integer>> data = new ArrayList();
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < 4; i++) {
            List<Integer> listAtI = new ArrayList();
            if(i == 0){
                 listAtI.set(0,1);
            }
            if(i == 1){
                 listAtI.set(1,2);
            }
            if(i == 2){
                 listAtI.set(2,0);
            }
            if(i == 3){
                 listAtI.set(1,3);
            }
            data.set(i, listAtI);
        }

        result = criticalConnections(4, data);
         for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
