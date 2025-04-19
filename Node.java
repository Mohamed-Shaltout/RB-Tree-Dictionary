public class Node {
    Node left, right,parent;
    String data;
    boolean isRed;

    public Node(String data) {
        this.data = data;
        left = right = parent = null;
        isRed = true;
    }
}
