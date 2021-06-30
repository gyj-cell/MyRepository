package com.yj.stackAndQueue;

import jdk.nashorn.internal.ir.CallNode;

public class MyQueue {
    int[] arr;
    int front;//第一个有效元素
    int rear;//最后一个有效元素的下一个元素

    public MyQueue(int[] arr, int front, int rear) {
        this.arr = arr;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判定队列是否满
     */
    public static boolean isFull(MyQueue queue){
       return (queue.rear + 1) % queue.arr.length == queue.front;
    }

    /**
     * 判定队列是否为空
     */
    public static boolean isEmpty(MyQueue queue){
        return queue.rear == queue.front;
    }

    /**
     * 入队
     */
    public static void enQueue(MyQueue queue,int value){
        if (!isFull(queue)){
            queue.arr[queue.rear] = value;
            queue.rear = (queue.rear + 1) % queue.arr.length;
        }
    }

    /**
     * 遍历
     */
    public static void traverse(MyQueue queue){
        int i = queue.front;
        while(i != queue.rear){
            System.out.print(queue.arr[i] + "   ");
            i = (i + 1) % queue.arr.length;
        }
        System.out.println();
    }

    /**
     * 出队
     */
    public static void outQueue(MyQueue queue){
        if (!isEmpty(queue)){
            int value = queue.arr[queue.front];
            System.out.println(value);
            queue.front = (queue.front + 1) % queue.arr.length;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue));

        enQueue(myQueue,1);
        enQueue(myQueue,2);
        enQueue(myQueue,3);
        enQueue(myQueue,4);
        enQueue(myQueue,5);
        enQueue(myQueue,6);

        System.out.println(isFull(myQueue));
        System.out.println(isEmpty(myQueue));
        traverse(myQueue);

        outQueue(myQueue);
        traverse(myQueue);
    }
}
