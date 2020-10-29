//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 83 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //解法一: 先统计每个数的出现次数,然后遍历次数发现有重复的就返回false
    //O(n)
//    public boolean uniqueOccurrences(int[] arr) {
//        Map<Integer,Integer> myMap = new HashMap<>();
//        //统计每个数的出现次数
//        for (int i = 0; i < arr.length; i++) {
//            myMap.put(arr[i],myMap.getOrDefault(arr[i],0)+1);
//        }
//        Set<Integer> myset = new HashSet<>();
//        for (Integer value:myMap.values()) {
//            if (myset.contains(value)){
//                return false;
//            }else {
//                myset.add(value);
//            }
//        }
//        return true;
//    }
    //解法二: 先统计每个数的出现次数,然后将遍历次数统一放到set中,如果没有重复则map.size()==set.size(),返回true否则返回false
    //O(n)
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
