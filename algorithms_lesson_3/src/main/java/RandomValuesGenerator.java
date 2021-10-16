import java.util.ArrayList;
import java.util.Random;

public class RandomValuesGenerator {

    /**
     * Метод генерирует массив упорядоченных чисел с заданным размером
     * @param arrSize размер массива
     * @return массив упорядоченных чисел размера arrSize
     */
    public ArrayList<Integer> createIntArr(int arrSize) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 1; i <= arrSize; ++i) {
            array.add(i);
        }

        return array;
    }

    /**
     * Метод удаляет случайный элемент из полученного массива
     * @param array массив чисел типа Integer
     * @return массив типа Integer со 1 случайно удаленым элементом
     */
    public ArrayList<Integer> removeRandomElement(ArrayList<Integer> array){
        ArrayList<Integer> changedArray = new ArrayList<>(array);
        Random rand = new Random();
        int randomArrElement = rand.nextInt(changedArray.size() - 1);
        changedArray.remove(randomArrElement);
        return changedArray;
    }
}
