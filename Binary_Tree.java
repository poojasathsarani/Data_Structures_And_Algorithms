class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left, right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTree<T> {
    BinaryTreeNode<T> root;

    BinaryTree(T rootData) {
        root = new BinaryTreeNode<>(rootData);
    }

    // In-order traversal
    void inOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Pre-order traversal
    void preOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Post-order traversal
    void postOrder(BinaryTreeNode<T> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>(1);
        tree.root.left = new BinaryTreeNode<>(2);
        tree.root.right = new BinaryTreeNode<>(3);
        tree.root.left.left = new BinaryTreeNode<>(4);
        tree.root.left.right = new BinaryTreeNode<>(5);

        tree.inOrder(tree.root); // Output: 4 2 5 1 3
        System.out.println();
        tree.preOrder(tree.root); // Output: 1 2 4 5 3
        System.out.println();
        tree.postOrder(tree.root); // Output: 4 5 2 3 1
    }
}
