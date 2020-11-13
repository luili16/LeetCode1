package com.llx278.leetcode.datastruct;

public interface Stack {

    // 入栈
    void push(int num);

    // 出栈
    void pop(int num);

    // 查看栈顶元素
    int peek();

    // 栈的长度
    int size();
}
