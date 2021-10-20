public interface LinkedList<T> {

    int size();

    void insertFirst(T value);

    T removeFirst();

    boolean remove(T value) throws MyException;

    boolean isContains(T value);

    boolean isEmpty();

    void display();

    T getFirst();

    Node<T> getFirstElem();

    class Node<T> {
        T item;

        Node<T> next;
        Node<T> previous;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        public Node(T item, Node<T> next, Node<T> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

}