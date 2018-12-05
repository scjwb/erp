package sort;
//插入排序，空间复杂度o(1)，时间复杂度o(n2) ,稳定排序
//虽然插入排序跟冒泡排序的复杂度一样，但数据交换比数据移动的操作要复杂
//因此插入排序要更受欢迎
public class InsertSortTest {
    public static void insertSort(int[] a,int n){
        if (n<=1){
            return;
        }
        for (int i=1;i<n;i++){
            int value = a[i];
            int j =i-1;
            for (;j<i;j--){
                if (a[j]>value){
                    a[j+1]=a[j];
                }else {
                    break;
                }
            }
            a[j+1]=value;
        }

    }
    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,8,6,3,2};
        insertSort(a,a.length);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
