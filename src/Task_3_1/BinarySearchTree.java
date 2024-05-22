package Task_3_1;

public class BinarySearchTree {
    Node root;

    //методв вставками
    //для работы будет вызывать вспомогательный метод, созданный для него индивидуально
    //причиная использования вспогательных методов - это использования рекурсии и из-за этого ее легче использовать, когда у нас есть вспомогательный метод
    public void insert(Node node) {
        root = insertHelper(root, node);
    }

    //вспомогательный метод для метода вставками
    private Node insertHelper(Node root, Node node) {
        int data = node.data;

        if(root == null) {
            root = node;
            return root;
        }
        else if (data < root.data) {
            root.left = insertHelper(root.left, node);
        }
        else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    //метод отображения
    public void display() {
        displayHelper(root);
    }

    //вспомогательный метод для метода отображения
    private void displayHelper(Node root) {
        //проверяем работает ли корневой узел под-дерева
        if(root != null) {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }

    //метод посика
    public boolean search(int data) {
        return searchHelper(root, data);
    }

    //вспомогательный метод для метода посика
    //посик элемента, то есть куда его вставлять
    private boolean searchHelper(Node root, int data) {
        if(root == null) {
            return false;
        }
        else if (root.data == data) {
            return true;
        }
        else if (root.data > data) {
            return searchHelper(root.left, data);

        }
        else {
            return searchHelper(root.right, data);
        }
    }

    //метод удаления
    public void remove(int data) {
        if (search(data)) {
            removeHelper(root, data);
        }
        else {
            System.out.println(data + " Не найден ");
        }

    }

    //вспомогательный метод для удаления
    private Node removeHelper(Node root, int data) {
        if(root == null) {
            return root;
        }
        else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        }
        else if ((data > root.data)) {
            root.right = removeHelper(root.right, data);
        }
        else {
            if(root.left == null && root.right == null) {
                root = null;
            }
            else if (root.right != null) {
                // найти приемника для замены узла
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else {
                // найти предшественника для замены узла
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    //поиск приемника
    //найти наименьшее значение ниже правого дочернего элемента этого корневого уззла
    private int successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    //поиск предшественника
    //найти наибольшее значение ниже правого дочернего элемента этого корневого уззла
    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
