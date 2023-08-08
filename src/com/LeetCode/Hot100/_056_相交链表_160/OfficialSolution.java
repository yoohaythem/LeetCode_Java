package com.LeetCode.Hot100._056_相交链表_160;


import java.util.*;

class OfficialSolution {
    // 1. 哈希集合
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 2. 双指针，这个解法十分巧妙！省去了很多的 if 和 while
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}

