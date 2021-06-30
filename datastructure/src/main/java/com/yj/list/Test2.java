package com.yj.list;

/**
 * 合并两个有序链表   递归，非递归
 */
public class Test2 {
    //递归方法
/*
    public static ListNode mergeList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = null;
        if (a.value > b.value) {
            head = b;
            head.next = mergeList(a, b.next);
        } else {
            head = a;
            head.next = mergeList(a.next, b);
        }
        return head;
    }
*/

    //非递归
    public static ListNode mergeList1(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = a.value < b.value ? a : b;
        ListNode cur1 = head == a ? a : b;
        ListNode cur2 = head == a ? b : a;

        ListNode pre = null;//a的前一个元素
        ListNode next = null;//b的后一个元素
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(10);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        //使用递归查看合并结果
//        MyList.traverse(mergeList(node1, node4));

        //非递归查看
        MyList.traverse((mergeList1(node1, node4)));

    }
}
