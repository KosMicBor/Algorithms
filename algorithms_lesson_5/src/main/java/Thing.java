public class Thing {
    private final String name;
    private final Double weight;
    private final Integer price;

    public Thing(String name, Double weight, Integer price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        sb.append(name);
        sb.append(": вес=");
        sb.append(weight);
        sb.append(" кг");
        sb.append(", цена=");
        sb.append(price);
        sb.append(" руб.");
        sb.append(" }");

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getPrice() {
        return price;
    }
}
