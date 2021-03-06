package ImportantQ.Tree;
import ImportantQ.Tree.Node.TreeNode;
import java.util.*;
// https://leetcode.com/problems/binary-tree-paths/submissions/
// return all the Leaf node paths in form of String in a List of String.
public class LeafNodePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        leafPaths(result, root, "");
        return result;
    }

    boolean isLeaf(TreeNode treeNode){
        return treeNode != null && treeNode.left == null && treeNode.right == null;
    }

    void leafPaths(List<String> result, TreeNode root, String current){
        if(root == null)
            return;
        if(isLeaf(root)){
            current += root.val;
            result.add(current);
            return;
        }
        current += (root.val + "->");
        leafPaths(result, root.left, current);
        leafPaths(result, root.right, current);
    }
}
