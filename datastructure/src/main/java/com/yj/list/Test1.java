package com.yj.list;

/**
 * 单链表的反转，查找中间元素
 */
public class Test1 {
    /**
     * 链表反转
     */
    public static ListNode reversetList(ListNode head) {
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

    /**
     * 取中间节点
     */
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        //取中间节点
        System.out.println(getMid(node1).value);//2

        //链表反转
        MyList.traverse(node1);//1 2 3
        ListNode listNode = reversetList(node1);
        MyList.traverse(listNode);//3 2 1
    }
}
