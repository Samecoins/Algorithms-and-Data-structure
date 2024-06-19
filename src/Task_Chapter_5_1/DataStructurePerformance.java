package Task_Chapter_5_1;
import java.util.*;

public class DataStructurePerformance {

    public static void main(String[] args) {
        int[] sizes = {100};


        System.out.println("Insertion Times:");
        for (int size : sizes) {
            System.out.println("Size: " + size);
            System.out.println("ArrayList: " + measureTime(new ArrayList<>(), "insertion", size));
            System.out.println("LinkedList: " + measureTime(new LinkedList<>(), "insertion", size));
            System.out.println("Stack: " + measureTime(new Stack<>(), "insertion", size));
            System.out.println("Queue: " + measureTime(new LinkedList<>(), "insertion", size));
            System.out.println("Binary Search Tree: " + measureTime(new TreeSet<>(), "insertion", size));
            System.out.println();
            System.out.println("Custom ArrayList: " + measureTimeCustomArrayList(new CustomArrayList(size), "insertion", size));
            System.out.println("Custom Stack: " + measureTimeCustomStack(new CustomStack(size), "insertion", size));
            System.out.println("Custom Queue: " + measureTimeCustomQueue(new CustomQueue(size), "insertion", size));
            System.out.println("Custom Binary Search Tree: " + measureTimeCustomBST(new CustomBST(), "insertion", size));
            System.out.println();
            System.out.println("Custom LinkedList: " + measureTimeCustomLinkedList(new CustomLinkedList(), "insertion", size));
        }


    }

    public static long measureTime(Collection<Integer> structure, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    structure.add(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    if (!structure.isEmpty()) {
                        Iterator<Integer> iterator = structure.iterator();
                        iterator.next();
                        iterator.remove();
                    }
                } else if (operation.equals("search")) {
                    structure.contains(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }

    public static long measureTimeCustomArrayList(CustomArrayList array, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    array.add(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    if (array.getSize() > 0) {
                        array.delete(rand.nextInt(array.getSize()));
                    }
                } else if (operation.equals("search")) {
                    array.search(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }

    public static long measureTimeCustomStack(CustomStack stack, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    stack.push(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    if (stack.getSize() > 0) {
                        stack.pop();
                    }
                } else if (operation.equals("search")) {
                    stack.search(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }

    public static long measureTimeCustomQueue(CustomQueue queue, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    queue.enqueue(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    if (queue.getSize() > 0) {
                        queue.dequeue();
                    }
                } else if (operation.equals("search")) {
                    queue.search(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }

    public static long measureTimeCustomBST(CustomBST bst, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    bst.insert(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    bst.deleteKey(rand.nextInt(10000));
                } else if (operation.equals("search")) {
                    bst.search(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }

    public static long measureTimeCustomLinkedList(CustomLinkedList list, String operation, int size) {
        long totalTime = 0;
        Random rand = new Random();
        int iterations = 100; // Количество итераций

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < size; j++) {
                if (operation.equals("insertion")) {
                    list.add(rand.nextInt(10000));
                } else if (operation.equals("deletion")) {
                    if (list.search(rand.nextInt(10000))) {
                        list.delete(rand.nextInt(10000));
                    }
                } else if (operation.equals("search")) {
                    list.search(rand.nextInt(10000));
                }
            }
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return totalTime / 1_000_000; // Перевод в миллисекунды
    }
}

// Реализация собственного списка
class CustomArrayList {
    private int[] data;
    private int size;

    public CustomArrayList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = value;
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
        }
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }
}

// Реализация собственного стека
class CustomStack {
    private int[] data;
    private int top;

    public CustomStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == data.length - 1) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[++top] = value;
    }

    public int pop() {
        if (top >= 0) {
            return data[top--];
        }
        throw new EmptyStackException();
    }

    public boolean search(int value) {
        for (int i = 0; i <= top; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return top + 1;
    }

    public int getCapacity() {
        return data.length;
    }
}

// Реализация собственной очереди
class CustomQueue {
    private int[] data;
    private int front, rear, size;

    public CustomQueue(int capacity) {
        data = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size > 0) {
            int value = data[front];
            front = (front + 1) % data.length;
            size--;
            return value;
        }
        throw new NoSuchElementException();
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[(front + i) % data.length] == value) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }
}

// Реализация собственного бинарного дерева поиска
class CustomBST {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    CustomBST() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = deleteRec(root.left, key);
        else if (key > root.key) root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            root = root.left;
            minValue = root.key;
        }
        return minValue;
    }
}

// Реализация собственного односвязного списка
class CustomLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public CustomLinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}