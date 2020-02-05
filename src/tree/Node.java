package tree;

public class Node implements Comparable <Node> {
    private Node parent;
    private Node left;
    private Node right;
    private Integer key;
    private boolean isLeftChild;

    public Node getParent() {
        if (parent!=null) {
            return parent;
        }else {
            throw new NullPointerException();
        }
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isLeftChild() {
        return isLeftChild;
    }

    public void setLeftChild(boolean leftChild) {
        isLeftChild = leftChild;
    }


    public Node() {
    }

    public Node(Integer key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        if(left!=null){
            left.setParent(this);
            left.setLeftChild(true);
        }
        this.left = left;
    }

    public void setRight(Node right) {
        if (right!=null){
            right.setParent(this);
            right.setLeftChild(false);
        }
        this.right = right;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    @Override
    public int compareTo(Node o) {
        return this.getKey().compareTo(o.getKey());
    }
}
