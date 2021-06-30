package com.yj.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 非递归方式实现树的遍历
 */
public class Traverse {
    //前序遍历
    public static void preTraverse(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.value + "   ");
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        System.out.println();
    }

    //中序遍历
    public static void midTraverse(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "   ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    //后序遍历
    public static void afterTraverse(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack1 = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    stack1.push(pop);
                    if (pop.left != null){
                        stack.push(pop.left);
                    }
                    if (pop.right != null){
                        stack.push(pop.right);
                    }
                }
            while (!stack1.isEmpty()){
                System.out.print(stack1.pop().value + "   ");
            }
            System.out.println();
        }
    }

    //层次遍历
    public static void levelTraverse(TreeNode head){
        if (head != null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(head);

            while (!queue.isEmpty()){
                int levelNUm = queue.size();
                for (int i = 0; i < levelNUm; i++) {
                    TreeNode poll = queue.poll();
                    System.out.print(poll.value + "   ");

                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                    if (poll.right != null){
                        queue.offer(poll.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        E.right = J;
        F.right = K;
        //前序遍历
        preTraverse(A);//A   B   D   H   I   E   J   C   F   K   G
        midTraverse(A);//H   D   I   B   E   J   A   F   K   C   G
        afterTraverse(A);//H   I   D   J   E   B   K   F   G   C   A
        levelTraverse(A);//A   B   C   D   E   F   G   H   I   J   K
    }
}
