package sort;
//冒泡排序
public class BubbleSortTest {
    public static void bubbleSort(int[] a,int n){
        if (n<=1){
            return;
        }
        for(int i=0;i<n;i++){
            boolean change = true;
            for (int j =0;j<n-i-1;j++){
                if (a[j]>a[j+1]){
                    int tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                    change = false;
                }
            }
            if (change){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,5,8,6,3,2};
        bubbleSort(a,a.length);
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
