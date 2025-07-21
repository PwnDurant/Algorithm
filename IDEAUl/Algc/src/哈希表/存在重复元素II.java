package 哈希表;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/">题目链接</a>
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class 存在重复元素II {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // key : 值  value : 下标
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hash.containsKey(nums[i]) && Math.abs(hash.get(nums[i]) - i) <= k)
                return true;
            hash.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }

}
