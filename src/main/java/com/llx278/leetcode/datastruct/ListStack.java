package com.llx278.leetcode.datastruct;

import java.util.ArrayList;
import java.util.List;

public class ListStack implements Stack {

    private List<Integer> list = new ArrayList<>();

    @Override
    public void push(int num) {
        list.add(num);
    }

    @Override
    public void pop(int num) {
        list.remove(list.size() - 1);
    }

    @Override
    public int peek() {
        return list.get(list.size() - 1);
    }

    @Override
    public int size() {
        return list.size();
    }
}
