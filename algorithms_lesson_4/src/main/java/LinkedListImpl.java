import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<T> implements LinkedList<T>, Iterable<T> {

    protected int size = 0;
    protected Node<T> first;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insertFirst(T value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        Node<T> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(T value) throws MyException {
        Node<T> current = first;
        Node<T> previous = null;

        while (current != null) {

            if (current.item.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == first) {
            removeFirst();
            return true;
        }

        previous.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean isContains(T value) {
        Node<T> current = first;

        while (current != null) {

            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public T getFirst() {
        return first.item;
    }

    @Override
    public Node<T> getFirstElem() {
        return first;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.item);

            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }

        sb.append("]");


        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current;
        private Node<T> previous;
        private final LinkedList<T> list;

        public LinkedListIterator(LinkedList<T> list) {
            this.list = list;
            this.reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            previous = current;
            current = current.next;
            return previous.item;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
            previous.next = current.next;
            current.next = null;
        }

        public void reset() {
            current = list.getFirstElem();
            previous = null;
        }

    }
}
