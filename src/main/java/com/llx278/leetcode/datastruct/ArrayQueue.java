package com.llx278.leetcode.datastruct;

// 队尾插入 队头消费
public class ArrayQueue implements Queue<Integer> {

    private int[] list;
    private int head = 0;
    private int tail = 0;
    private int len;
    public ArrayQueue(int n) {
        this.len = n;
        // 多出来的位置用来判断队列是不是已经满了
        list = new int[n + 1];
    }

    // 入队
    @Override
    public void enqueue(Integer num) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        list[tail] = num;
        if (tail == len - 1) {
            tail = 0;
        } else {
            tail++;
        }
    }

    private boolean isEmpty() {
        return tail == head;
    }

    private boolean isFull() {
        return tail + 1 == head;
    }

    // 出队
    @Override
    public Integer dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        int x = list[head];
        if (head == len - 1) {
            head = 0;
        } else {
            head++;
        }
        return x;
    }
}
