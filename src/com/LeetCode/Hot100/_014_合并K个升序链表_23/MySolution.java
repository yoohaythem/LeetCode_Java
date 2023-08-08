package com.LeetCode.Hot100._014_合并K个升序链表_23;


import java.util.Arrays;

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


//20221029
class MySolution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int k = lists.length;
        int flag = 0;
        while (true) {
            flag = 0;
            int min = -1;
            // for循环寻找最小值
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    flag++;
                    continue;
                }
                if (min == -1 || lists[i].val < lists[min].val) {
                    min = i;
                }
            }
            if (flag == k){
                return head.next;
            }
            node.next = lists[min];
            node = node.next;
            lists[min] = lists[min].next;
        }
    }

    public static void main(String[] args) {
    }
}
