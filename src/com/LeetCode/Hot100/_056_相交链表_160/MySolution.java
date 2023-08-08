package com.LeetCode.Hot100._056_相交链表_160;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


//20221109
class MySolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        if (nodeA == null) {
            while (nodeB != null) {
                nodeB = nodeB.next;
                headB = headB.next;
            }
        } else {
            while (nodeA != null) {
                nodeA = nodeA.next;
                headA = headA.next;
            }
        }
        while (headA != headB) {
            if (headA == null || headB == null) {
                return null;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
