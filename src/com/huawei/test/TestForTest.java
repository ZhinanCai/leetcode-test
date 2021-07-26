package com.huawei.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestForTest {
    public static int test(int n){
        if (n < 7) {
            return n;
        }else{
            return 6 + (int)Math.pow(2, (n - 6));
        }

    }
    public static void main(String[] args) {

        System.out.println(test(9));
        System.out.println(test(10));
        System.out.println(test(11));
        System.out.println(test(12));
        System.out.println(test(13));
        System.out.println(test(14));
        System.out.println(test(15));
    }
}
