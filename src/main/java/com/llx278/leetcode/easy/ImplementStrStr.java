package com.llx278.leetcode.easy;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }

        if (needle.equals("")) {
            return 0;
        }

        if (haystack.equals("") && needle.length() > 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();

        int index = -1;

        int hsIndex = 0;
        int nsIndex = 0;
        char n = ns[nsIndex];

        while (hsIndex < hs.length) {
            char h = hs[hsIndex];
            if (n == h) {
                index = hsIndex;
                int t = hsIndex;
                while (nsIndex < ns.length && t < hs.length) {
                    if (ns[nsIndex] != hs[t]) {
                        break;
                    }
                    nsIndex++;
                    t++;
                }
                if (nsIndex == ns.length) {
                    return index;
                }
                nsIndex = 0;
            }
            hsIndex++;
            index = -1;
        }
        return index;
    }


    public static void main(String[] args) {
        ImplementStrStr strStr = new ImplementStrStr();
        int index = strStr.strStr("mississippi","issipi");
        System.out.println(index);
    }

}
