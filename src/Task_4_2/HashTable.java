package Task_4_2;

import java.util.ArrayList;
import java.util.List;

class HashTable {
    private int size;
    private List<Entry>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, String value) {
        int index = hashFunction(key);
        List<Entry> chain = table[index];
        for (Entry entry : chain) {
            if (entry.key == key) {
                entry.value = value; // Обновляем значение, если ключ уже существует
                System.out.println("Обновить ключ " + key + " по значению " + value + " на индексе " + index);
                return;
            }
        }
        chain.add(new Entry(key, value)); // Добавляем новую пару ключ-значение в цепочку
        System.out.println("Ключ " + key + " с значением " + value + " на индиксе " + index);
    }

    public String search(int key) {
        int index = hashFunction(key);
        List<Entry> chain = table[index];
        for (Entry entry : chain) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        List<Entry> chain = table[index];
        for (Entry entry : chain) {
            if (entry.key == key) {
                chain.remove(entry);
                System.out.println("Удалить ключ " + key + " из индекса " + index);
                return;
            }
        }
        System.out.println("Ключ " + key + " не найден");
    }

    public void displayTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[" + entry.key + ", " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    private static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(1, "Элронд");
        hashTable.insert(11, "Гэндальф");
        hashTable.insert(21, "Галадриэль");
        hashTable.insert(2, "Арагорн");
        hashTable.insert(12, "Фродо ");
        hashTable.insert(22, "Саурон");

        System.out.println();

        hashTable.displayTable(); // Показать содержимое хэш-таблицы

        System.out.println();

        System.out.println("Поиск : " + hashTable.search(11)); // Поиск значения по ключу 11

        hashTable.delete(11); // Удаление ключа 11

        System.out.println();

        hashTable.displayTable(); // Показать содержимое хэш-таблицы после удаления
    }
}

