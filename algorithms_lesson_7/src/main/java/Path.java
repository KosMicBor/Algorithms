import java.util.ArrayList;

public class Path {
    private int pathLength;
    private final ArrayList<String> pathStops;

    public Path() {
        pathLength = 0;
        pathStops = new ArrayList<>();
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public int getPathLength() {
        return pathLength;
    }

    public ArrayList<String> getPathStops() {
        return pathStops;
    }

    @Override
    public String toString() {
        return "Остановки = " + pathStops + ", Длина пути = " + pathLength;
    }
}
