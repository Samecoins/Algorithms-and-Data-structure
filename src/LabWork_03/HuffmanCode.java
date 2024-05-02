package LabWork_03;

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }
}

class HuffmanCoding {

    public static void printCode(HuffmanNode root, String str) {
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            System.out.println(root.data + ":" + str);
            return;
        }
        printCode(root.left, str + "0");
        printCode(root.right, str + "1");
    }

    public static HuffmanNode buildTree(Map<Character, Integer> freq) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>(freq.size(), (a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            HuffmanNode hn = new HuffmanNode(entry.getKey(), entry.getValue());
            priorityQueue.offer(hn);
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.poll();
            HuffmanNode y = priorityQueue.poll();
            HuffmanNode z = new HuffmanNode('-', x.frequency + y.frequency);
            z.left = x;
            z.right = y;
            priorityQueue.offer(z);
        }

        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для кодирования по методу Хаффмана:");
        String inputString = scanner.nextLine();
        Map<Character, Integer> freq = new HashMap<>();

        // Calculate frequency of each character
        for (char c : inputString.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        HuffmanNode root = buildTree(freq);

        // Print the codes by traversing the tree
        System.out.println("Частота и кодировка символов:");
        printCode(root, "");
        scanner.close();
    }
}