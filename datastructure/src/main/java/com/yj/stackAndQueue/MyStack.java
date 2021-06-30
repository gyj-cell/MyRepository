package com.yj.stackAndQueue;

import com.yj.list.ListNode;

public class MyStack {
    ListNode statckTop;
    ListNode statckBottom;

    public MyStack(ListNode statckTop, ListNode statckBottom) {
        this.statckTop = statckTop;
        this.statckBottom = statckBottom;
    }

    /**
     * 入栈
     */
    public static void pushStatck(MyStack stack , int value){
        ListNode node = new ListNode(value);
        node.next = stack.statckTop;
        stack.statckTop = node;
    }

    /**
     * 遍历
     */
    public static void travese(MyStack stack){
        ListNode stackTop = stack.statckTop;
        while (stackTop != stack.statckBottom){
            System.out.print(stackTop.value + "   ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    /**
     *判断栈是否为空
     */
    public static boolean isEmpty(MyStack stack){
        return stack.statckTop == stack.statckBottom;
    }

    /**
     * 出栈
     */
    public static void popStack(MyStack stack){
        if(!isEmpty(stack)){
            ListNode stackTop = stack.statckTop;
            stack.statckTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    /**
     * 清空栈
     */
    public static void clearStack(MyStack stack){
        stack.statckTop = null;
        stack.statckBottom = stack.statckTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0),new ListNode(0));
        myStack.statckBottom = myStack.statckTop;

        System.out.println(isEmpty(myStack));

        pushStatck(myStack,1);

        System.out.println(isEmpty(myStack));
        travese(myStack);//1
        pushStatck(myStack,2);
        travese(myStack);//2 1

        popStack(myStack);//2

        clearStack(myStack);
        System.out.println(isEmpty(myStack));//true
        travese(myStack);//
    }
}
