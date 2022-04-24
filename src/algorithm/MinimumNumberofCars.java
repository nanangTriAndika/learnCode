/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.stream.*;
import java.util.Arrays;

/**
 *
 * @author nanang
 */
public class MinimumNumberofCars {
    
     static int solution(int[] P, int[] S) {
        int result = 0;
        int totalPeople = IntStream.of(P).sum();
        int totalSeat = IntStream.of(S).sum();

        int diff = totalSeat - totalPeople;

        Arrays.sort(P);

        int i=0;
        while(i<P.length && diff >= P[i]){
            i++;
            diff -= P[i];
            result++;
        }

        return P.length - result;
    }
    
      public static void runningModule() {
        int[] P1 = {1,4,1};
        int[] S1 = {1,5,1};
          
        System.out.println(solution(P1,S1));
        
        int[] P2 = {4,4,2,4};
        int[] S2 = {5,5,2,5};
        
        System.out.println(solution(P2,S2));
        
        int[] P3 = {2,3,4,2};
        int[] S3 = {2,5,7,2};
        
        System.out.println(solution(P3,S3));
         
    }
}
