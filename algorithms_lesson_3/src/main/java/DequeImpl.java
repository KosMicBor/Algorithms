public class DequeImpl<T> implements Deque<T> {

    private final int LEFT_ELEM_DEFAULT = 0;
    private final int RIGhT_ELEM_DEFAULT = -1;
    private final int ZERO_VAL = 0;
    private final int ONE_VAL = 1;

    private final int maxSize;
    private final T[] deque;
    private int leftElem;
    private int rightElem;
    private int items;

    public DequeImpl(int size) {
        maxSize = size;
        this.deque = (T[]) new Object[maxSize];
        leftElem = LEFT_ELEM_DEFAULT;
        rightElem = RIGhT_ELEM_DEFAULT;
        items = ZERO_VAL;
    }

    public boolean insertLeft(T value) {
        T temp = deque[leftElem];

        if (isFull()) {
            return false;
        }
        if (leftElem == maxSize) {
            leftElem = LEFT_ELEM_DEFAULT;
        }
         ++items;

        for (int i = items; i >= leftElem; i--) {

            if (i == leftElem) {
                deque[i] = value;
                rightElem++;
            } else {
                deque[i] = deque[i - ONE_VAL];
            }
        }

        return true;
    }

    public boolean insertRight(T value) {
        if (isFull()) {
            return false;
        }
        if (rightElem == maxSize - ONE_VAL) {
            rightElem = RIGhT_ELEM_DEFAULT;
        }
        deque[++rightElem] = value;
        items++;
        return true;
    }

    public T removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (rightElem == maxSize - ONE_VAL) {
            rightElem = RIGhT_ELEM_DEFAULT;
        }

        T temp = deque[rightElem--];
        items--;
        return temp;
    }

    @Override
    public T removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (leftElem == maxSize) {
            leftElem = LEFT_ELEM_DEFAULT;
        }

        T temp = deque[leftElem++];
        items--;
        return temp;
    }

    public T peekRight() {
        return deque[rightElem];
    }

    public T peekLeft() {
        return deque[leftElem];
    }

    public boolean isEmpty() {
        return (items == ZERO_VAL);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = leftElem; i <= rightElem; i++) {
            sb.append(deque[i]);
            if (i != rightElem) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean insert(T value) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }
}
