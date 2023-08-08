package com.LeetCode.Hot100._063_数组中的第K个最大元素_215;

import java.util.*;

//20221114
class MySolution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // 1. 快速排序算法
    public int mySort(int[] nums, int start, int end, int k) {

        Random r = new Random();
        int position = r.nextInt(end - start + 1) + start;
        swap(nums, start, position);

        int left = start, right = end, flag = nums[start];
        while (left < right) {
            while (nums[right] < flag) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= flag) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = flag;


        if (k - 1 < left) {
            return mySort(nums, start, left - 1, k);
        } else if (k - 1 == left) {
            return nums[k - 1];
        } else {
            return mySort(nums, left + 1, end, k);
        }
    }


    public int findKthLargest_1(int[] nums, int k) {
        return mySort(nums, 0, nums.length - 1, k);
    }


    // 2. 利用 PriorityQueue 优先队列 实现堆排序 -- 小顶堆
    public int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }


    // 3. 利用数组 实现堆排序 -- 大顶堆

    // 该函数实现将 position 变为其下某一个分支的最大值的功能
    public void maxHeapify(int[] nums, int position, int size) {
        int left = 2 * position + 1, right = 2 * position + 2, max = position;
        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }
        if (position != max) {
            swap(nums, position, max);
            maxHeapify(nums, max, size);
        }
    }

    public int findKthLargest_3(int[] nums, int k) {
        int size = nums.length;
        for (int i = size / 2; i >= 0; i--) {   // 建造一个大顶堆
            maxHeapify(nums, i, size);
        }
        // 将堆顶元素调整到队列尾部
        for (int i = 0; i < k - 1; i++) {
            swap(nums, 0, size - 1);
            size--;
            maxHeapify(nums, 0, size);  // 构造大顶堆，这次只需要对一个分支进行操作即可，复杂度 log(n)
        }
        return nums[0];
    }

}
