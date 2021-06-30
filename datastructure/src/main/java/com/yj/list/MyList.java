package com.yj.list;

public class MyList {
    /**
     * 头节点的插入
     */
    public static void headInsert(ListNode head, ListNode newhead) {
        ListNode old = head;
        head = newhead;
        head.next = old;
    }

    /**
     * 尾节点的插入
     */
    public static void tailInsert(ListNode tail, ListNode newtail) {
        ListNode old = tail;
        tail = newtail;
        tail.next = null;
        old.next = tail;
    }

    /**
     * 遍历
     */
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 查找
     */
    public static int find(ListNode head, int value) {
        int index = -1;
        int num = 0;
        while (head != null) {
            if (head.value == value) {
                index = num;
                return index;
            }
            num++;
            head = head.next;
        }
        return index;
    }

    /**
     * 向p节点后插入
     */
    public static void insert(ListNode p, ListNode q) {
        ListNode pnext = p.next;
        p.next = q;
        q.next = pnext;
    }

    /**
     * 删除p
     */
    public static void delete(ListNode head, ListNode p) {
        if (p != null && p.next != null) {
            ListNode q = p.next;
            p.value = q.value;
            p.next = q.next;
            q = null;
        } else {
            while (head.next != null) {
                if (head.next == p) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }

    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        //遍历
        traverse(node1);

        //插入head
        ListNode node0 = new ListNode(0);
        headInsert(node1, node0);
        traverse(node0);

        //插入tail
        ListNode node4 = new ListNode(4);
        tailInsert(node3, node4);
        traverse(node1);
        //查找元素所在下标
        System.out.println(find(node1, 3));
        //插入
        ListNode node5 = new ListNode(5);
        insert(node3, node5);
        traverse(node0);

        //删除元素
        delete(node0, node5);
        traverse(node0);
    }

}


