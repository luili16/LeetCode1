package com.llx278.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;

public class Solution79 {
    public boolean exist(char[][] board, String word) {

        if (word.length() == 0) {
            return true;
        }

        if (board.length == 0) {
            return false;
        }
        HashSet<Key> set = new HashSet<>();
        int xMax = board[0].length;
        int yMax = board.length;
        Deque<Character> s0 = new ArrayDeque<>();
        for (int i = word.length() - 1; i >= 0; i--) {
            s0.push(word.charAt(i));
        }

        Deque<Holder> s1 = new ArrayDeque<>();
        Character s0Top = s0.pop();
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                if (s0Top.equals(board[y][x])) {
                    Holder h = new Holder();
                    h.x = x;
                    h.y = y;
                    h.c = board[y][x];
                    s1.push(h);
                    Key key = new Key(x,y);
                    set.add(key);
                    if (search(board,s0,s1,xMax,yMax,set)) {
                        return true;
                    } else {
                        s1.pop();
                        set.remove(key);
                    }
                }
            }
        }
        return false;
    }



    private boolean search(char[][] board,Deque<Character> s0,Deque<Holder> s1,int xMax,int yMax,HashSet<Key> set) {
        // s0 无论如何都是非空的
        // s1 无论如何都是非空的
        // 路径不能回溯
        // 先找到第一次
        if (s0.isEmpty()) {
            return true;
        }

        Character candidate = s0.pop();
        Holder top = s1.peek();
        // 四个方向遍历查找
        // left
        boolean leftFound = false;
        if (top.x > 0) {
            int x = top.x - 1;
            int y = top.y;

            if (!set.contains(new Key(x,y))){
                // 此条路径可以访问
                Character m = board[y][x];
                if (m.equals(candidate)) {
                    // 继续访问下一条路径
                    Holder h = new Holder();
                    h.c = m;
                    h.x = x;
                    h.y = y;
                    s1.push(h);
                    Key key = new Key(x,y);
                    set.add(key);
                    leftFound = search(board,s0,s1,xMax,yMax,set);
                    s1.pop();
                    set.remove(key);
                } else {
                    leftFound = false;
                }

            }
        }


        if (leftFound) {
            return true;
        }

        // top
        boolean topFound = false;
        if (top.y > 0) {
            int x = top.x;
            int y = top.y - 1;
            if (!set.contains(new Key(x,y))) {
                // 此条路径可以访问
                Character m = board[y][x];
                if (m.equals(candidate)) {
                    // 继续访问下一条路径
                    Holder h = new Holder();
                    h.c = m;
                    h.x = x;
                    h.y = y;
                    s1.push(h);
                    Key key = new Key(x,y);
                    set.add(key);
                    topFound = search(board,s0,s1,xMax,yMax,set);
                    s1.pop();
                    set.remove(key);
                } else {
                    topFound = false;
                }

            }
        }


        if (topFound) {
            return true;
        }

        // right
        boolean rightFound = false;
        if (top.x < xMax - 1) {
            int x = top.x + 1;
            int y = top.y;
            if (!set.contains(new Key(x,y))) {
                Character m = board[y][x];
                if (m.equals(candidate)) {
                    // 继续访问下一条路径
                    Holder h = new Holder();
                    h.c = m;
                    h.x = x;
                    h.y = y;
                    s1.push(h);
                    Key key = new Key(x,y);
                    set.add(key);
                    rightFound = search(board,s0,s1,xMax,yMax,set);
                    s1.pop();
                    set.remove(key);
                } else {
                    rightFound = false;
                }
            }
        }


        if (rightFound) {
            return true;
        }

        // bottom
        boolean bottomFound = false;
        if (top.y < yMax - 1) {
            int x = top.x;
            int y = top.y + 1;
            if (!set.contains(new Key(x,y))
            ) {
                // 此条路径可以访问
                Character m = board[y][x];
                if (m.equals(candidate)) {
                    // 继续访问下一条路径
                    Holder h = new Holder();
                    h.c = m;
                    h.x = x;
                    h.y = y;
                    s1.push(h);
                    Key key = new Key(x,y);
                    set.add(key);
                    bottomFound = search(board,s0,s1,xMax,yMax,set);
                    s1.pop();
                    set.remove(key);
                } else {
                    bottomFound = false;
                }
            }
        }

        if (bottomFound) {
            return true;
        }

        s0.push(candidate);
        return false;
    }


    class Holder {
        int x;
        int y;
        Character c;
    }

    class Key {
        int x;
        int y;

        Key(int x,int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return x == key.x &&
                    y == key.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
