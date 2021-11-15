public class HashTableImpl<K extends Comparable<K>, V> implements HashTable<K, V> {

    static class Item<K extends Comparable<K>, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Item<K, V> next;

        public Item(K key, V value, Item<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Item<K, V> getNext() {
            return next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item {" + "Key: " + key +
                    ", Value: " + value +
                    '}';
        }

        public void setNext(Item<K, V> next) {
            this.next = next;
        }
    }

    private Item<K, V>[] data;
    private int loadedSize;
    private final Double loadFactor;
    private final Item<K, V> emptyEntry;

    public HashTableImpl(int initCapacity) {
        this.data = new Item[initCapacity * 2];
        this.loadFactor = 0.75;
        this.emptyEntry = new Item<>(null, null, null);
        this.loadedSize = 0;
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        double loadFactor = loadedSize * 1.0 / data.length;

        if (loadFactor > this.loadFactor) {
            expand();
        }

        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new Item<>(key, value, null);
            loadedSize++;
        } else {
            Item<K, V> current = data[index];

            while (current != null) {
                if (current.getKey().compareTo(key) == 0) {
                    current.setValue(value);
                    break;
                }
                current = current.getNext();
            }

            if (current == null) {
                data[index] = new Item<>(key, value, data[index]);
            }
        }

        return false;
    }

    private void expand() {
        Item<K, V>[] oldData = this.data;
        loadedSize = 0;

        data = new Item[2 * oldData.length];

        for (int i = 0; i < oldData.length; i++) {
            Item<K, V> current = oldData[i];

            while (current != null) {
                this.put(current.getKey(), current.getValue());
                current = current.getNext();
            }
        }
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);

        Item<K, V> item = data[index];

        while (item != null) {

            if (item.getKey().compareTo(key) == 0) {
                return item.getValue();
            }

            item = item.next;
        }

        return null;
    }


    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return null;
        } else {
            Item<K, V> previous = null;
            Item<K, V> current = data[index];

            while (current != null) {
                if (current.getKey().compareTo(key) == 0) {
                    if (previous == null) {
                        data[index] = current.getNext();
                    } else {
                        previous.setNext(current.getNext());
                    }

                    if (data[index] == null) {
                        loadedSize--;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
            return null;
        }
    }

    @Override
    public int getSize() {
        int size = 0;

        for (Item<K, V> datum : data) {
            Item<K, V> current = datum;

            if (current != null) {

                while (current != null) {
                    size++;
                    current = current.getNext();
                }

            }
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return data.length != 0;
    }

    @Override
    public void display() {
        System.out.println("___________________________________");

        for (int i = 0; i < data.length; i++) {
            Item<K, V> current = data[i];

            if (current != null) {

                while (current != null) {
                    System.out.printf("%d = [%s]%n", i, current);
                    current = current.getNext();
                }

            }
        }

        System.out.println("___________________________________");
    }
}
