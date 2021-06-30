package com.yj.tree;

import java.util.HashMap;

/**
 * 依据前序、中序遍历结果构造出二叉树
 * 前：3，9，20，15，7
 * 中：9，3，15，20，7
 *
 *                  3
 *             9        20
 *                   15    7
 */
public class StractTree {
    public static TreeNode buildTree(int[] pre, int[] mid) {
        if (pre == null && mid == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            map.put(mid[i], i);
        }
        return buildTree(pre, 0, pre.length - 1, mid, 0, mid.length - 1, map);
    }

    private static TreeNode buildTree(int[] pre, int pstart, int pend, int[] mid, int istart, int iend, HashMap<Integer, Integer> map) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        System.out.println(pstart + "---"+pend);
        System.out.println("----------"+istart + "---"+iend);
        TreeNode treeNode = new TreeNode(pre[pstart] + "");
        int index = map.get(pre[pstart]);
        treeNode.left = buildTree(pre, pstart + 1, pstart + index - istart, mid, istart, index - 1, map);
        treeNode.right = buildTree(pre, pstart + index - istart + 1, pend, mid, index + 1, iend, map);

        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] mid = {9, 3, 15, 20, 7};

        System.out.println(buildTree(pre, mid).value);//3
        System.out.println(buildTree(pre, mid).left.value);//9
        System.out.println(buildTree(pre, mid).right.value);//20
        System.out.println(buildTree(pre, mid).right.left.value);//15
        System.out.println(buildTree(pre, mid).right.right.value);//7

    }
}
