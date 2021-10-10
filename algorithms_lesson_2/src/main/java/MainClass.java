import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {

        Generator generator = new Generator();
        Sorter sorter = new Sorter();

        ArrayList<Integer> costs = generator.costArrGenerator(50, 500, 2000);
        ArrayList<Integer> ramSizes = generator.ramSizeArrGenerator(4, 4, 24);
        ArrayList<Notebook> resultArray = generator.genArrOfNotebooks(10000, costs, ramSizes);

        System.out.println(resultArray);
        long start = System.currentTimeMillis();;

        List sortedArray = sorter.sortArray(resultArray);

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;

        System.out.println(sortedArray);
        System.out.println("Прошло времени, мс: " + elapsed);
    }
}
