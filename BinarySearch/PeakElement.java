package ImportantQ.BinarySearch;
// A peak element in an array is the one that is not smaller than its neighbours.
//Given an array arr[] of size N, find the index of any one of its peak elements.
//Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0.
// https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    //  Naive T->(n)
//    public int peakElement(int[] arr,int n)
//    {
//        if( n == 1){
//            return 0;
//        }
//        if(arr[0] > arr[1]){
//            return arr[0];
//        }
//        if(arr[n - 1] > arr[n - 2]){
//            return arr[n - 1];
//        }
//
//        for(int i = 1; i < n - 1; i++)
//        {
//            if (arr[i] >= arr[i - 1] &&
//                    arr[i] >= arr[i + 1])
//                return i;
//        }
//        return 0;
//    }

    //Optimal log(n)
    public int peakElement(int[] arr, int low, int high, int n)
    {
        int mid = (low + high) / 2;
        if((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n-1 || arr[mid] >= arr[mid + 1]))
            return mid;
        else if(mid > 0 && arr[mid - 1] > arr[mid])
            return peakElement(arr, low, mid - 1, n);
        else
            return peakElement(arr, mid + 1, high, n);
    }

    // Iterative
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = (low + high) >> 1;

            if((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == n-1 || arr[mid] >= arr[mid+1]))
                return mid;
            else if(mid > 0 && arr[mid] < arr[mid - 1])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low;
    }
}
