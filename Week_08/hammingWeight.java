public class Solution {
    //时间复杂度：O(1) 。运行时间依赖于数字 n 的位数。由于这题中 n 是一个 32 位数，所以运行时间是 O(1) 的。
    //空间复杂度：O(1)。没有使用额外空间。
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;//初始化一个掩码，用于和n进行与运算，并将mask不断左移,找出所有的1,当与之后的结果值不等于0的时候说明找到了1
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
    public int hammingWeight(int n) {
        int count=0;
        while(n != 0)
        {
            count ++;
            n = n & (n - 1);//消除n最低位的1清零
        }
        return count;
    }
}