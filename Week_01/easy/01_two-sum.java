// a, b --> a + b == target
// 思路一
// 暴力法。写两重循环，枚举不同的下标，最后看枚举的两个加在一起是否等于target

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        int numsSize = nums.length;
        
        for (int i = 0; i < numsSize; i++) {
            for (int j = i + 1; j < numsSize; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return new int[0];
    }
}