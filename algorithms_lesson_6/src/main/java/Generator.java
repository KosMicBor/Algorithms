import java.util.ArrayList;
import java.util.Random;

public class Generator<T> {

    /**
     * Метод генерирует массив Integer значений в заданном диапазоне и с заданным размером
     * @param lowLimit нижний порог диапазона значений
     * @param highLimit верхний порог диапазона значений
     * @param numberOfValues размер массива
     * @return массив случайных чисел
     */
    public ArrayList<Integer> genRandomValuesArray(Integer lowLimit, Integer highLimit, int numberOfValues) {
        ArrayList<Integer> array = new ArrayList<>(numberOfValues);
        Random random = new Random();

        for (int i = 0; i < numberOfValues; i++) {
            array.add(random.nextInt(highLimit - lowLimit) + lowLimit);
        }

        return array;
    }

    /**
     * Метод генерирует массив бинарных деревьев со случайными Integer значениями узлов
     * @param lowLimit нижний порог диапазона значений
     * @param highLimit верхний порог диапазона значений
     * @param numberOfValues количество значений в бинарном дереве
     * @param numberOfTrees количество бинарных деревьев
     * @return массив бинарных деревьев
     */
    public ArrayList<TreeImpl<Integer>> generateTreesArray(Integer lowLimit, Integer highLimit, int numberOfValues, int numberOfTrees) {
        ArrayList<TreeImpl<Integer>> arrayOfTrees = new ArrayList<>();
        for (int i = 0; i < numberOfTrees; i++) {
            arrayOfTrees.add (generateTree (lowLimit, highLimit, numberOfValues));
        }
        return arrayOfTrees;
    }

    /**
     * Метод генерирует бинарное дерево со случайными числами в заданном диапазоне
     * @param lowLimit нижний порог диапазона значений
     * @param highLimit верхний порог диапазона значений
     * @param numberOfValues количество значений в бинарном дереве
     * @return бинарное дерево со случайными сислами
     */
    public TreeImpl<Integer> generateTree(Integer lowLimit, Integer highLimit, int numberOfValues) {
        TreeImpl<Integer> tree = new TreeImpl<>();
        Generator<Integer> generator = new Generator<>();
        ArrayList<Integer> randValArray = generator.genRandomValuesArray(lowLimit, highLimit, numberOfValues);

        for (Integer integer : randValArray) {
            tree.add(integer);
        }

        return tree;
    }
}
