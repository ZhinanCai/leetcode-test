package com.leetcode.test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 各种排序算法：快排、归并、堆排序
 */
public class Solution912 {
    //快排
    public void quickSort(int[] nums, int begin, int end){
        if(end<=begin){
            return;
        }
        int pivot = findPivot(nums, begin, end);
        quickSort(nums, begin, pivot-1);
        quickSort(nums, pivot+1, end);
    }
    public int findPivot(int[] nums, int begin, int end){
        int pivot = end, counter = begin;
        for(int i = begin; i<=end; i++){
            if(nums[i]<nums[pivot]){
                int tmp = nums[i]; nums[i] = nums[counter]; nums[counter] = tmp;
                counter++;
            }
        }
        int tmp = nums[counter]; nums[counter] = nums[pivot]; nums[pivot] = tmp;
        return counter;
    }
    //归并
    public void mergeSort(int[] nums, int begin, int end){
        if(end<=begin){
            return;
        }
        int mid = (begin + end)>>>1;
        mergeSort(nums, begin, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, begin, mid, end);
    }
    public void merge(int[] nums, int begin, int mid, int end) {
        int i = begin, j = mid+1;
        int[] tmp = new int[end - begin + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        for (int p = 0; p < end - begin + 1; p++) {
            nums[begin + p] = tmp[p];
        }
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            arr[i] = nums[i - 1];
        }
        //建堆
        for (int i = len / 2; i > 0; i--) {
            sink(arr, i, len);
        }
        //排序
        int k = len;
        while (k > 1) {
            swap(arr, 1, k--);
            sink(arr, 1, k);
        }
        //恢复
        for (int i = 0; i < len; i++) {
            nums[i] = arr[i + 1];
        }
    }

    public void sink(int[] arr, int idx, int end) {
        while (2 * idx <= end) {
            int childIdx = 2 * idx;
            //找出左右子节点最大(最大堆)  /  最小（最小堆）的节点
            if(childIdx+1<=end && arr[childIdx+1]>arr[childIdx]){
                childIdx++;
            }
            //如果子节点大的话 交换
            if (arr[childIdx] > arr[idx]) {
                swap(arr, childIdx, idx);
            } else {
                break;
            }
            idx = childIdx;
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        Solution912 s = new Solution912();
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
//        s.mergeSort(nums, 0, nums.length-1);
        s.heapSort(nums);
        System.out.println(Arrays.toString(nums));
//        PriorityQueue priorityQueue = new PriorityQueue();
    }
}
