public class Notebook implements Comparable<Notebook> {
    private Integer price;
    private Integer memorySize;
    private Manufacturers manufacturer;

    public Notebook(Integer price, Integer memorySize, Manufacturers manufacturer) {
        this.price = price;
        this.memorySize = memorySize;
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMemorySize() {
        return memorySize;
    }

    public Manufacturers getManufacturer() {
        return manufacturer;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memorySize=" + memorySize +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Notebook notebook) {
        int compareResult = price.compareTo(notebook.getPrice());

        if (compareResult == 0) {
            compareResult = Integer.compare(memorySize, notebook.getMemorySize());

            if (compareResult == 0) {
                return manufacturer.compareTo(notebook.manufacturer);
            }
            return compareResult;
        }
        return compareResult;
    }
}
