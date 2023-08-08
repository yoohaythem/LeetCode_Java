package com.LeetCode.Hot100._052_LRU缓存_146;

import java.util.*;

//20221108
class MySolution {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}


class DLinkedList {
    int val;
    DLinkedList next;
    DLinkedList prev;

    DLinkedList(int x) {
        val = x;
        next = null;
        prev = null;
    }
}


class LRUCache {

    Map<Integer, DLinkedList> map;
    int capacity, count = 0;
    DLinkedList head = null;
    DLinkedList tail = null;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }


    public void moveToTail(DLinkedList node) {
        if (node == tail) {
            return;
        }
        if (node != head) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } else {
            head = node.next;
            node.next.prev = null;
        }
        node.prev = tail;
        tail.next = node;
        node.next = null;
        tail = node;
    }


    public int get(int key) {
        // 1. 从字典中取出元素
        if (map.containsKey(key) && map.get(key).val != -1) {
            DLinkedList node = map.get(key);
            // 2. 将元素放置到双向链表尾部
            moveToTail(node);
            // 3. 返回元素值
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        // 更新字典
        if (map.containsKey(key) && map.get(key).val != -1) {
            DLinkedList node = map.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            DLinkedList node = new DLinkedList(value);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            map.put(key, node);
            count++;
            while (count > capacity) {
                head.val = -1;
                head = head.next;
                head.prev = null;
                count--;
            }
        }
    }
}