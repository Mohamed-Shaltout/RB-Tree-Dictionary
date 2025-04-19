
public class RBTree {
    private Node root;

    public RBTree() {
        root = null;
    }

    public Node getRoot(){
        return root;
    }


    public Node search(Node root, String data){
        if(root != null){
            if (root.data.equals(data))
                return root;
            else if (data.compareTo(root.data) < 0) {
                return search(root.left, data);
            }
            else {
                return search(root.right, data);
            }
        }
        return null;
    }

    public void insert(String data){
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixInsert(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null)
            return node;

        if (node.data.compareTo(root.data) < 0) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }

        return root;
    }

    private void fixInsert(Node node) {
        Node uncle;
        while (node.parent != null && node.parent.isRed) {
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateRight(node.parent.parent);
                }
            } else {
                uncle = node.parent.parent.left;
                if (uncle != null && uncle.isRed) {
                    node.parent.isRed = false;
                    uncle.isRed = false;
                    node.parent.parent.isRed = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }
                    node.parent.isRed = false;
                    node.parent.parent.isRed = true;
                    rotateLeft(node.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null) x.right.parent = y;
        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }


    public int print_tree_height(Node root){
        if (root == null)
            return -1;
        return 1 + Math.max(print_tree_height(root.left), print_tree_height(root.right));
    }

    public int print_black_height(Node root){
        int height = 0;
        while (root != null) {
            if (!root.isRed) height++;
            root = root.left;
        }
        return height;
    }


    public int print_tree_size(Node root){
        if(root == null)
            return 0;
        return 1 + print_tree_size(root.left) + print_tree_size(root.right);
    }

    
}
