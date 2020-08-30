class Solution {
    /*
    解法一
    暴力解法，2层for循环, 时间复杂度 O(n2)
    解题思路: 看懂题意很重要,输入的是立柱高的数组，则容器的高 h 为 2个立柱中的最小值, 数组的下标代表着x坐标,则容器的宽 w 为两个x坐标的差,则整体面积为 maxArea = h*w;
    注意: 要学会应用数学公式 Math
     */
    public int maxArea(int[] height) {
        int len = height.length;
        int maxAreas = 0;
        for(int i=0;i<len;i++){
            for(int j =1;j<len;j++){
                //高
                int h = Math.min(height[i],height[j]);
                //宽
                int w = j-i;
                //面积
                int tempArea = h*w;
                maxAreas = Math.max(tempArea,maxAreas);
            }
        }
        return maxAreas;
    }

    //解法二
    //双指针 两边夹逼法
    //时间复杂度 O(n)
    public int maxArea(int[] height) {
        //双指针 两边夹逼法
        int len = height.length;
        int maxArea=0;
        for(int i=0,j=len-1;i<j;){
            //求两个指针中的最小值,即为高,谁小移动谁
            int h = height[i]<height[j]?height[i++]:height[j--];
            //宽
            int w = j-i+1;// +1  是因为 i和j移动了1，宽度减少了需要给加回去
            maxArea = Math.max(maxArea,(h*w));
        }
        return maxArea;
    }

}