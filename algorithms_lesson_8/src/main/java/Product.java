import java.util.Objects;

public class Product implements Comparable {
    int id;
    String title;

    public Product(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return (String) title;
    }


    @Override
    public int compareTo(Object o) {
        if (this.equals(o)){
            return 0;
        } else {
            return -1;
        }
    }
}
