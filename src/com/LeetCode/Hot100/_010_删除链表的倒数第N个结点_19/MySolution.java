package com.LeetCode.Hot100._010_删除链表的倒数第N个结点_19;


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


//20221028
class MySolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = head, func = head;
        for (int i = 0; i < n; i++) {
            sentinel = sentinel.next;
        }
        if (sentinel == null){
            return head.next;
        }
        while (sentinel.next != null) {
            sentinel = sentinel.next;
            func = func.next;
        }
        func.next = func.next.next;
        return head;
    }
}
