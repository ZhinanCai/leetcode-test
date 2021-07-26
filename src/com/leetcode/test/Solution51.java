package com.leetcode.test;

import java.util.*;

public class Solution51 {
    List<List<String>> res = new ArrayList<>();
    Set col = null;
    Set mainDiag = null;
    Set subDiag = null;
    int n;
    public List<List<String>> solveNQueens(int n) {
        col = new HashSet();
        mainDiag = new HashSet();
        subDiag = new HashSet();
        this.n = n;
        Deque<Integer> path = new LinkedList();
        dfs(0, path);

        return res;
    }
    public void dfs(int row, Deque<Integer> path){
        if(row==n){
            List<String> temp = convert2Map(path);
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !mainDiag.contains(row - i) && !subDiag.contains(row + i)) {
                col.add(i);
                mainDiag.add(row - i);
                subDiag.add(row + i);
                path.addLast(i);
                dfs(row+1, path);
                path.removeLast();
                subDiag.remove(row + i);
                mainDiag.remove(row - i);
                col.remove(i);
            }

        }
    }
    public List<String> convert2Map(Deque<Integer> path){
        List<String> map = new ArrayList<>();
        for (int col : path) {
            StringBuilder s = new StringBuilder();
            s.append(".");//n个。   用".".repeat(n)
            s.replace(col, col + 1, "Q");
            map.add(s.toString());
        }
        return map;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15);

    }
}
