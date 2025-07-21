package 哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate/">题目链接</a>
 */
public class 存在重复元素I {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if(hash.contains(num)) return true;
            hash.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,3,1};
        System.out.println(containsDuplicate(ints));
    }

}
