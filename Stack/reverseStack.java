package ImportantQ.Stack;
import java.util.Stack;
// https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/

public class reverseStack {

    // T-> O(n^2)
    private static void reverse(Stack<Integer> stack) {

        if(!stack.isEmpty()) {
            int data = stack.pop();
            reverse(stack);

            insertAtBottom(stack, data);
        }
    }

    static void insertAtBottom(Stack<Integer> stack, int data) {
        if(!stack.isEmpty()){
            int val = stack.pop();
            insertAtBottom(stack, data);
            stack.push(val);
        }else{
            stack.push(data);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);

        for(int i:stack) {
            System.out.print(i + " ");
        }
    }
}
