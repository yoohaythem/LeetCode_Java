package com.LeetCode.Hot100._060_反转链表_206;


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


//20221110
class MySolution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = prev;
            prev = next;
            next = temp;
        }
        return prev;
    }
}
