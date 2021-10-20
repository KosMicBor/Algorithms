public class LinkedListDequeImpl<T> extends LinkedListImpl<T> implements LinkedListDeque<T> {

    protected Node<T> last;
    //protected Node<T> first;

    @Override
    public void insertLast(T value) {
        Node<T> newNode = new Node<>(value, null, last);

        if (isEmpty()) {
            insertFirst(value);
            return;
        }

        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public T getLast() {
        return last.item;
    }

    @Override
    public Node<T> removeLast() {
        Node<T> removedNode = last;

        if (isEmpty()) {
            return null;
        }

        last = last.previous;
        last.next = null;

        return removedNode;
    }

    @Override
    public void insertFirst(T value) {
        first = new Node<>(value, first, null);
        size++;

        if (size == 1) {
            last = first;
        }
    }

    @Override
    public T removeFirst() {
        T removedValue = super.removeFirst();

        if (isEmpty()) {
            last = null;
        }

        return removedValue;
    }

    @Override
    public boolean remove(T value) throws MyException {
        throw new MyException("You can't do this with Deque");
    }
}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}