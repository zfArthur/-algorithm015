/*
I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 */
//解法一: 大顶堆法
//时间复杂度 nlogn   堆每次删除和插入都是 logn的时间复杂度

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];
        //声明一个大顶堆
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(((a,b)->(b-a)));
        int n=nums.length;
        int result[] = new int[n-k+1];//第一个k分组内的最大值取一个所以要+1,之后的最多是n-k个最大值
        for (int i = 0; i < n; i++) {
            int start = i-k;
            //当第一个窗口满了之后，开始第一次滑动后则将之前窗口的第一个值去掉
            if (start>=0){
                MaxHeap.remove(nums[start]);
            }
            //向窗口中写值
            MaxHeap.offer(nums[i]);
            //当窗口满的时候，开始从中取出最大值放到结果集中
            if (MaxHeap.size()==k){
                result[i-k+1]=MaxHeap.peek();//从 index=0开始赋值
            }
        }
        return result;
    }
}
