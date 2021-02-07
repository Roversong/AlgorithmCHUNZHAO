// 思路一：排序法
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

// 思路二：哈希表
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            if (map.get(nums[i])>nums.length/2){
                return nums[i];
            }
        }
        return 0;
    }
}
