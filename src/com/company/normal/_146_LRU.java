package com.company.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例：
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
  lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 */

public class _146_LRU {
    static class DListNode {
        int key;
        int value;
        DListNode before;
        DListNode after;
        public DListNode(){}
        public DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, DListNode> map = new HashMap<>();
    int size;
    int capacity;
    DListNode head, tail;
    public _146_LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.after = tail;
        tail.before = head;
    }
    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node == null){
            DListNode newNode = new DListNode(key,value);
            map.put(key,newNode);
            ++size;
            addToHead(newNode);
            if (size > capacity){
                map.remove(removeTail().key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void moveToHead(DListNode node){
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(DListNode node){
        node.before.after = node.after;
        node.after.before = node.before;
    }
    private void addToHead(DListNode node){
        node.before = head;
        node.after = head.after;
        head.after.before = node;
        head.after = node;
    }
    private DListNode removeTail(){
        DListNode res = tail.before;
        removeNode(res);
        return res;
    }
}
