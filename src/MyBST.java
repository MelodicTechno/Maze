import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class MyBST<K extends Comparable<K>, V> implements BST<K, V> {

    // inner class TreeNode
    public static class TreeNode<K extends Comparable<K>, V> {
        private V val;
        private final K key;
        private TreeNode<K, V> left;
        private TreeNode<K, V> right;
        // constructor
        public TreeNode(K key, V val) {
            this.val = val;
            this.key = key;
        }
    }

    private TreeNode<K, V> root;
    // properties
    private int numOfNodes;
    // constructor

    public MyBST() {

    }
    // insert method
    @Override
    public void insert(K key, V value) {
        // pre-condition
        if (key == null || value == null) {
            return;
        }
        // if the tree is empty
         if (root == null) {
             root = new TreeNode<>(key, value);
             return;
         }
        TreeNode<K, V> cur = root;
        TreeNode<K, V> pre = null;
        while (cur != null) {
            if (cur.key.equals(key)) {
                // replace the value with the new one if the key exists
                cur.val = value;
                return;
            }
            pre = cur;
            if (key.compareTo(cur.key) < 0) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        TreeNode<K, V> newNode = new TreeNode<>(key, value);
        if (pre.key.compareTo(key) < 0) {
            pre.right = newNode;
        }
        else {
            pre.left = newNode;
        }
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            return null;
        }
        TreeNode<K, V> cur = root;
        TreeNode<K, V> pre = null;
        while (cur != null) {
            if (cur.key.equals(key)) {
                break;
            }
            pre = cur;
            if (cur.key.compareTo(key) < 0) {
                cur = cur.right;
            }
            else {
                cur = cur.left;
            }
        }
        if (cur == null) {
            return null;
        }
        // copy the node to be removed
        TreeNode<K, V> curCpy = cur;
        if (cur.left == null || cur.right == null) {
            TreeNode<K, V> child = cur.left != null ? cur.left : cur.right;
            // if not remove the root
            if (cur != root) {
                if (pre.left == cur) {
                    pre.left = child;
                }
                else {
                    pre.right = child;
                }
            }
            else {
                root = child;
            }
        }
        else {
            TreeNode<K, V> tmp = cur.left;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            remove(tmp.key);
            cur.val = tmp.val;
        }
        // return the node's value
        return curCpy.val;
    }

    @Override
    public V search(K key) {
        if (key == null) {
            return null;
        }
        TreeNode<K, V> cur = root;
        while (cur != null) {
            if (key.compareTo(cur.key) < 0) {
                cur = cur.left;
            }
            else if (key.compareTo(cur.key) > 0) {
                cur = cur.right;
            }
            else {
                break;
            }
        }
        if (cur == null) {
            return null;
        }
        return cur.val;
    }

    @Override
    public boolean update(K key, V value) {
        if (key == null || value == null) {
            return false;
        }
        TreeNode<K, V> cur = root;
        while (cur != null) {
            if (key.compareTo(cur.key) < 0) {
                cur = cur.left;
            }
            else if (key.compareTo(cur.key) > 0) {
                cur = cur.right;
            }
            else {
                break;
            }
        }
        if (cur == null) {
            return false;
        }
        cur.val = value;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public void showStructure(PrintWriter pw) throws IOException {
        if (pw == null) {
            throw new IOException();
        }
        // count the levels and the nodes
        levelTraverse();
        int height = countHeight(root);
        // show
        pw.println("-----------------------------");
        pw.printf("There are %d nodes in this BST.\n", numOfNodes);
        pw.printf("The height of thisBST is %d.\n", height);
        pw.println("-----------------------------");
    }

    // print the tree in inorder
    @Override
    public void printInOrder(PrintWriter pw) throws IOException {
        if (pw == null) {
            throw new IOException();
        }
        inorderTraverse(root, pw);
    }

    // traverse by level
    public void levelTraverse() {
        if (root == null) {
            return;
        }
        int resOdNumOfNodes = 1;
        // the queue for traverse
        Queue<TreeNode<K, V>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<K, V> node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                resOdNumOfNodes++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                resOdNumOfNodes++;
            }
        }
        numOfNodes = resOdNumOfNodes;
    }

    // inorder traverse
    public void inorderTraverse(TreeNode<K, V> root, PrintWriter pw) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, pw);
        pw.printf("[%s --- < %s >]\n", root.key, root.val);
        inorderTraverse(root.right, pw);
    }

    public int countHeight(TreeNode<K, V> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);
        if (leftHeight > rightHeight) {
            return (leftHeight + 1);
        }
        else {
            return (rightHeight + 1);
        }
    }
}
