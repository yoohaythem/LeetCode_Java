package com.LeetCode.Hot100._004_寻找两个正序数组的中位数_4;

//20221026
class MySolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int swap;
        int[] swaps;
        // 这一步保证n2最大值一定是大于n1的
        if (n2 == 0 || n1 != 0 && nums1[n1 - 1] > nums2[n2 - 1]) {
            swap = n1;
            n1 = n2;
            n2 = swap;
            swaps = nums1;
            nums1 = nums2;
            nums2 = swaps;
        }
        //  在两个数组之间循环遍历，逐渐找到中间值
        int i1 = 0, i2 = 0;
        while ((i1 + i2) < (n - 1) / 2) {
            if (i1 < n1 && nums1[i1] <= nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        if (n % 2 == 1) {
            middle = i1 == n1 ? nums2[i2] : Math.min(nums1[i1], nums2[i2]);
        } else {
            if (i1 == n1) {
                middle = (nums2[i2] + nums2[i2 + 1]) / 2.0;
            } else {
                if (nums1[i1] <= nums2[i2]) {
                    middle = (nums1[i1] + (i1 + 1 < n1 ? Math.min(nums1[i1 + 1], nums2[i2]) : nums2[i2])) / 2.0;
                } else {
                    middle = (nums2[i2] + Math.min(nums1[i1], nums2[i2 + 1])) / 2.0;
                }
            }
        }
        return middle;
    }
}
