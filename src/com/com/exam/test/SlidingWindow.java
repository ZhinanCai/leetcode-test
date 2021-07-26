package com.com.exam.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //优先队列
        int n = nums.length;
        //创建优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        int[] res = new int[n - k + 1];
        //将前k个数放入
        for (int i = 0; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }
        res[0] = queue.peek()[0];
        //循环放入
        for (int i = k; i < n; i++) {
            queue.add(new int[]{nums[i], i});
            while(queue.peek()[1]<=i-k){
                queue.poll();
            }
            res[i - k + 1] = queue.peek()[0];
        }

        //当堆顶的数 的位置小于滑窗时  删除堆顶

        //将堆顶的数赋给结果数组
        return res;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

    }
}
