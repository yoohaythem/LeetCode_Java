package com.LeetCode.Hot100._002_两数相加_2;


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


//20221024
class MySolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int flag = 0;
        int sum;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + flag;
                flag = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                sum = l2.val + flag;
                flag = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l2 = l2.next;
            } else {
                sum = l1.val + flag;
                flag = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l1 = l1.next;
            }
        }
        if (flag == 1) {
            tail.next = new ListNode(1);
        }
        return head.next;
    }
}
