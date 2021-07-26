package com.leetcode.test;

import java.util.*;

public class Solution52 {
    private int res;
    private int size;
    private int n;
    public int totalNQueens(int n) {
//        int col = 0;
//        int pie = 0;
//        int na = 0;
        res = 0;
        size = (1 << n) - 1;
        this.n = n;
        dfs(1,0,0, 0);
        return res;

    }
    public void dfs(int row, int col, int pie, int na){
        //terminator
        if(col==size){
            res++;
            return;
        }
        //process
        int pos = size & (~(col | pie | na));
        while (pos != 0) {
            //取出最低位的1
            int p = pos & (-pos);
            //该位放上皇后
            pos &= pos-1;
            //drill down
            dfs(row+1,col|p,(pie|p)<<1,(na|p)>>>1);
        }
    }

    public static void main(String[] args) {
        Solution52 s = new Solution52();
        System.out.println(s.totalNQueens(4));

    }
}
