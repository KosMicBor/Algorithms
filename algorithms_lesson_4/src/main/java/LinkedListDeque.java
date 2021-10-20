public interface LinkedListDeque<T> extends LinkedList<T> {

    void insertLast(T value);

    T getLast();

    Node<T> removeLast();
}
