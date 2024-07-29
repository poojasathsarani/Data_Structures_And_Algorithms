import java.util.ArrayList;
import java.util.List;

class GeneralTreeNode<T> {
    T data;
    List<GeneralTreeNode<T>> children;

    GeneralTreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    void addChild(GeneralTreeNode<T> child) {
        this.children.add(child);
    }
}

class GeneralTree<T> {
    GeneralTreeNode<T> root;

    GeneralTree(T rootData) {
        root = new GeneralTreeNode<>(rootData);
    }

    // Depth-first traversal
    void traverseDFS(GeneralTreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        for (GeneralTreeNode<T> child : node.children) {
            traverseDFS(child);
        }
    }
}

public class GeneralTreeExample {
    public static void main(String[] args) {
        GeneralTree<String> tree = new GeneralTree<>("root");
        GeneralTreeNode<String> child1 = new GeneralTreeNode<>("child1");
        GeneralTreeNode<String> child2 = new GeneralTreeNode<>("child2");
        tree.root.addChild(child1);
        tree.root.addChild(child2);
        child1.addChild(new GeneralTreeNode<>("child1.1"));
        child1.addChild(new GeneralTreeNode<>("child1.2"));
        child2.addChild(new GeneralTreeNode<>("child2.1"));

        tree.traverseDFS(tree.root); // Output: root child1 child1.1 child1.2 child2 child2.1
    }
}
