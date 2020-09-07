//top k问题
//解法一:  大顶堆法
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //将元素出现的次数记录下来
        Map<Integer,Integer> countMaps = new HashMap<>();
        for (int num: nums) {
            countMaps.put(num,countMaps.getOrDefault(num,0)+1);
        }
        //声明一个大顶堆(默认是小顶堆)
        PriorityQueue<Map.Entry<Integer,Integer>> heapMaps = new PriorityQueue<>(((a,b)->(b.getValue()-a.getValue())));
        //遍历countMap将遍历的值写入大顶堆中
        for (Map.Entry<Integer,Integer> countMap : countMaps.entrySet()){
            heapMaps.offer(countMap);
        }
        //将大顶堆中的前k个高频元素放到答案list中
        int aus[] = new int[k];
        int index =0;
        while(index<k){
            Map.Entry<Integer,Integer> entry = heapMaps.poll();
            aus[index++]=entry.getKey();
        }
        return  aus;
    }
}