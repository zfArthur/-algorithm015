//求两个数组的交集
//解法一:单hashmap
//时间复杂度O(m+n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //将短的数组交换到前面
        if (nums1.length>nums2.length){
            intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        //遍历短数组用map存储元素在数组中出现的次数
        for (int num: nums2) {
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int ans[] = new int[nums1.length];
        int index=0;
        //遍历nums2将在hashmap1中存在的元素放到结果集中并把出现的次数减一,
        // 并把剩余次数存储起来，如果减到0了则不再减下去，直接将这个元素在hashmap1中删除即可
        for (int numtemp: nums1) {
            int count1 = map.getOrDefault(numtemp,0);
            if (count1>0){
                ans[index++] = numtemp;
                count1--;
                if (count1>0){
                    map.put(numtemp,count1);
                }else {
                    map.remove(numtemp);
                }
            }
        }
        // 遍历完成返回重复元素长度的结果数组。
        return Arrays.copyOfRange(ans, 0, index);
    }
}