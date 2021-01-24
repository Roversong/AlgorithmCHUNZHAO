// 思路一 双指针法
// 复杂度分析
// • 时间复杂度：O(n)O(n)，假设数组的长度是 nn，那么 ii 和 jj 分别最多遍历 nn 步。
// • 空间复杂度：O(1)O(1)。

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}