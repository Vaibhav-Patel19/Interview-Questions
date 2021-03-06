package ImportantQ.Arrays.ArrayList;
import java.util.ArrayList;
import java.util.List;
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// If you want to print a particular row formula is
// (row-1) C (column-1) , where C = Combination
//https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {
    public static List<List<Integer>> generate(int n) {
        // n = Number of Rows in Triangle
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row, pre = null; // current for storing current row and pre for previous row
        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0)  // first and last element in a row is always 1
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));

            }
            pre = new ArrayList<>(row);
            ans.add(row);
        }
        return ans;
    }

    public static int factorial(int f){
        if(f == 1)
            return f;
        return f * factorial(f-1);
    }

    // For calculating particular row of pascal Triangle
    public static double combination(int upper, int base){
        int flag = upper - base;
        double ans = 1;
        for(int i = 0; i < flag; i++){
            if(base > 0)
                ans = ans *  upper-- / base--;
            else
                ans = ans * upper--;
        }
        return ans;
    }

    public static void main(String[] args){

        System.out.print(combination(5,2));
    }
}
