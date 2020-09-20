/*
169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

* */

//解法一: 哈希表法
//算法复杂度: O(n)
class Solution {
    public int majorityElement(int[] nums) {
        //哈希表法  将多数元素的标准 n/2 求出,循环记录元素出现的次数，当出现的次数大于n/2的时候将元素返回
        Map<Integer,Integer> count = new HashMap();
        for(int num:nums){
            if(count.getOrDefault(num,0)+1>Double.valueOf(nums.length)/2){
                return num;
            }else{
                count.put(num,count.getOrDefault(num,0)+1);
            }
        }
        throw new IllegalArgumentException("No majorityElement solution");
    }
}
