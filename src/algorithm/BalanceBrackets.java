/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 *
 * @author nanang
 */
public class BalanceBrackets {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void runningModule() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input String : ");
        String s = scan.nextLine();
        System.out.println(isBalanced(s));
    }
}
