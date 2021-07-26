package com.leetcode.test;

import java.util.HashSet;
import java.util.Set;

public class Solution52s {
//    private int count;
//    private Set col;
//    private Set pie;
//    private Set na;
//    public int totalNQueens(int n) {
//        count = 0;
//        col = new HashSet();
//        pie = new HashSet();
//        na = new HashSet();
//        dfs(0, n);
//        return count;
//    }
//    public void dfs(int i, int n){
//        //terminator
//        if(i==n){
//            count++;
//            return;
//        }
//
//        //process  not in col | pie | na
//        for (int j = 0; j < n; j++) {
//            if(!(col.contains(j)||pie.contains(i+j)||na.contains(i-j))){
//                col.add(j);
//                pie.add(i + j);
//                na.add(i - j);
//                //drill down
//                dfs(i+1, n);
//                //restore
//                col.remove(j);
//                pie.remove(i + j);
//                na.remove(i - j);
//            }
//        }
//
//
//
//        //restore
//    }
    private int count;
    private int n;
    public int totalNQueens(int n) {
        count = 0;
        this.n = n;
        int row = 0;
        int col = 0;
        int pie = 0;
        int na = 0;
        dfs(row, col, pie, na);
        return count;
    }
    public void dfs(int row, int col, int pie, int na){
        //terminator
        if(row==n){
            count++;
            return;
        }
        int size = (1<<n)-1;  //让n位前都置为0
        int position = size & (~(col | pie | na));
        while(position!=0){
            //获取最低1位
            int p = position & (-position);
            //获取去掉最低1位的剩余位
            position = position & (position - 1);
            dfs(row+1, col|p, (pie|p)<<1, (na|p)>>>1);
        }
        //process  not in col | pie | na




        //restore
    }
    public static void main(String[] args) {

        Solution52s s = new Solution52s();
        System.out.println(s.totalNQueens(4));

    }
}
