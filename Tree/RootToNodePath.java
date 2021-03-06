package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.ArrayList;
// https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/

public class RootToNodePath {
    public ArrayList<Integer> solve(TreeNode root, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        path(root, result, b);
        return result;
    }

    public boolean path(TreeNode root, ArrayList<Integer> result, int b){
        if(root == null)
            return false;

        result.add(root.val);
        if(root.val == b)
            return true;

        boolean left = false, right = false;

        if(root.left != null)
            left = path(root.left, result, b);

        if(root.right != null)
            right = path(root.right, result, b);

        if(left || right)
            return true;

        result.remove(result.size() - 1);
        return false;
    }
}
