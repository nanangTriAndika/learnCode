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
public class MoviesOnFlight {

    public static List<Integer> getMovies(int[] movies, int flight) {
        flight -= 30;
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        ans.add(-1);
        
        // Sort the movies by length
        int[][] moviesChoose = new int[movies.length][2];
        for(int i = 0; i < movies.length; i++) {
            moviesChoose[i][0] = movies[i]; // Movie duration
            moviesChoose[i][1] = i;       // Original index of the movie
        }
        Arrays.sort(moviesChoose, (a, b) -> a[0] - b[0]);
        
        int l = 0, r = movies.length -1;
        int max = 0;
        while(l < r) {
            if(moviesChoose[l][0] + moviesChoose[r][0] > flight) {
                r--;
            } else {
                if(moviesChoose[l][0] + moviesChoose[r][0] > max) {
                    max = moviesChoose[l][0] + moviesChoose[r][0];
                    
                    //To show movies data
                    ans.set(0, moviesChoose[l][0]);
                    ans.set(1, moviesChoose[r][0]);
                    
                    //To show movies index
                 //   ans.set(0, moviesChoose[l][1]);
                   // ans.set(1, moviesChoose[r][1]);
                }
                l++;
            }
        }
        
        return ans;
    }
     
  /*  public static void runningModule() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter movies : ");
        int t = scan.nextInt();
        int arr[] = new int[t];

        for (int i = 0; i < t; i++) {
            System.out.print("Enter movie-" + i + "duration : ");
            arr[i] = scan.nextInt();
        }
        System.out.print("Enter flight duration : ");
        int d = scan.nextInt();

        scan.close();

        System.out.println(getMovies(arr, d)); 
    }*/
    
    public static void runningModule() {
       

        System.out.println(getMovies(new int[]{90, 85, 75, 60, 120, 150, 125}, 250));
        System.out.println(getMovies(new int[]{90, 85, 75, 60, 155, 150, 125}, 250));
        System.out.println(getMovies(new int[]{90, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
        System.out.println(getMovies(new int[]{95, 85, 75, 60, 120, 110, 110, 150, 125}, 250));
        System.out.println(getMovies(new int[]{1, 10, 25, 35, 60}, 90));
        System.out.println(getMovies(new int[]{20, 50, 40, 25, 30, 10}, 90));
        System.out.println(getMovies(new int[]{5, 55, 40, 20, 30, 30}, 90));
    }
}
