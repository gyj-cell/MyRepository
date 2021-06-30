package com.yj.list;

/**
 * 一个链表奇数位置升序，偶数位降序，对该链表排序
 * 例如 1 8 3 6 5 4 7 2 9
 * 1 2 3 4 5 6 7 8 9
 */
public class Test3 {
    //按照奇偶位进行拆分
    public static ListNode[] getList(ListNode head) {
        ListNode a = null;
        ListNode b = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        int count = 1;

        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 == null) {
                    cur1 = head;
                    a = cur1;
                } else {
                    cur1.next = head;
                    cur1 = cur1.next;
                }
            } else if (count % 2 == 0) {
                if (cur2 == null) {
                    cur2 = head;
                    b = cur2;
                } else {
                    cur2.next = head;
                    cur2 = cur2.next;
                }
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;
        return new ListNode[]{a, b};
    }

    //链表反转
    public static ListNode reverset(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //链表的合并
    public static ListNode merge(ListNode a, ListNode b) {
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

    //排序
    public static ListNode sort(ListNode head){
        ListNode[] list = getList(head);
        ListNode rever = reverset(list[1]);
        return merge(list[0],rever);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        MyList.traverse(node1);
//        ListNode[] list = getList(node1);
//        MyList.traverse(list[0]);
//        MyList.traverse(list[1]);
//        MyList.traverse(reverset(list[1]));
//        ListNode listNode = list[0];
//        ListNode listNode2 = reverset(list[1]);
//        MyList.traverse(merge(listNode,listNode2));
        MyList.traverse(sort(node1));
    }
}