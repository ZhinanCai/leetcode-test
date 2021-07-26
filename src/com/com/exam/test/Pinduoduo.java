package com.com.exam.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pinduoduo {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] nums = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            nums[i][0] = sc.nextInt();
//            nums[i][1] = sc.nextInt();
//        }
        int n = 4;
        int[][] nums = new int[][]{{4, 5}, {1, 3}, {7, 10}, {13, 18}};
        nums = new int[][]{{2,3}, {1, 9}, {4, 10}, {5, 20}};
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]-o1[0])-(o2[1]-o2[0]);
            }
        });
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i][0]>=nums[j][0]&&nums[i][1]<=nums[j][1]){
                    flag = true;
                    System.out.println(true);
                    break;
                }else{
                    continue;
                }
            }
        }
        if(!flag){
            System.out.println(false);
        }
//        System.out.println(n);
//        for (int[] num : nums) {
//            System.out.println(Arrays.toString(num));
//        }

    }
}
