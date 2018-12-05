package sort;
//快排的时间复杂度大部分情况下是O(nlogn)，空间复杂度O(1)

public class QuickSortTest {
    // 快速排序，A 是数组，n 表示数组的大小
    public static void quick_sort(int[] a,int n) {
        quick_sort_c(a, 0, n-1);
    }
    // 快速排序递归函数，p,r 为下标
    private static void quick_sort_c(int[] a,int p,int r) {
        if (p >= r){
            return ;
        }

        int q = partition(a, p, r); // 获取分区点
        quick_sort_c(a, p, q-1);
        quick_sort_c(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
            int pivot = a[r];
            int i = p;
            for (int j = p;j<=r-1;j++) {
                if (a[j] < pivot) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
            return i;
        }
    public static void main(String[] args) {
        int[] a = new int[]{2,1};
        quick_sort(a,a.length);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
