//前 K 个高频元素
/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

 */

//大顶堆解法

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap();
        //记录元素出现的频率
        for(int i=0;i<nums.length;i++){
            countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        //大顶堆存放k个高频元素
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        //将元素放到大顶堆中
        for(Map.Entry<Integer,Integer> entry: countMap.entrySet()){
            pq.add(entry);
        }
        //将大顶堆中的值遍历放到结果集中
        int aus[] = new int[k];
        int index =0;
        while(index<k){
            Map.Entry<Integer,Integer> entry = pq.poll();
            aus[index++]=entry.getKey();
        }
        return  aus;
    }
}