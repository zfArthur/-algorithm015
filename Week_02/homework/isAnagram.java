//有效的字母异位词
/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词, 判断依据是两个字符串里的字母出现次数是否一样

* */

//暴力解法一：排序，然后顺序比较排序的后的数组里的字母元素是否相等
//时间复杂度：O(nlogn)，假设 n 是 s 的长度，排序成本 O(nlogn) 和比较两个字符串的成本 O(n)。排序时间占主导地位，总体时间复杂度为O(nlogn)。

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}

