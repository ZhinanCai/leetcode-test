package com.huawei.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述：华为提前批第一题  路线规划
 *
 * M个园区、已知N段距离
 * 输入：
 *      第一行：园区个数M，起始园区编号  已知距离个数N
 *      第二行到第N行  第一个数字为起始园区、第二个数字为目的园区、第三个数字为距离
 *      0<M<=15    0<N<=45
 *      如果可达、返回最短路径、如果不可达、则返回-1
 *
 */
public class SolutionHuaWei1 {

    public static int bfs(int[][] gragh, int m){
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //m:节点数    startNode:起始节点   n:边数
        int m = sc.nextInt();
        int startNode = sc.nextInt();
        int n = sc.nextInt();
        int[][] gragh = new int[m][m];
        //初始化图
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                gragh[i][j] =Integer.MAX_VALUE;
            }
        }
        //构建图
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int dist = sc.nextInt();
            gragh[start][end] = dist;
            gragh[end][start] = dist;
        }
        //dfs
        int res = bfs(gragh, m);
        System.out.println(res);
    }
}
