package com.yj.tree;

/**
 * 最近公共祖先
 */
public class LowestAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null || head == p || head == q){
            return head;
        }
        TreeNode left = lowestCommonAncestor(head.left,p,q);
        TreeNode right = lowestCommonAncestor(head.right,p,q);
        if (left != null && right != null){
            return head;
        }
        return left != null ? left : right;
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

        System.out.println(lowestCommonAncestor(A, B, C).value);//A
        System.out.println(lowestCommonAncestor(A, B, G).value);//A
        System.out.println(lowestCommonAncestor(A, B, D).value);//B
        System.out.println(lowestCommonAncestor(A, B, H).value);//B

    }
}
