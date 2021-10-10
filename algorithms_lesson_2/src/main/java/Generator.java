import java.util.ArrayList;
import java.util.Random;

public class Generator {

    public Generator() {
    }

    /**
     * Данный метод генерирует массив объектов класса Notebook со случайными парааметрами из заранее созданных массивов
     * @param quantity количество элементов массива
     * @param costs массив со значениями цен на ноутбуки
     * @param ramSizes массив со значениями ОЗУ ноутбуков
     * @return ArrayList с объектами класса Notebook со случайными парааметрами
     */
    public ArrayList<Notebook> genArrOfNotebooks(
            int quantity, ArrayList<Integer> costs,
            ArrayList<Integer> ramSizes){


        ArrayList<Notebook> notebookArrayList = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {

            notebookArrayList.add(createNotebook(costs, ramSizes));
        }
        return notebookArrayList;
    }

    /**
     * Метод генерирует массив со значениями стоимости ноутбуков с заданным шагом и в заданном диапазоне
     * @param costStep шаг для генерирования стоимости
     * @param minCost нижняя граница стоимости
     * @param maxCost верхняя граница стоимости
     * @return ArrayList со значениями стоимости ноутбуков
     */
    public ArrayList<Integer> costArrGenerator (int costStep, int minCost, int maxCost){
        ArrayList<Integer> costArr = new ArrayList<>();
        for (int i = minCost; i <= maxCost; i+=costStep) {
            costArr.add(i);
        }
        return costArr;
    }

    /**
     * Метод генерирует массив со значениями объёма ОЗУ ноутбуков с заданным шагом и в заданном диапазоне
     * @param step шаг для генерирования объёма ОЗУ
     * @param minSize нижняя граница объёма ОЗУ
     * @param maxSize верхняя граница объёма ОЗУ
     * @return ArrayList со значениями объёма ОЗУ ноутбуков
     */
    public ArrayList<Integer> ramSizeArrGenerator (int step, int minSize, int maxSize){
        ArrayList<Integer> costArr = new ArrayList<>();
        for (int i = minSize; i <= maxSize; i+=step) {
            costArr.add(i);
        }
        return costArr;
    }

    /**
     * Метод генерирует объект класса Notebook со случайными параметрами
     * @param costs массив со значениями стоимости ноутбуков
     * @param ramSizes массив со значениями объёма ОЗУ ноутбуков
     * @return объект класса Notebook со случайными параметрами
     */
    private Notebook createNotebook(
            ArrayList<Integer> costs,
            ArrayList<Integer> ramSizes
    ) {
        Random random = new Random();
        int cost = costs.get(random.nextInt(costs.size()));
        int ramSize = ramSizes.get(random.nextInt(ramSizes.size()));
        int manufacturersCount = Manufacturers.values().length;
        Manufacturers manufacturer = Manufacturers.values()[random.nextInt(manufacturersCount)];

        return new Notebook(cost, ramSize, manufacturer);
    }
}
