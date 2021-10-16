public interface Deque <T> extends Queue<T> {

    boolean insertRight(T value);
    boolean insertLeft(T value);

    T removeRight();
    T removeLeft();
}
