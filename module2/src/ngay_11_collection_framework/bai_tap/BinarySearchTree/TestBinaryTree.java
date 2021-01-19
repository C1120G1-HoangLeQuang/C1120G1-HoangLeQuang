package ngay_11_collection_framework.bai_tap.BinarySearchTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(10);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(15);
        binaryTree.add(28);
        binaryTree.add(12);
        binaryTree.add(7);
        binaryTree.add(32);
        binaryTree.add(8);
        binaryTree.traversePostOrder(binaryTree.root);    // chat PostOrder
        System.out.println();
        binaryTree.delete(10);
        binaryTree.traversePreOrder(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree.search(8));

    }
}
