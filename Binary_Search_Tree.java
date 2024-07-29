class BSTNode<T extends Comparable<T>> {
    T data;
    BSTNode<T> left, right;

    BSTNode(T data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinarySearchTree<T extends Comparable<T>> {
    BSTNode<T> root;

    void insert(T data) {
        root = insertRec(root, data);
    }

    private BSTNode<T> insertRec(BSTNode<T> root, T data) {
        if (root == null) {
            root = new BSTNode<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // In-order traversal
    void inOrder(BSTNode<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}

public class BSTExample {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.inOrder(bst.root); // Output: 20 30 40 50 60 70 80
    }
}
