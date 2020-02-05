package tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class Tree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void printNodesRecursively(Node root){
        System.out.println(root.getKey() + ", " + root.isLeftChild());
        if(!(root.getLeft()==null)){
            printNodesRecursively(root.getLeft());
        }
        if(!(root.getRight()==null)){
            printNodesRecursively(root.getRight());
        }
    }

    public void printNodesIteration(Node node){
        Queue<Node> queue = new PriorityQueue<Node>();
        Node current;
        queue.add(node);
        while (!queue.isEmpty()){
            current = queue.poll();
            System.out.println(current.getKey());
            if(!(current.getLeft()==null)){
                queue.add(current.getLeft());
            }
            if(!(current.getRight()==null)){
                queue.add(current.getRight());
            }
        }
    }

    public void addKey(Integer key){
        Node node = new Node(key);
        if(root==null){
            root = node;
        }else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(key<current.getKey()){
                    current = current.getLeft();
                    if (current==null){
                        parent.setLeft(node);
                        return;
                    }
                }else {
                    current = current.getRight();
                    if (current==null){
                        parent.setRight(node);
                        return;
                    }
                }
            }
        }

    }

    private Node getSuccessor(Node deletedNode){
        Node successor;
        Node current = deletedNode.getRight();
        while (current.getLeft()!=null){
            current = current.getLeft();
        }
        successor = current;
        return successor;
    }

    public Node findNode(int key){
        Node current = root;
        while (current.getKey()!= key){
            if(key<current.getKey()){
                current = current.getLeft();
            }else {
                current = current.getRight();
            }
            if (current == null)
            {
                return null;
            }
        }
        return current;
    }

    public void deleteNode(Integer key){
        Node current = findNode(key);
        boolean isLeftChild = current.isLeftChild();
        if (current.getLeft()== null && current.getRight() == null){
            if (current == root){
                root = null;
            }else if (isLeftChild){
                current.getParent().setLeft(null);
            }else {
                current.getParent().setRight(null);
            }
        }else if(current.getLeft()==null){
            if (current == root){
                root = current.getRight();
            }else if (isLeftChild){
                current.getParent().setLeft(current.getRight());
            }else {
                current.getParent().setRight(current.getRight());
            }
        }else if (current.getRight() == null){
            if(current == root){
                root = current.getLeft();
            }else if(isLeftChild){
                current.getParent().setLeft(current.getLeft());
            }else {
                current.getParent().setRight(current.getLeft());
            }
        }else{
            Node successor = getSuccessor(current);
            successor.setLeft(current.getLeft());
            if(successor.isLeftChild()){
                successor.getParent().setLeft(successor.getRight());
                successor.setRight(current.getRight());
            }
            if(current==root){
                root = successor;
            }else if(isLeftChild){
                current.getParent().setLeft(successor);
            }else {
                current.getParent().setRight(successor);
            }
        }
    }

}
