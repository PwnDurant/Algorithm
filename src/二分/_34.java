package 二分;

public class _34 {
    public int missingNumber(int[] nums) {
        int ret=0;
        for(int x: nums) ret^=x;
        for(int i=0;i<=nums.length;i++) ret^=i;
        return ret;
    }
}
