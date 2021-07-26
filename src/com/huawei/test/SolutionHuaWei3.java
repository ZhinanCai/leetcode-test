package com.huawei.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 题目描述：华为提前批第三题 逃出生天
 *  时间为0  触发机关   移动一格消耗一秒
 *  意味着该位置点的值必须大于移动数step  且起始点不能为0
 *  已解决
 */
public class SolutionHuaWei3 {


        public static int shortestPath(int[][] map){
            int m = map.length, n = map[0].length;
            boolean[][] visited = new boolean[m][n];
            //出口和入口判断： 不满足条件直接返回-1
            if(map[m-1][n-1]<(m+n-2)||map[0][0]==0){
                return -1;
            }
            Queue<int[]> q = new LinkedList<>();
            //把起始点放进队列
            q.offer(new int[]{0, 0});
            int step = 0;
            //四联通 方向
            int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            //设置flag表示是否达到终点
            boolean flag = false;
            while(!q.isEmpty()&&step<map[m-1][n-1]){
                step++;
                int size = q.size();
                while (size-- > 0) {
                    int[] cur = q.poll();
                    visited[cur[0]][cur[1]] = true;
                    //到达终点 flag设置为true 并退出循环
                    if (cur[0] == m - 1 && cur[1] == n - 1) {
                        flag=true;
                        break;
                    }
                    //循环四个方向
                    for(int[] d: dir){
                        int r = cur[0]+d[0];
                        int c = cur[1]+d[1];
                        if(r<0||c<0||r>=m||c>=n){
                            continue;
                        }
                        //如果满足该位置的值大于step  且  没有访问过（剪枝）  ——>放入队列
                        if(map[r][c]>step&&!visited[r][c]){
                            q.offer(new int[]{r,c});
                        }
                    }
                }
                if(flag==true){
                    break;
                }
            }
            return flag == true ? (step-1) : -1;
        }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        int col = sc.nextInt();
//        int[][] map = new int[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                map[i][j] = sc.nextInt();
//            }
//        }
//        int row = 3, col = 3;
        int[][] map2 = new int[][]{{1,2,3},{1,1,4},{1,6,5},{1,7,6},{1,8,9}};
//        map2 = new int[][]{{3,2,3},{5,1,4},{4,1,5}};
//        map2 = new int[][]{{3,5,4,2,3},{4,5,3,4,3},{4,3,5,3,2},{2,5,3,3,5},{5,3,4,4,3}};
        int res = shortestPath(map2);
        System.out.println(res);

    }


}
