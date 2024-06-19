package Task_Chapter_5_2;

public interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
