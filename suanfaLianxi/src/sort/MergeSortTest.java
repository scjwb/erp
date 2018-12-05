package sort;
//归并排序算法，时间复杂度任何情况下都是O(nlogn)，空间复杂度O(n)
public class MergeSortTest {
    // 归并排序算法, A 是数组，n 表示数组大小
    public static void merge_sort(int[] a, int n) {
        merge_sort_c(a, 0, n-1);
    }

    // 递归调用函数
    public static void merge_sort_c(int[] a,int p,int r) {
        // 递归终止条件
        if (p >= r){
            return;
        }

        // 取 p 到 r 之间的中间位置 q
        int q = (p+r) / 2;
        // 分治递归
        merge_sort_c(a, p, q);
        merge_sort_c(a, q+1, r);
        // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
        merge(a,p,q,r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        // 初始化变量 i, j, k
        int i = p;int j = q+1;int k = 0;
        // 申请一个大小跟 A[p...r] 一样的临时数组
        int[] tmp = new int[r-p+1];
            while (i<=q && j<=r) {
                if (a[i] <= a[j]) {
                    tmp[k++] = a[i++]; // i++ 等于 i:=i+1
                } else {
                    tmp[k++] = a[j++];
                }
            }

            // 判断哪个子数组中有剩余的数据
            int start = i;int end = q;
            if (j<=r){
                start = j;
                end = r;
            }

            // 将剩余的数据拷贝到临时数组 tmp
            while (start <= end) {
                tmp[k++] = a[start++];
            }

            // 将 tmp 中的数组拷贝回 A[p...r]
            for (i=0;i<=r-p;i++) {
                a[p+i] = tmp[i];
            }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,8,6,3,2};
        merge_sort(a,a.length);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
