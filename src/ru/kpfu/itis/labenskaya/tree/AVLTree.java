package ru.kpfu.itis.labenskaya.tree;

public class AVLTree {

    Node root;

    public void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    public int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    public Node getRoot() {
        return root;
    }

    public Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public Node balance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    public Node insert(Node node, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        else if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate key!");
        }
        return balance(node);
    }

    public Node delete(int key) {
        Node node = find(key);
        if (node.left == null || node.right == null) {
            node = (node.left == null) ? node.right : node.left;
        } else {
            Node mostLeftChild = findMin(node.right);
            node.key = mostLeftChild.key;
            node.right = delete(node.key);
        }
        if (node != null) {
            node = balance(node);
        }
        return node;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    public Node findMax(Node node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }
}
