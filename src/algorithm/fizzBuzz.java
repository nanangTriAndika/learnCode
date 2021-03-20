/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author nanang
 */
public class fizzBuzz {
    public static void fizzBuzz(int n) {
    // Write your code here
        IntStream.rangeClosed(1, n).mapToObj(
            i -> i % 3 == 0 ?
                (i % 5 == 0 ? "FizzBuzz" : "Fizz") :
                (i % 5 == 0 ? "Buzz" : i))
        .forEach(System.out::println);
    }
    
    public static void runningModule() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input case : ");
        int s = scan.nextInt();
        fizzBuzz(s);
    }

}
