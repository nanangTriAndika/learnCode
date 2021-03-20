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
public class throttlingGateway {

    public static int requestCheck(int[] request) {
        int ans = 0;
        for (int i = 0; i < request.length; i++) {

            if (i > 2 && request[i] == request[i - 3]) {
                ans++;
            } else if (i > 19 && (request[i] - request[i - 20]) < 10) {
                ans++;
            } else if (i > 59 && (request[i] - request[i - 60]) < 60) {
                ans++;
            }
        }
        
        return ans;
    }
    
    public static void runningModule() {
        System.out.println(requestCheck(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7,7,7,7, 11, 11, 11, 11}));
        System.out.println(requestCheck(new int[]{1, 1, 1, 1, 2}));
    }
}
