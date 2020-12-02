package com.llx278.leetcode.medium;

import java.util.*;

// A ascii -> 65
//
public class Solution91 {
    private String s;
    private final Map<String,Integer> map = new HashMap<>();
    private int count = 0;
    public Solution91() {
    }

    public int numDecodings(String s) {
        this.s = s;
        subNumDecodings(0);
        return count;
    }

    private void subNumDecodings(int p) {
        if (p >= s.length()) {
            count++;
            return;
        }

        String key = s.substring(p);
        if (map.containsKey(key)) {
            count+=map.get(key);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = p; i < s.length();i++) {
            char a = s.charAt(i);
            sb.append(a);
            int num = Integer.parseInt(sb.toString());
            if (num <= 26 && num >= 1) {
                subNumDecodings(i + 1);
                String subStr = s.substring(p);
                map.put(subStr,count);
            } else {
                break;
            }
        }
    }
}
