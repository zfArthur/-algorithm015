class Solution {

    /*解题思路：
    学会用提供的不同输入值，推导出对应的公式，即找最近重复子问题, 用程序实现即可,
            1 : 1
            2: 2
            3: f(2)+f(1)
            4: f(2)+f(3)
            N: f(n-1)+f(n-2)
    用斐波那契数列公式(F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1))算出对应的n的值并按照对应的顺序存储起来，然后在根据不同的n返回对应的值
    解法一:
    将所有的F[n-1]+F[n-2] 的值都计算出来并存储起来，然后根据输入的n返回对应的值
    算法复杂度: O(n)
     */
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];//其实存n个数据开n个空间就够用了，但是因为 dp[0]不存数据，而是从dp[1] 开始，所有才需要n+1个空间
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

   // 解法二:
    //由于我只需要最后的值，所以就没必要开辟新的数组存值，只需要几个中间变量存储即可
    //算法复杂度: O(n)
    public int climbStairs(int n) {
        if (n<=2) return n;
        int f1,f2,f3 = 1,2,3;
        for (int i = 3; i <=n; i++) {
            f3 = f2 + f1;//计算fn
            f1 = f2;//存储 f(n-1)
            f2 = f3;//存储 f(n-2)
        }
        return f3;// 返回fn
    }

}