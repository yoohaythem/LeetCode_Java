package com.LeetCode.Hot100._060_反转链表_206;


class OfficialSolution {

    // 1. 迭代
    public ListNode reverseList_1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    // 2. 递归 -- 个人觉得这里不如 用个栈来实现直观
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}

