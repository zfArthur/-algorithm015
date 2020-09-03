//1.暴力解法
//两次for循环,nums[i]+nums[j])==target 即是目标值，停止循环，并返回, j=i+1 是数组中同一个元素不能使用两遍
//时间复杂度O(n2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if((nums[i]+nums[j])==target){
                    nums1[0] = i;
                    nums1[1] = j;
                    return  nums1;
                }
            }
        }
        return nums1;
    }
}

//2.暴力解法简洁版
//时间复杂度O(n2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] ==target) {
                    return new int[] { i, j };
                }
            }
        }
        //没找到的最终返回
        throw new IllegalArgumentException("No two sum solution");
    }
}

//解法三(hashmap法):
///时间复杂度O(m+n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer> map = new HashMap<>();
    //1. 遍历 nums 将 nums[i] 的值作为 hashmap的key, i  作为value
    //在第一次迭代中，我们将每个元素的值和它的索引添加到表中
        for (int i = 0; i < nums.length; i++) {
        map.put(nums[i],i);
        }
        //2. 遍历 nums 检查 target-当前值 是否在map中，在的话说明该值和不包含当前值本身
        //然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]）是否存在于表中,注意，该目标元素不能是nums[i] 本身！
        for (int j = 0; j < nums.length; j++) {
        int complement = target - nums[j];
        if (map.containsKey(complement)&&map.get(complement)!=j){
        return new int[] {j,map.get(complement)};
        }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
