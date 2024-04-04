public class BookStack {
    private final Book[] stack;
    private int top;
    private final int capacity;

    public BookStack(int size) {
        stack = new Book[size];
        capacity = size;
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(Book book) {
        if(isFull()) {
            System.out.println("Стек переполнен Невозможно добавить книгу");
            System.exit(1);

        }
        stack[++top] = book;
    }

    public Book pop() {
        if(isEmpty()) {
            System.out.println("Стек пуст Невозможно удалить книгу");
            System.exit(1);
        }
        return stack[top--];
    }

    public Book peek() {
        if(!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Стек пустой");
            System.exit(1);
        }
        return null;
    }
}