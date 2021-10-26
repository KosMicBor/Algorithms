import java.util.Stack;

public class TreeImpl<T extends Comparable<? super T>> implements Tree<T> {

    private Node<T> root;
    private int size;

    public Node<T> getRoot() {
        return root;
    }

    private class CurrentAndParent {
        Node<T> current;
        Node<T> parent;
        int level;

        public CurrentAndParent(Node<T> current, Node<T> parent, int level) {
            this.current = current;
            this.parent = parent;
            this.level = level;
        }
    }

    @Override
    public boolean contains(T value) {
        CurrentAndParent currentAndParent = findNode(value);
        return currentAndParent != null;
    }

    private CurrentAndParent findNode(T value) {
        Node<T> current = root;
        Node<T> parent = null;
        int level = 1;

        while (current != null) {

            if (current.getValue().equals(value)) {
                return new CurrentAndParent(current, parent, level);
            }

            parent = current;
            level++;

            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return new CurrentAndParent(null, parent, level);
    }

    @Override
    public boolean add(T value) {
        CurrentAndParent currentAndParent = findNode(value);

        if (currentAndParent.current != null) {
            return false;
        }

        Node<T> node = new Node<>(value);
        Node<T> parent = currentAndParent.parent;

        if (parent == null) {
            root = node;
        } else if (parent.isLeftChild(value)) {
            if (currentAndParent.level < 5) {
                parent.setLeftChild(node);
            }
        } else {

            if (currentAndParent.level < 5) {
                parent.setRightChild(node);
            }
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(T value) {
        CurrentAndParent currentAndParent = findNode(value);
        Node<T> removedNode = currentAndParent.current;
        Node<T> removedNodeParent = currentAndParent.parent;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()){
            removeNodeWithoutChildren(removedNode, removedNodeParent);
        } else if (removedNode.hasOnlyOneChild()) {
            removeNodeWithOneChild(removedNode, removedNodeParent);
        } else {
            removeNodeWithTwoChildren(removedNode, removedNodeParent);
        }
        size--;

        return true;
    }

    private void removeNodeWithoutChildren(Node<T> removedNode, Node<T> removedNodeParent) {
        if (removedNode == null) {
            root = null;
        } else if (removedNodeParent.isLeftChild(removedNode.getValue())) {
            removedNodeParent.setLeftChild(null);
        } else {
            removedNodeParent.setRightChild(null);
        }
    }

    private void removeNodeWithOneChild(Node<T> removedNode, Node<T> removedNodeParent) {
        Node<T> child = removedNode.getLeftChild() != null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();

        if (removedNode == root) {
            root = child;
        } else if (removedNodeParent.isLeftChild(removedNode.getValue())) {
            removedNodeParent.setLeftChild(child);
        } else {
            removedNodeParent.setRightChild(child);
        }
    }

    private void removeNodeWithTwoChildren(Node<T> removedNode, Node<T> removedNodeParent) {
        Node<T> successor = getSuccessor(removedNode);

        if (removedNode == root) {
            root = successor;
        } else if (removedNodeParent.isLeftChild(removedNode.getValue())) {
            removedNodeParent.setLeftChild(successor);
        } else {
            successor.setLeftChild(successor);
        }
    }

    private Node<T> getSuccessor(Node<T> removedNode) {
        Node<T> successor = removedNode;
        Node<T> successorParent = null;
        Node<T> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild() && successorParent != null) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
            successor.setLeftChild(removedNode.getLeftChild());
        }

        return successor;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..........................................");

        while (!isRowEmpty) {
            Stack<Node<T>> localStack = new Stack<>();
            isRowEmpty = true;

            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!stack.isEmpty()) {
                Node<T> temp = stack.pop();

                if (temp != null) {
                    System.out.print(temp.getValue());
                    localStack.push(temp.getLeftChild());
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null || temp.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }

            System.out.println(" ");

            while (!localStack.isEmpty()) {
                stack.push(localStack.pop());
            }

            nBlanks /= 2;
        }

        System.out.println("..........................................");
    }

    @Override
    public void traverse(TraverseMode mode) throws MyException {
        switch (mode) {
            case PRE_ORDER -> preOrder(root);
            case IN_ORDER -> inOrder(root);
            case POST_ORDER -> postOrder(root);
            default -> throw new MyException("Something has gone wrong, unknown traverse mode: " + mode);
        }

        System.out.println();
    }

    private void inOrder(Node<T> current) {

        if (current == null) {
            return;
        }

        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void postOrder(Node<T> current) {

        if (current == null) {
            return;
        }

        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    private void preOrder(Node<T> current) {

        if (current == null) {
            return;
        }

        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    public Node<T> findMin() {

        Node<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }

        return last;
    }

    public Node<T> findMax() {

        Node<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }

        return last;
    }


}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}
