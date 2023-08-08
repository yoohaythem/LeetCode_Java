package com.LeetCode.Hot100._066_回文链表_234;


import java.util.Deque;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


//20221114
class MySolution {

    // 1. 利用栈
    public boolean isPalindrome_1(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        for (int i = 0; i < n / 2; i++) {
            stack.push(head);
            head = head.next;
        }
        if (n % 2 == 1) {
            head = head.next;
        }
        for (int i = 0; i < n / 2; i++) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 2. 反转链表
    public boolean isPalindrome_2(ListNode head) {
        int n = 0;
        ListNode temp = head, now = null, next = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        for (int i = 0; i < n / 2; i++) {
            temp = next.next;
            next.next = now;
            now = next;
            next = temp;
        }
        if (n % 2 == 1) {
            next = next.next;
        }
        for (int i = 0; i < n / 2; i++) {
            if (now.val != next.val) {
                return false;
            }
            now = now.next;
            next = next.next;
        }
        return true;
    }
}
