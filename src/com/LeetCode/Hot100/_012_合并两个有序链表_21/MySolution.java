package com.LeetCode.Hot100._012_合并两个有序链表_21;

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
