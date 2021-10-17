import java.util.ArrayList;

public class SearchMaster {

    /**
     * Метод выполянет поиск неизвестного числа со сложностью o(n)
     * @param array массив в котором пропущено число
     */
    public static void findLostNumOn(ArrayList<Integer> array) {

        int lostNumber = 0;
        int counter = 0;

        for (int i = 0; i < array.size() - 1; i++) {
            counter++;
            if ((array.get(i + 1) - array.get(i)) != 1) {
                lostNumber = array.get(i) + 1;
                break;
            }
        }
        System.out.println("Пропущенное число: " + lostNumber);
        System.out.println("Число итераций: " + counter);
    }

    /**
     * Метод выполянет поиск неизвестного числа со сложностью o(log(n))
     * @param array массив в котором пропущено число
     */
    public static void findLostNumOLogN(ArrayList<Integer> array) {

        int lostNumber = 0;
        int counter = 0;
        int start = 0;
        int end = array.size() - 1;
        int base;


        while (end >= start) {
            counter++;
            base = (end + start) / 2;

            if ((array.get(base) - base) == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }

        lostNumber = start + 1;
        System.out.println("Пропущенное число: " + lostNumber);
        System.out.println("Число итераций: " + counter);
    }
}