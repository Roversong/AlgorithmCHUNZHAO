// 思路一 迭代
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> output = new ArrayList();
      output.add(new ArrayList<Integer>());
  
      for (int num : nums) {
        List<List<Integer>> newSubsets = new ArrayList<>();
        for (List<Integer> curr : output) {
          newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
        }
        for (List<Integer> curr : newSubsets) {
          output.add(curr);
        }
      }
      return output;
    }
}

// 思路二 回溯（递归)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}