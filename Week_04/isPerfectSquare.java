/*
367. 有效的完全平方数
https://leetcode-cn.com/problems/valid-perfect-square/
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False
* */
//解法思路: 此题是在 69. x 的平方根 基础上增加了 当遇到符合 mid*mid==x 时直接return true
class Solution {
    public boolean isPerfectSquare(int num) {
        //临界条件判断
        if(num<2) return true;
        long left =1;
        long right = num;
        while(left<=right){
            long mid = left+(right-left)/2;
            long Square = mid*mid;
            //在 x 的平方根题目上加上个等于判断条件，等于即返回true
            if(Square==num) return true;
            if(Square>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }
}