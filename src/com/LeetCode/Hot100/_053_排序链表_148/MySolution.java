package com.LeetCode.Hot100._053_排序链表_148;


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


//20221109
class MySolution {

    // 1. 冒泡排序 -- 超时
    public void changeNextTwoNode(ListNode flag) {
        ListNode next = flag.next;
        flag.next = flag.next.next;
        next.next = flag.next.next;
        flag.next.next = next;
    }

    public ListNode sortList_1(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode tail = null;
        while (sentinel.next != tail && sentinel.next.next != tail) {
            ListNode flag = sentinel;
            while (flag.next != tail && flag.next.next != tail) {
                if (flag.next.val > flag.next.next.val) {
                    changeNextTwoNode(flag);
                }
                flag = flag.next;
            }
            tail = flag.next;
        }
        return sentinel.next;
    }

    // 2. 二分法排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode half = slow.next;
        slow.next = null;
        return mergeTwoLists(sortList(head), sortList(half));
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                sentinel.next = list1;
                list1 = list1.next;
            } else {
                sentinel.next = list2;
                list2 = list2.next;
            }
            sentinel = sentinel.next;
        }
        sentinel.next = list1 == null ? list2 : list1;
        return head.next;
    }

}
