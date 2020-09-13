
//回溯算法与深度优先遍历
//时间复杂度：O(N×N!)
//空间复杂度：O(N×N!)

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);
        //是否用到过的元素存储
        boolean[] used = new boolean[len];
        //路径全排列
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(0,len,nums,path,ans,used);
        return ans;
    }
    public void dfs(int level,int len, int[]nums,Deque<Integer> path,List<List<Integer>> ans,boolean[] used){
        //递归终止条件
        if(level == len){
            ans.add(new ArrayList<>(path));
            return;
        }
        //本层逻辑处理
        //循环向格子里写元素
        for(int i=0;i<len;i++){
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            used[i]=true;
            //调到下一层
            dfs(level+1,len,nums,path,ans,used);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            path.removeLast();
            used[i]=false;
            }
        }
    }
}