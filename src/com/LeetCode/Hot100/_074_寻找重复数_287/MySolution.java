package com.LeetCode.Hot100._074_寻找重复数_287;

//20221116
class MySolution {
    public int findDuplicate(int[] nums) {
        // 构建一个 i --> nums[i] 规则的链表  :  0 --> nums[0]
        int fast = nums[nums[0]], slow = nums[0], head = 0;
        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        while(fast != head){
            fast = nums[fast];
            head = nums[head];
        }
        return head;
    }
}
