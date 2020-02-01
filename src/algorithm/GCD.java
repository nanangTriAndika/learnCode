/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Scanner;

/**
 *
 * @author nanang
 */
public class GCD {
    // Function to return gcd of a and b 

    static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static int generalizedGCD(int num, int[] arr) {
        int result = arr[0];
        for (int i = 1; i < num; i++) {
            result = gcd(arr[i], result);

            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 16};
        int n = arr.length;
        System.out.println(generalizedGCD(n, arr));
    }

    public static void runningModule() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of array : ");
        int t = scan.nextInt();
        int arr[] = new int[t];

        for (int i = 0; i < t; i++) {
            arr[i] = scan.nextInt();
        }

        scan.close();

        int n = arr.length;
        System.out.println(generalizedGCD(n, arr));
    }
}
