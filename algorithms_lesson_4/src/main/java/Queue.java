public interface Queue<E> {
    boolean insert(E value);

    E remove();

    E peekLeft();

    int size();

    boolean isFull();

    boolean isEmpty();

    void display();

}
