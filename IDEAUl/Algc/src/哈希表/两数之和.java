package 哈希表;


import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/">题目链接</a>
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if(hashMap.containsKey(val))
                return new int[]{hashMap.get(val),i};
            else hashMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

}
