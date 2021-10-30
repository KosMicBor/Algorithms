import java.util.Objects;

public class Vertex {

    private final String label;

    private boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
    }


    public String getLabel() {
        return label;
    }

    public void setVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean getVisited() {
        return wasVisited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return label;
    }
}
