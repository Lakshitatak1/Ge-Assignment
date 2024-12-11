class BinaryNode<T extends Comparable<T>> {
    T key;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree<T extends Comparable<T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Add a node to the BST
    public void add(T key) {
        this.root = addRecursively(root, key);
    }

    private BinaryNode<T> addRecursively(BinaryNode<T> current, T key) {
        if (current == null) {
            return new BinaryNode<>(key);
        }
        if (key.compareTo(current.key) < 0) {
            current.left = addRecursively(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = addRecursively(current.right, key);
        }
        return current;
    }

    // Check the size of the BST
    public int size() {
        return calculateSize(root);
    }

    private int calculateSize(BinaryNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + calculateSize(node.left) + calculateSize(node.right);
    }

    // Search for a key in the BST
    public boolean search(T key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(BinaryNode<T> current, T key) {
        if (current == null) {
            return false;
        }
        if (key.compareTo(current.key) == 0) {
            return true;
        }
        return key.compareTo(current.key) < 0
                ? searchRecursively(current.left, key)
                : searchRecursively(current.right, key);
    }

    // Print the BST in-order
    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BinaryNode<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }
}

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Add elements: 56, 30, 70
        bst.add(56);
        bst.add(30);
        bst.add(70);

        // Print the BST in-order (should print sorted order)
        System.out.println("In-order traversal of BST:");
        bst.inOrderTraversal();

        // Check size of the BST
        System.out.println("Size of BST: " + bst.size());

        // Search for 63
        int searchKey = 63;
        System.out.println("Is " + searchKey + " present in BST? " + bst.search(searchKey));

        // Add more elements to create the tree shown in the figure
        bst.add(22);
        bst.add(40);
        bst.add(60);
        bst.add(95);
        bst.add(11);
        bst.add(65);
        bst.add(3);
        bst.add(16);

        // Print the updated BST
        System.out.println("Updated in-order traversal of BST:");
        bst.inOrderTraversal();

        // Check size of the updated BST
        System.out.println("Updated size of BST: " + bst.size());

        // Search for 63 again
        System.out.println("Is " + searchKey + " present in updated BST? " + bst.search(searchKey));
    }
}
