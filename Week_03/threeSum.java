/*
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

* */


class Solution {

    //解法一: 三层循环暴力法(超时了)
    //时间复杂度 n3
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null||nums.length<=2){
            return Collections.emptyList();
        }
        int len = nums.length;
        //三层循环暴力法
        //数组先行排序,时间复杂度 nlogn,相对于整体n3的时间复杂度可以接受
        Arrays.sort(nums);
        //用set来防止重复的结果集，用LinkedHashSet比较妙
        Set<List<Integer>> ans = new LinkedHashSet<>();
        //循环找对应的值
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        //Arrays.asList写法简洁
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                        ans.add(temp);
                    }
                }
            }
        }
        //将set转化为ArrayList
        return new ArrayList<>(ans);
    }


    //解法二: 双指针法
    //时间复杂度O(n2)
    /*复杂度分析：
        时间复杂度 O(N^2)
        2)：其中固定指针k循环复杂度 O(N)，双指针 i，j 复杂度 O(N)。
        空间复杂度 O(1)：指针使用常数大小的额外空间。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //数组排序 nO(logn)
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int k = 0; k < len-2; k++) {
            //因为数组排序了，nums[j] >= nums[i] >= nums[k] > 0,即 3 个数字都大于 0 ，在此固定指针 k 之后不可能再找到结果了
            if (nums[k]>0) break;
            //当 k > 0且nums[k] == nums[k - 1]时即跳过此元素nums[k]：因为已经将 nums[k - 1] 的所有组合加入到结果中，本次双指针搜索只会得到重复组合
            if (k>0 && nums[k]==nums[k - 1]) continue;
            int i=k+1;
            int j= len-1;
            while (i<j){
                //三数相加
                int sum = nums[k]+nums[i]+nums[j];
                //int[] nums = {-4,-1,-1,-1,0,1,2};
                if (sum<0){
                    //证明i的值比较小，需要向右移动i，并跳过所有重复的nums[i]
                    while (i<j && nums[i] ==nums[++i]);
                }else if(sum>0){
                    //证明j的值比较大，需要向左移动j,并跳过所有重复的nums[j]
                    while (i<j && nums[j] ==nums[--j]);
                }else {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //向右移动i
                    while (i<j && nums[i] ==nums[++i]);
                    //向左移动i
                    while (i<j && nums[j] ==nums[--j]);
                }
            }
        }
        return ans;
    }
}

//解法三: 哈希表

    private List<List<Integer>> hashSolution(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }
        Set<List<Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Map<Integer, Integer> hashMap = new HashMap<>(nums.length - i);
            for (int j = i + 1; j < nums.length; j++) {
                int v = target - nums[j];
                Integer exist = hashMap.get(v);
                if (exist != null) {
                    List<Integer> list = Arrays.asList(nums[i], exist, nums[j]);
                    list.sort(Comparator.naturalOrder());
                    result.add(list);
                } else {
                    hashMap.put(nums[j], nums[j]);
                }
            }
        }

        return new ArrayList<>(result);
    }

