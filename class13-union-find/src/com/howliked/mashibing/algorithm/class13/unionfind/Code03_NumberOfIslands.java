package com.howliked.mashibing.algorithm.class13.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

// 本题为leetcode原题
// 测试链接：https://leetcode.com/problems/number-of-islands/
// 所有方法都可以直接通过

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class Code03_NumberOfIslands {

    public static void main(String[] args) {

    }

    /**
     * @param board '0' or '1'
     * @return
     */
    public int numIslands1(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    res++;
                    infect(board, i, j);
                }
            }
        }
        return res;
    }

    private void infect(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] != '1') {
            return;
        }
        board[i][j] = 0;
        infect(board, i + 1, j);
        infect(board, i - 1, j);
        infect(board, i, j + 1);
        infect(board, i, j - 1);
    }

}
