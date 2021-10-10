import java.util.List;

public class Sorter {

    /**
     * Данный метод является реализацией пузырьковой сортировки для массива ноутбуков
     * @param listOfNotebooks массив обьектов класса Notebook
     * @return отсортированный массив обьектов класса Notebook
     */
    public List<Notebook> sortArray(List<Notebook> listOfNotebooks) {

        int notebookMinPosition = 0;

        for (int i = 0; i < listOfNotebooks.size() - 1; i++) {

            notebookMinPosition = i;

            for (int j = i + 1; j < listOfNotebooks.size(); j++) {
                if (listOfNotebooks.get(j).compareTo(listOfNotebooks.get(notebookMinPosition)) < 0) {
                    notebookMinPosition = j;
                }
            }

            if (notebookMinPosition == i) {
                continue;
            } else {
                Notebook temp = listOfNotebooks.get(i);
                listOfNotebooks.set(i, listOfNotebooks.get(notebookMinPosition));
                listOfNotebooks.set(notebookMinPosition, temp);
            }
        }
        return listOfNotebooks;
    }
}
