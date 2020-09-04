/*题目: 各位相加
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
示例:
输入: 38
输出: 2
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

进阶:
你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

 */


//解法一  循环 取模 做除法
//考察了 java的 % 取模  / 除法    的用法
class Solution {
    public int addDigits(int num) {
        int sum =0;
        while(num>0){
            int m = num%10; //求模得到余数  123%10=3
            sum +=m;
            num=num/10;//除法 123/10=12
        }
        if(sum/10!=0){//当不是0-9的时候需要继续计算
            sum=addDigits(sum);
        }
        return sum;

    }
}

//解法二  模9法

class Solution {
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}