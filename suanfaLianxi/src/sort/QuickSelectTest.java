package sort;
//快速找出第k大的数据，时间复杂度O(n)
public class QuickSelectTest {
    // 快速排序，A 是数组，n 表示数组的大小
    public static int quick_sort(int[] a,int n,int k) {
        return quick_sort_c(a, 0, n-1,k);
    }
    // 快速排序递归函数，p,r 为下标
    private static int quick_sort_c(int[] a,int p,int r,int k) {
        int q = partition(a, p, r); // 获取分区点
        if (q+1>k){
            return quick_sort_c(a, p, q-1,k);
        }else if (q+1<k){
            return quick_sort_c(a, q+1, r,k);
        }else {
            return a[q];
        }
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
        int[] a = new int[]{26,77,46,23,123,33,878,132,112,45};
        for (int i =1;i<11;i++){
            System.out.println(quick_sort(a,a.length,i));
        }
    }
}
