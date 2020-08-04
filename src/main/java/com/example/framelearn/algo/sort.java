package com.example.framelearn.algo;

/**
 * @author jt
 * @date 2020-8-2
 */
public class sort {


    public static void main(String[] args) {

        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8,2,1,0};
        bubbleSort1(array, array.length);
//        insertSort1(array, array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.print(
                    array[i]+","
            );
        }

    }

    private static void insertSort1(int[] a , int n ) {

        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i-1;
            for (; j >=0; j--) {
                if(a[j]<=value){
                    //找到了需要插入位置，跳出
                    break;
                }else {
                    //往后移一位
                    a[j+1]=a[j];
                }
            }
            //将要插入的值插入到对应的位置，
            a[j+1]=value;

        }

//        //从第二个元素开始
//        for (int i = 1; i < n; ++i) {
//            int value = a[i];
//            int j = i - 1;
//            // 查找要插入的位置并移动数据
//            //从0到上面选中的元素进行排序
//            for (; j >= 0; --j) {
//                if (a[j] > value) {
//                    //两个替换
//                    a[j + 1] = a[j];
//                } else {
//                    break;
//                }
//            }
//            a[j + 1] = value;
//        }

    }


    private static void bubbleSort1(int[] array, int length) {

        //i控制循环的次数
//        for (int i = 0; i < array.length-1; i++) {
//            //
//            for (int j = i; j < array.length-1; j++) {
//                if(array[i]<array[j+1]){
//                    int tmp = array[i];
//                    array[i]=array[j+1];
//                    array[j+1] =tmp;
//                }
//            }
//        }



                for (int i = 0; i < array.length-1; i++) {
            //
                    boolean flag =false;
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j]=array[j+1];
                    array[j+1] =tmp;
                    flag= true;
                }
            }
            if(!flag){
                break;
            }
        }
    }


    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            //剩下的挑个最小的
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }



}
