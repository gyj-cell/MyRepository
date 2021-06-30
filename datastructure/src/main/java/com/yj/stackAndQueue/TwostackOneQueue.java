package com.yj.stackAndQueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class TwostackOneQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwostackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public void add(int value) {
        stackPush.push(value);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


    public static void main(String[] args) {
        TwostackOneQueue twostackOneQueue = new TwostackOneQueue(new Stack<Integer>(), new Stack<Integer>());
        twostackOneQueue.add(1);
        twostackOneQueue.add(2);
        twostackOneQueue.add(3);

/*        System.out.println(twostackOneQueue.poll());//1
        System.out.println(twostackOneQueue.poll());//2
        System.out.println(twostackOneQueue.poll());//3
        System.out.println(twostackOneQueue.poll());//Queue is empty*/

        System.out.println(twostackOneQueue.peek());//1
        System.out.println(twostackOneQueue.peek());//1
        System.out.println(twostackOneQueue.peek());//1

    }
}
