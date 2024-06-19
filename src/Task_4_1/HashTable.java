package Task_4_1;

class HashTable {
    private int size;
    private Integer[] keys;
    private String[] values;

    public HashTable(int size) {
        this.size = size;
        this.keys = new Integer[size];
        this.values = new String[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key, String value) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (keys[index] != null) {
            if (keys[index].equals(key)) { // Обновляем значение, если ключ уже существует
                values[index] = value;
                System.out.println("Обновить ключ " + key + " по значению " + value + " на индексе " + index);
                return;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                System.out.println("Таблица заполнена");
                return;
            }
        }
        keys[index] = key;
        values[index] = value;
        System.out.println("Ключ " + key + " с значением " + value + " на индиксе " + index);
    }

    public String search(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return values[index];
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        return null;
    }

    public void delete(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                keys[index] = null;
                values[index] = null;
                System.out.println("Удалить ключ " + key + " из индекса " + index + "\n");
                // Перехешируем элементы в цепочке, чтобы не нарушить порядок поиска
                index = (index + 1) % size;
                while (keys[index] != null) {
                    int tempKey = keys[index];
                    String tempValue = values[index];
                    keys[index] = null;
                    values[index] = null;
                    insert(tempKey, tempValue);
                    index = (index + 1) % size;
                }
                return;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
        System.out.println("Ключ " + key + " не найден");
    }

    public void displayTable() {
        for (int i = 0; i < size; i++) {
            if (keys[i] != null) {
                System.out.println("Index " + i + ": [" + keys[i] + ", " + values[i] + "]");
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(4, "Здание");
        hashTable.insert(1, "Элронд");
        hashTable.insert(11, "Гэндальф");
        hashTable.insert(21, "Галадриэль");
        hashTable.insert(2, "Арагорн");
        hashTable.insert(12, "Фродо ");
        hashTable.insert(22, "Саурон");

        System.out.println();

        hashTable.displayTable(); // Показать содержимое хэш-таблицы

        System.out.println();

        System.out.println("Поиск : " + hashTable.search(11) + "\n"); // Поиск значения по ключу 11

        hashTable.delete(11); // Удаление ключа 11

        System.out.println();

        hashTable.displayTable(); // Показать содержимое хэш-таблицы после удаления
    }
}