package com.llx278.leetcode.ita;

import java.util.ArrayList;
import java.util.List;

/**
 * 优先队列
 */
public class PriorityQueue<T extends Comparable<T>> {

    private List<T> list = new ArrayList<>();


    /**
     * 返回队列中具有最大关键字的元素
     */
    public T maximum() {
        return list.get(0);
    }

    /**
     * 去掉并返回队列中具有最大关键字的元素
     */
    public T extractMax() {
        if (list.size() < 1) {
            throw new RuntimeException("heap underflow");
        }
        T max = list.get(0);
        T last = list.get(list.size() - 1);
        list.add(0,last);
        list.remove(list.size() - 1);
        maxHeapify(list.size(),0);
        return max;
    }

    /**
     * 将元素x的关键字增加到k，这里假设i的值不小于key的原关键字值
     */
    public void increaseKey(T key, int i) {

        if (i > list.size() - 1) {
            throw new IndexOutOfBoundsException("i:"+i + " > list.size:"+list.size());
        }

        if (key.compareTo(list.get(i)) < 0) {
            throw new RuntimeException("new key is smaller than current key");
        }

        list.add(i,key);
        while (i >=0 && list.get(parent(i)).compareTo(list.get(i)) < 0) {
            T temp = list.get(i);
            list.add(i,list.get(parent(i)));
            list.add(parent(i),temp);
            i = parent(i);
        }
    }

    /**
     * 将key插入到数组里面去
     */
    public void insert(T key) {
        list.add(key);
        int index = list.size() - 1;
        increaseKey(key,index);
    }



    private int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    private int left(int i) {
        return (i + 1) * 2 - 1;
    }

    private int right(int i) {
        return ((i + 1) * 2 + 1) - 1;
    }

    private void maxHeapify(int len ,int i) {

        int l = left(i);
        int r = right(i);
        Integer largest;
        boolean lGraterThanR = list.get(l).compareTo(list.get(r)) > 0;
        if (l < len && lGraterThanR) {
            largest = l;
        } else {
            largest = i;
        }

        boolean rGraterThanLargest = list.get(r).compareTo(list.get(largest)) > 0;
        if (r < len && rGraterThanLargest) {
            largest = r;
        }

        if (largest != i) {
            T temp = list.get(largest);
            list.add(largest,temp);
            list.add(i,temp);
            maxHeapify(len,largest);
        }
    }

}
