//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: "Hello"
//输出: "hello" 
//
// 示例 2： 
//
// 
//输入: "here"
//输出: "here" 
//
// 示例 3： 
//
// 
//输入: "LOVELY"
//输出: "lovely"
// 
// Related Topics 字符串 
// 👍 136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //ASCII: A 65  Z 90  a: 97 z:122
    // A+32 = a
    public String toLowerCase(String str) {
        char[] st = new char[str.length()];
        for (int i = 0; i <str.length() ; i++) {
            char c = str.charAt(i);
            //
            if (c>=65&&c<=90){
                c = (char)(c+32);
            }
            st[i]=c;
        }
        return new String(st);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
