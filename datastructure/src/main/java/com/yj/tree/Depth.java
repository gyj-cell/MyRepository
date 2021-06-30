package com.yj.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 树的深度  最大 最小
 */
public class Depth {
    //递归方式实现最大深度
    public static int maxDepth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int left = maxDepth(head.left);
        int right = maxDepth(head.right);

        return left >= right ? left + 1 : right + 1;
    }

    //非递归方式
    public static int maxDepth1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return level;
    }

    //最小深度 递归方式
    public static int minDepth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        if (head.left == null && head.right == null) {
            return 1;
        }
        if (head.left == null && head.right != null) {
            return minDepth(head.right) + 1;
        }
        if (head.left != null && head.right == null) {
            return minDepth(head.left) + 1;
        }

        int left = minDepth(head.left);
        int right = minDepth(head.right);
        return left <= right ? left + 1 : right + 1;
    }

    //非递归方式
    public static int minDepth1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null){
                    return level;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return level;
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

        System.out.println(maxDepth(A));
        System.out.println(maxDepth1(A));
        System.out.println(minDepth(A));
        System.out.println(minDepth1(A));
    }
}
