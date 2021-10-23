import java.util.ArrayList;

public class Backpack {
    private static final int ZERO_VAL = 0;
    private static final int ONE_VAL = 1;
    private final Double maxWeight;
    private ArrayList<Thing> tempArray;
    private Integer maxPrice = 0;
    private Double summWeight = 0.0;
    private Integer summPrice = 0;
    private ArrayList<Thing> bestSet = new ArrayList<>();

    public Backpack(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    /**
     * Метод определяет самую дорогую комбинацию предметов в комнате,
     * которые можно положить в рюкзак с заданной вместимостью по весу
     * @param thingsInRoomArray список ArrayList предметов в комнате
     */
    public void findBestSet(ArrayList<Thing> thingsInRoomArray) {

        if (thingsInRoomArray.isEmpty()) {
            return;
        }

        summPrice = calcSummPrice(thingsInRoomArray);
        summWeight = calcSummWeight(thingsInRoomArray);

        if (summPrice > maxPrice && summWeight <= maxWeight) {
            bestSet.clear();
            maxPrice = summPrice;
            bestSet.addAll(thingsInRoomArray);
        }

        for (int i = ZERO_VAL; i < thingsInRoomArray.size(); i++) {
            tempArray = new ArrayList<>(thingsInRoomArray);
            tempArray.remove(i);
            findBestSet(tempArray);
        }
    }

    /**
     * Метод отображает отображает лучшее сочетание предметов и их суммарную стоимость
     */
    public void displayBestSet () {
        System.out.println("Самая выгодная комбинация вещей в рукзаке:" + bestSet);
        System.out.println("Стоимость вещей в рюкзаке:" + maxPrice);
    }

    /**
     * Метод высчитывает суммарную стоимость всех предметов в списке
     * @param thingsInRoomArray список ArrayList предметов в комнате
     * @return Integer переменную значение котрой содержит суммарную стоимость предметов в списке
     */
    private Integer calcSummPrice(ArrayList<Thing> thingsInRoomArray) {

        Integer summPrice = 0;

        for (Thing elem : thingsInRoomArray) {
            summPrice += elem.getPrice();
        }

        return summPrice;
    }

    /**
     * Метод высчитывает суммарный вес всех предметов в списке
     * @param thingsInRoomArray список ArrayList предметов в комнате
     * @return Double переменную значение котрой содержит суммарный вес предметов в списке
     */
    private Double calcSummWeight(ArrayList<Thing> thingsInRoomArray) {
        Double summWeight = 0.0;

        for (Thing elem : thingsInRoomArray) {
            summWeight += elem.getWeight();
        }

        return summWeight;
    }
}
