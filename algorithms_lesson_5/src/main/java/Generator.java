import java.util.ArrayList;

public class Generator {

    /**
     * Метод генерирует список предметов типа Thing
     * @return Список типа ArrayList с несколькими элементами типа Thing
     */
    public ArrayList<Thing> createThingsArray() {
        ArrayList<Thing> array = new ArrayList<>();
        array.add(new Thing("Ноутбук", 2.0, 25000));
        array.add(new Thing("Магнитофон", 4.5, 10000));
        array.add(new Thing("Ожерелье", 0.5, 15000));
        array.add(new Thing("Бабушкин ковёр", 5.0, 1000));
        array.add(new Thing("Наручные часы", 0.3, 3000));

        return array;
    }
}
