public class LessonEightMainClass {
    public static void main(String[] args) {

        HashTable<Product, Integer> hashTable = new HashTableImpl<>(4);

        hashTable.put(new Product(1, "Видеокарта"), 25000);
        hashTable.put(new Product(2, "ОЗУ"), 1200);
        hashTable.put(new Product(33, "HDD"), 5000);
        hashTable.put(new Product(4, "DVD-rom"), 1000);
        hashTable.put(new Product(67, "Блок питания>"), 2000);
        hashTable.put(new Product(6, "Мышь"), 500);
        hashTable.put(new Product(18, "Клавиатура"), 250);
        hashTable.put(new Product(67, "Принтер"), 10000);
        hashTable.put(new Product(7, "Монитор"), 15000);
        hashTable.put(new Product(90, "Колонки"), 7000);
        hashTable.put(new Product(105, "Материнская плата"), 8000);

        hashTable.display();
        System.out.println("Всего элемкентов в таблице: " + hashTable.getSize());

        System.out.println("Стоимость ОЗУ: " + hashTable.get(new Product(2, "ОЗУ")) + " рублей");
        System.out.println("Стоимость DVD-rom: " + hashTable.get(new Product(4, "DVD-rom")) + " рублей");
        System.out.println("Стоимость Мыши: " + hashTable.get(new Product(6, "Мышь"))  + " рублей");
        System.out.println("Стоимость Материнской платы: " +
                           hashTable.get(new Product(105, "Материнская плата"))  + " рублей");

        hashTable.remove(new Product(7, "Монитор"));

        hashTable.display();

    }
}
