package com.llx278.leetcode.medium;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestWordSearch {

    private WordSearchNum79 wordSearch;

    @Before
    public void setup() {
        wordSearch = new WordSearchNum79();
    }




    @Test
    public void testCase0() {



        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };

        assertTrue(wordSearch.exist(board,"ABCCED"));
        assertTrue(wordSearch.exist(board,"SEE"));
        assertFalse(wordSearch.exist(board,"ABCB"));
        assertTrue(wordSearch.exist(board,"ABFS"));
    }

    @Test
    public void testCase1() {
        char[][] board0 = new char[][]{
                {'A','B','C','E'}
        };

        assertTrue(wordSearch.exist(board0,"ABCE"));
        assertFalse(wordSearch.exist(board0,"ABEDC"));

    }

    @Test
    public void testCase2() {
        char[][] board1 = new char[][]{
                {},

        };
        assertTrue(wordSearch.exist(board1,""));
        assertFalse(wordSearch.exist(board1,"abc"));
    }

    @Test
    public void testCase3() {
        char[][] board2 = new char[][]{
                {},
                {},
                {}
        };
        assertTrue(wordSearch.exist(board2,""));
        assertFalse(wordSearch.exist(board2,"abc"));
    }

    @Test
    public void testCase4() {
        char[][] board3 = new char[][] {
                {'A'},
                {'B'},
                {'C'}
        };
        assertTrue(wordSearch.exist(board3,"A"));
        assertTrue(wordSearch.exist(board3,"ABC"));
        assertTrue(wordSearch.exist(board3,""));
        assertTrue(wordSearch.exist(board3,""));
    }

    @Test
    public void testCase5() {
        char[][] board5 = new char[][] {
                {'a','a','a'},
                {'a','b','b'},
                {'a','b','b'},
                {'b','b','b'},
                {'b','b','b'},
                {'a','a','a'},
                {'b','b','b'},
                {'a','b','b'},
                {'a','a','b'},
                {'a','b','a'}
        };

        assertTrue(wordSearch.exist(board5,"aabbaaa"));
    }

    @Test
    public void testCase6() {
        char[][] board = new char[][] {
                {'a','b','c','d'},
                {'e','f','g','h'},
                {'i','j','k','l'}
        };
        assertFalse(wordSearch.exist(board,"abfea"));
    }
}
