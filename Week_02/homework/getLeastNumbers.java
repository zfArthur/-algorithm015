//题目
/*
最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
 

限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000

 */

//解法一  最小堆法
//时间复杂度  n(logn)
public int[] getLeastNumbers(int[] arr, int k) {
        //优先队列（默认是小根堆）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //将所有的值都放到优先队列中，优先队列会按照从小到大的方式自动维护顺序
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        //取出前k小的元素
        int ans[] = new int[k];
        for (int j = 0; j < k; j++) {
        ans[j] = priorityQueue.poll();
        }
        return ans;
}

//最大堆法
//时间复杂度：O(nlogk)，其中 n 是数组 arr 的长度。由于大根堆实时维护前 k 小值，所以插入删除都是 O(logk) 的时间复杂度，最坏情况下数组里 n 个数都会插入，所以一共需要 O(nlogk) 的时间复杂度。
//空间复杂度：O(k)，因为大根堆里最多 k 个数
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        //优先队列（默认是小根堆）,所以要自己实现大根堆的比较器
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //将k个元素到优先队列中，优先队列会按照从大到小的方式自动维护顺序
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(arr[i]);
        }
        //从第 k+1个数开始遍历，如果当前遍历到的数比大根堆的堆顶的数要小，就把堆顶的数弹出，再插入当前遍历到的数
        for (int j = k; j < arr.length; j++) {
            if (priorityQueue.peek()!=null && arr[j]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[j]);
            }
        }
        //最后将大根堆里的数存入数组返回即可
        int ans[] = new int[k];
        for (int j = 0; j < k; j++) {
            ans[j] = priorityQueue.poll();
        }
        return ans;
    }
}