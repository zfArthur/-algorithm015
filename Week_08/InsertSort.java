public class InsertSort {

    //思路：排序数组 arr[0..i..n]
    // 分为 待排序的序列[i,n]和已排序的序列[0,i-1], 默认取数组中的第一个元素放到已排序的序列中
    //然后开始从待排序的序列中按照从头到尾(从尾到头也行)取出一个元素 i 和已排序的序列的最后一个元素i-1开始比较,
    //如果arr[i]>arr[i-1],则在已排序的序列最后一位的在加一位放arr[i]
    //如果arr[i]<arr[i-1],则再和已排序的序列的倒数第2位比较,一直到卡在已排序序列中的某两个元素之间时将i写入已排序序列中
    //依次执行这个过程直到将所有的待排序的序列中的元素都排序完了
    public static void main(String[] args){
        int[] arr = {8,2,5,3,7};
        int n = arr.length;
        // 待排序的序列
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            //已排列好的序列
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据,此处+1 是因为上面的j--了，正常是要放到arr[j]位置上的
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}