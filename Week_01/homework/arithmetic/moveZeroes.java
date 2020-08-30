class Solution {

    //第一种解法:
    //思路: 数组保存有效的非零元素，变量记录零的个数
    //时间复杂度: O(n)
    public void moveZeroes(int[] nums) {
        //将非0的元素移动到数组首部存起来，并记录移动的次数j，则数组末尾补0数 = 数组长度-移动的次数j
        int len = nums.length;
        int j = 0;//移动的次数
        for(int i = 0;i<len;i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];//nums[j++] 代表着 给 nums[j]赋值，同时j++
            }
        }
        //数组末尾补0数 = 数组长度-移动的次数j
        for(int t=j;t<len;t++){
            nums[t]=0;
        }
    }
    //第二种解法:
    //时间复杂度: O(n)
    //五毒神掌
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];//将非0元素存到j的位置
                if (i != j) {
                    nums[i] = 0;//将i的位置初始化为0
                }
                j++;
            }
        }
    }



}