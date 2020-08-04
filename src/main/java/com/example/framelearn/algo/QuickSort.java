package com.example.framelearn.algo;

/**
 * Created by wangzheng on 2018/10/16.
 */
public class QuickSort {

  // 快速排序，a是数组，n表示数组的大小
  public static void quickSort(int[] a, int n) {
    //调递归方法
    quickSortInternally(a, 0, n-1);
  }

  // 快速排序递归函数，p,r为下标
  private static void quickSortInternally(int[] a, int p, int r) {
    if (p >= r) return;

    int q = partition(a, p, r); // 获取分区点
    quickSortInternally(a, p, q-1);
    quickSortInternally(a, q+1, r);
  }

  private static int partition(int[] a, int p, int r) {
    int pivot = a[r];
    int i = p;
    for(int j = p; j < r; ++j) {
      if (a[j] < pivot) {
        if (i == j) {
          ++i;
        } else {
          int tmp = a[i];
          a[i++] = a[j];
          a[j] = tmp;
        }
      }
    }

    int tmp = a[i];
    a[i] = a[r];
    a[r] = tmp;

    System.out.println("i=" + i);
    return i;
  }

  public static void main(String[] args) {

    int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8,2,1,0};
    quickSort(array, array.length);
//        insertSort1(array, array.length);

    for (int i = 0; i < array.length; i++) {
      System.out.print(
              array[i]+","
      );
    }

  }



  private int bsearchInternally(int[] a, int low, int high, int value) {
    if (low > high) return -1;
    int mid = low + ((high - low) >> 1);
    if (a[mid] == value) {
      return mid;
    } else if (a[mid] < value) {
      return bsearchInternally(a, mid+1, high, value);
    } else {
      return bsearchInternally(a, low, mid-1, value);
    }
  }


  public int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    //<=
    while (low <= high) {
      //数据大的话可能会越界，用位运算会更快
      int mid = (low + high) / 2;
      if (a[mid] == value) {
        return mid;
      } else if (a[mid] < value) {
        //加一
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }

}
