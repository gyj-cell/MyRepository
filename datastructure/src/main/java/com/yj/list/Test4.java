package com.yj.list;

/**
 * 单链表的归并排序
 */
public class Test4 {
    public static ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slou = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slou = slou.next;
        }
        return slou;
    }

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

    public static ListNode sort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode node = merge(sort(head),sort(right));
        return node;
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
        MyList.traverse(sort(node1));
    }
}
