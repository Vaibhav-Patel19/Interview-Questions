package ImportantQ.Arrays;
//Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
// Merge them in sorted order without using any extra space. Modify arr1 so that it
// contains the first N elements and modify arr2 so that it contains the last M elements.

public class MergeSortedArrays {

    //Brute
//    public static void merge(long arr1[], long arr2[], int n, int m)
//    {
//        long[] temp = new long[n+m];
//        int p1 = 0;
//        int p2 = 0;
//        int i = 0;
//
//        while(p1<n && p2<m){
//            if(arr1[p1] <= arr2[p2]){
//                temp[i] = arr1[p1];
//            }else{
//                temp[i] = arr2[p2];
//            }
//        }
//        p1 = 0;
//        p2 = 0;
//        i = 0;
//        while(p1 < n){
//            arr1[p1] = temp[i];
//            p1++;
//            i++;
//        }
//        while(p2 < m){
//            arr2[p2] = temp[i];
//            p2++;
//            i++;
//        }
//    }

//    //Better Approach
//    public static void merge(long[] arr1, long[] arr2, int n, int m){
//
//        int i = 0, j = 0;
//        while(i < n && j < m){
//            j = 0;
//            if(arr1[i] <= arr2[j])
//            {
//                i++;
//            }
//            else{
//                long temp = arr1[i];
//                arr1[i] = arr2[j];
//                arr2[j] = temp;
//
//                for(j = 1; j < arr2.length; j++){
//                    if(arr2[j] < arr2[j-1]){
//                        temp = arr2[j];
//                        arr2[j] = arr2[j-1];
//                        arr2[j-1] = temp;
//                    }
//                }
//                j=0;
//            }
//        }
//    }


    public static int nextGap(int gap){
        if(gap == 1){
            return 0;
        }
        else {
            return gap/2 + gap%2;
        }
    }
    public static void main(String[] args){

        int[] arr1 = {10 ,27 ,38 ,43,82};
        int[] arr2 = {2,3,8,9,50,100};

        //Optimal method
        int gap = arr1.length + arr2.length;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)){

            int i;
            int j;
            //Comparing elements in First array
            for(i = 0; i+gap < arr1.length;i++){
                if(arr1[i] > arr1[i+gap]){
                    int temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[gap+i] = temp;
                }
            }

            //Comparing elements in both arrays
            for(j = 0; j < arr2.length && i < arr1.length;j++){
                if(arr1[i] > arr2[j]){
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
            }

            //Comparing elements in Second array
            for(int k = 0; j < arr2.length; k++){
                if(arr2[k] > arr2[j]){
                    int temp = arr1[k];
                    arr1[k] = arr1[j];
                    arr1[j] = temp;
                }
                j++;
            }
        }

        for(long e:arr1){
            System.out.print(e + " ");
        }
        System.out.println();
        for(long e:arr2){
            System.out.print(e + " ");
        }
    }
}