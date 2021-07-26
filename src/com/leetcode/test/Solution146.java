package com.leetcode.test;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    class DeLinkedNode{
        //prev next
        private int key;
        private int val;
        private DeLinkedNode next;
        private DeLinkedNode prev;
        public DeLinkedNode(){
        }
        public DeLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, DeLinkedNode> cache;
    private int capacity;
    private int size;
    private DeLinkedNode head;
    private DeLinkedNode tail;

    public void LRUcache(int capacity){
        cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new DeLinkedNode();
        tail = new DeLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DeLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    public void put(int key, int value){
        DeLinkedNode node = cache.get(key);
        if(node!=null){
            node.val = value;
            moveToHead(node);
        }else{
            putToHead(key, value);
        }
    }
//    public void moveToHead(DeLinkedNode node){
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//        head.next.prev = node;
//        head.next = node;
//        node.prev = head;
//        node.next = head.next;
//    }

    public void putToHead(int key, int value) {
        DeLinkedNode node = new DeLinkedNode(key, value);
        cache.put(key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
        if(size>capacity){
            cache.remove(removeTail().key);
            size--;
        }
    }
    public DeLinkedNode removeTail(){
        DeLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public void removeNode(DeLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToHead(DeLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    private void addToHead(DeLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
