package com.leetcode.test;

import java.util.Arrays;

/**
 * 题目描述：循环轮转矩阵 没圈都逆时针转k次
 * leetcode周赛第二题
 */
public class Solution3 {
    private int[][] res;
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int level = Math.min(m,n)/2;
        res = new int[m][n];
        for (int i = 0; i < level; i++) {
            int row = m - 2*i;
            int col = n - 2*i;
            circle(grid, row, col, k, i);
        }
        return res;
    }

    public void circle(int[][] grid, int row, int col, int k, int level) {
        k = k % (2 * (row + col - 2));  //
        int[] line = new int[2*(row + col)-4];
        int b = 0;
        for (int i = level; i < level + col; i++) {
            line[b] = grid[level][i];
            b++;
        }
        for (int i = level+1; i < level + row; i++) {
            line[b] = grid[i][level + col-1];
            b++;
        }
        for (int i = level+col-2; i >= level; i--) {
            line[b] = grid[level+row-1][i];
            b++;
        }
        for (int i = level+row-2; i > level; i--) {
            line[b] = grid[i][level];
            b++;
        }
        int[] circleLine  = new int[2*(row + col)-4];
        for (int i = 0; i < 2*(row + col)-4; i++) {
            int w = i+k;
            if(w >= (2*(row + col)-4)){
                w = w-((2*(row + col)-4));
            }
            circleLine[i] = line[w];
        }
        b = 0;
        for (int i = level; i < level + col; i++) {
            res[level][i] = circleLine[b];
            b++;
        }
        for (int i = level+1; i < level + row; i++) {
            res[i][level + col-1] = circleLine[b];
            b++;
        }
        for (int i = level+col-2; i >= level; i--) {
            res[level+row-1][i] = circleLine[b];
            b++;
        }
        for (int i = level+row-2; i > level; i--) {
            res[i][level] = circleLine[b];
            b++;
        }

        }
//        int startRow;
//        int startCol;
//        if(k<=col-1){
//            startRow = level;
//            startCol = level+k;
//        }else if(k<=(row+col-2)){
//            startRow = level+(k-(col-1));
//            startCol = level+col;
//        }else if(k<=(row+2*col-3)){
//            startRow = level+row;
//            startCol = level+col-(k-(row+col-2));
//        }else{
//            startRow = level+(2*(row+col-2)-k);
//            startCol = level;
//        }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = 2;
        Solution3 solution3 = new Solution3();
        int[][] result = solution3.rotateGrid(grid, k);
        System.out.println(result);
    }
}
