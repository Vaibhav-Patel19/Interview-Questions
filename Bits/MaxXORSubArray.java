package ImportantQ.Bits;
// Given an array of integers. find the maximum XOR subarray value in given array. Expected time complexity O(n).
// https://www.geeksforgeeks.org/find-the-maximum-subarray-xor-in-a-given-array/

public class MaxXORSubArray {
    // Naive Approach T->O(n^2)
    public static int maxSubArrayXor(int[] arr){
        int n = arr.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int xor = 0;
            for(int j = i; j < n; j++){
                xor = xor ^ arr[j];
                if(xor > max){
                    max = xor;
                }
            }
        }
        return max;
    }

    // Optimal T-> O(n)
    static class TrieNode{
        int value;
        TrieNode[] arr = new TrieNode[2];
        public TrieNode(){
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }

    // Optimal T ->O(n) using Kadane Algorithm
    static int maxSubarrayXOR(int N, int arr[]){

        int max_end_here = 1;
        int max_so_far = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            max_end_here = Math.max(arr[i], max_end_here ^ arr[i]);

            if(max_end_here > max_so_far)
                max_so_far = max_end_here;
        }
        return max_so_far;
    }

}
