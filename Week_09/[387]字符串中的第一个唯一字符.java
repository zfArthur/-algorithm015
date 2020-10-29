//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 281 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
    if (s==null||s.length()==0) return -1;
    //hashmap记录每个字符出现的次数
        Map<Character,Integer> mymap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mymap.put(s.charAt(i),mymap.getOrDefault(s.charAt(i),0)+1);
        }
        //找到第一个次数为1的字符返回对应的索引
        for (int i = 0; i < s.length(); i++) {
            if(mymap.get(s.charAt(i)).equals(1)) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
