// 思路一 合并后排序
// 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
// 复杂度分析
// • 时间复杂度 : O((n + m)\log(n + m))。
// • 空间复杂度 : O(1)。

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

// 思路二 双指针/从前往后
// 复杂度分析
// • 时间复杂度 : O(n + m)。
// • 空间复杂度 : O(m)。

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // Make a copy of nums1.
      int [] nums1_copy = new int[m];
      System.arraycopy(nums1, 0, nums1_copy, 0, m);
  
      // Two get pointers for nums1_copy and nums2.
      int p1 = 0;
      int p2 = 0;
  
      // Set pointer for nums1
      int p = 0;
  
      // Compare elements from nums1_copy and nums2
      // and add the smallest one into nums1.
      while ((p1 < m) && (p2 < n))
        nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
  
      // if there are still elements to add
      if (p1 < m)
        System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
      if (p2 < n)
        System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
  }