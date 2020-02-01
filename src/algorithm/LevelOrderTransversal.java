/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.util.Scanner;

class NodeTransversal {

    int data;
    NodeTransversal left, right;

    NodeTransversal(int item) {
        this.data = item;
        left = right = null;
    }

}

/**
 *
 * @author nanang
 */
public class LevelOrderTransversal {

    public static int maxDepthWithRoot(NodeTransversal node) {
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
    
    public static void printGivenLevel (NodeTransversal root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.data + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
    
    public static void levelOrder(NodeTransversal root) {
        int h = maxDepthWithRoot(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
        }
    }

    public static NodeTransversal insert(NodeTransversal root, int data) {
        if (root == null) {
            return new NodeTransversal(data);
        } else {
            NodeTransversal cur;
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
        System.out.print("Enter number of nodes : ");
        int t = scan.nextInt();
        NodeTransversal root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }
}
