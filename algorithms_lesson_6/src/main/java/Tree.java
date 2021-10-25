public interface Tree <T extends Comparable<? super T>>{

    enum TraverseMode {
        IN_ORDER, PRE_ORDER, POST_ORDER;
    }

    boolean add(T value);

    boolean remove(T value);

    boolean contains(T value);

    boolean isEmpty();

    int getSize();

    void display();

    void traverse (TraverseMode mode) throws MyException;
}
