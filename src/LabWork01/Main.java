package LabWork01;

public class Main {
    public static void main(String[] args) {
        BookStack stack = new BookStack(10);

        stack.push(new Book("he Embodiment of Scarlet Devil"));
        stack.push(new Book("The Lord of the Rings"));
        stack.push(new Book("Magical Girls: Magic Destroyers"));

        System.out.println("Последняя добавленная книга: " + stack.peek().getTitle());
        System.out.println();

        while(!stack.isEmpty()) {
            System.out.println("После удаления: " + stack.pop().getTitle());
        }

        System.out.println();

        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}

