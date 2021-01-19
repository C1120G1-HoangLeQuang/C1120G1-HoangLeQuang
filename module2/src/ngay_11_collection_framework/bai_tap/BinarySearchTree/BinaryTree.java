package ngay_11_collection_framework.bai_tap.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    // Them phan tu vao BinaryTree
    private Node addRecursive(Node current, int value) {
        if (current == null) {                 // neu chua co phai gan gia tri moi cho root
            return new Node(value);
        }
        if (value < current.value) {          //truong hop gia tri them vao duoc so sanh vs root. nho hon thi vao ben trai
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {   // lon hon thi day qua ben phai
            current.right = addRecursive(current.right, value);
        } else {                            // neu bang se gan gia tri dc ghi chong len root
            return current;                  // value da ton tai
        }
        return current;
    }
    public void add(int value) {           // phuong thuc add dc ap dung, gan root = current
        root = addRecursive(root, value);
    }
    // Tim phan tu trong binaryTree
    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {                // neu root = null thi khong gi de tim
            return false;
        }
        if (value == current.value) {         // gia tri truyen vao = root
            return true;
        }
        return value < current.value           // so sanh gia tri truyen vao voi root de phan huong tim kiem by 3 ngoi
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }
    public boolean search(int value) {         // phuong thuc duoc ap dung
        return containsNodeRecursive(root, value);
    }
    // Xoa phan tu trong BinaryTree
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {                           // root = null khong co j de xoa
            return null;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        if (value > current.value){
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        // truong hop value muon xoa = root
        if (current.left == null && current.right == null) {  // khong co child
            return null;
        }
        if (current.left == null) {      // chi co 1 con hoac left hoac right, root =
            return current.right;
        }
        if (current.right == null) {
            return current.left;
        }
        int smallestValue = findSmallestValue(current.right);   // dung ham smallest ben tren de gan gia tri moi cho root
        current.value = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }
    private int findSmallestValue(Node root) {  //trong truong hop ca 2 ben deu ton tai, se lay phan tu nho nhat ben right =root
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    public void delete(int value) {
        root =  deleteRecursive(root, value);
    }

    // duyet BinaryTree theo InOrder
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    // duyet Binary theo PreOrder
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // duyet Binary theo PostOrder
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    // duyet Binary theo Breadth-First
    public void breadthFirst() {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(" " + node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
