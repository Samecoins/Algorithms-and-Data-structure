package Task_Chapter_5_2;

public class Main {
    public static void main(String[] args) {
        Stack<Student> studentStack = new ArrayStack<>();

        studentStack.push(new Student("Ахмад", 1, "Программная инженерия"));
        studentStack.push(new Student("Дима", 2, "Математика"));
        studentStack.push(new Student("Игорь", 3, "Строитель"));

        System.out.println("Peek: " + studentStack.peek());
        System.out.println("Pop: " + studentStack.pop());
        System.out.println("Peek after pop: " + studentStack.peek());

        while (!studentStack.isEmpty()) {
            System.out.println("Pop: " + studentStack.pop());
        }
    }
}
