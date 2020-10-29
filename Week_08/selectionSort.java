package com.example.demo.sf.sort;

/**
 * @Author zhangfu
 * @Date 2020-10-26 19:14
 */
//选择排序
//时间复杂的O(n^2)
public class selectionSort {
    public static void main(String[] args){
        int[] aa = {2,4,1,0,3,18,9};
        int len = aa.length;
        //选择轮数
        for (int i = 0; i < len-1; i++) {
            // 每轮比较次数
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (aa[j]<aa[minIndex]){//选出最小的元素
                    minIndex=j;//保存它的索引
                }
            }
            //选出每轮的最小值，将它和头元素进行交互
            int temp = aa[minIndex];
            aa[minIndex] = aa[i];
            aa[i] = temp;
        }
        //输出
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }
}
