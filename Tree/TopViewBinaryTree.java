package ImportantQ.Tree;
import ImportantQ.Tree.TreeNode.Node;
import java.util.*;
// https://www.geeksforgeeks.org/print-nodes-in-the-top-view-of-binary-tree-set-3/

public class TopViewBinaryTree {
    static class Pair{
        Node node;
        int line;
        public Pair(Node node, int line){
            this.node = node;
            this.line = line;
        }
    }
    // T -> O(n) S-> O(2n)
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Map<Integer, Integer> map = new TreeMap<>();// line, node.data
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair current = q.remove();
            Node temp = current.node;
            int line = current.line;
            if(!map.containsKey(line))
                map.put(line, temp.data);

            if(temp.left != null)
                q.add(new Pair(temp.left, line - 1));

            if(temp.right != null)
                q.add(new Pair(temp.right, line + 1));
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}