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
public class MissingInteger {

    static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        return j;
    }

    static int findMissingPositive(int arr[], int size) {
        int i;

        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }

        for (i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }

    static int solution(int[] A) {
        // write your code in Java SE 8
        int lengthArr = A.length;

        int shift = segregate(A, lengthArr);
        int arr2[] = new int[lengthArr - shift];
        int j = 0;
        for (int i = shift; i < lengthArr; i++) {
            arr2[j] = A[i];
            j++;
        }
        return findMissingPositive(arr2, j);
    }

    public static void runningModule() {
        int arr[] = {0, 10, 2, -10, -20};
        int missing = solution(arr);
        System.out.println("The smallest positive missing number is " + missing);
        
        int arr2[] = {2, 3, -7, 6, 8, 1, -10, 15};
        int missing2 = solution(arr2);
        System.out.println("The smallest positive missing number is " + missing2);
        
        int arr3[] = {1, 1, 0, -1, -2};
        int missing3 = solution(arr3);
        System.out.println("The smallest positive missing number is " + missing3);

    }

}
