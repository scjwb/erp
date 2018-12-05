package sort;
//选择排序，空间复杂度o(1)，时间复杂度o(n2)，最好最坏都是o(n2) ,非稳定排序
//不建议使用
public class SelectSortTest {
    public static void selectSort(int[] a,int n){

        for (int i = 0;i<n;i++){
            int min = a[i];
            int minIndex = i;
            for (int j=i;j<n;j++){
                if (min > a[j]){
                    min = a[j];
                    minIndex = j;
                }
            }
            int value = a[i];
            a[i] = a[minIndex];
            a[minIndex] = value;
        }
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,8,6,3,2};
        selectSort(a,a.length);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
