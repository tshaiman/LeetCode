import java.util.*;

public class DeserializeTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v){ this(v,null,null);}
        public TreeNode(int v,TreeNode l,TreeNode r) { this.val = v;this.left = l; this.right = r;}
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(7);
        TreeNode tree = new TreeNode(3,l1,r1);

        TreeNode l3 = new TreeNode(7);
        TreeNode l2 = new TreeNode(5,l3,null);
        TreeNode tree2 = new TreeNode(3,l2,null);

        String treeStr = serialize(tree);
        TreeNode restored = deserialize(treeStr);
        treeStr = serialize(tree2);
        restored = deserialize(treeStr);

    }

    private static String serialize(TreeNode tree){
            return serialize(tree,new StringBuffer());
    }

    private static String serialize(TreeNode tree, StringBuffer sb) {
        if(tree == null) {
            sb.append("*;");
            return sb.toString();
        }
        sb.append(tree.val +";");
        serialize(tree.left, sb);
        serialize(tree.right, sb);
        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        if(data ==null || data.length() == 0)
            return null;
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(";")));
        return deserialize(nodes);
    }

    private static TreeNode deserialize(LinkedList<String> nodes) {
        if(nodes.size() == 0)
            return null;
        String val = nodes.pop();
        if(val.equals("*"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


}
