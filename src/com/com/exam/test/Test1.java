package com.com.exam.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("ceshi");
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] a = new int[]{1, 2, 3, 4, 5};
        List b =  Arrays.asList(a);
        List<Integer> list1 = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(b);
        Stack stack = new Stack();


    }
}
