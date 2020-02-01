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
class Node {

    int data;
    Node left, right;

    Node(int item) {
        this.data = item;
        left = right = null;
    }

}

public class HeightofTree {

    /* Compute the "maxDepth" of a tree -- the number of  
       nodes along the longest path from the root node  
       down to the farthest leaf node.*/
    public static int maxDepthWithoutRoot(Node node) {
        if (node == null) {
            return -1;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepthWithoutRoot(node.left);
            int rDepth = maxDepthWithoutRoot(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static int maxDepthWithRoot(Node node) {
        if (node == null) {
            return 0;
        } else {
            /* compute the depth of each subtree */
            int lDepth = maxDepthWithRoot(node.left);
            int rDepth = maxDepthWithRoot(node.right);

            /* use the larger one */
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void runningModule() {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Type of computing height ( with root branch = Y / without root branch = N ) : ");
        char cmd = scan.next().charAt(0);

        System.out.print("Enter number of nodes : ");
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();

        int height = 0;
        if (cmd == 'Y') {
            height = maxDepthWithRoot(root);
        } else {
            height = maxDepthWithoutRoot(root);
        }
        System.out.println("Height of tree is : " + height);

    }
}
