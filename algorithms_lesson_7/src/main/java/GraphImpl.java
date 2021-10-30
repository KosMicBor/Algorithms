import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int maxVertexCount;
    private final int[][] adjMatrix;

    private int edgeCounter;
    private int stopsCounter;
    private int pathLength = 0;
    private ArrayList<Path> pathsArray = new ArrayList<>();

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.maxVertexCount = maxVertexCount;
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String endLabel, int weight) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        edgeCounter++;
        return true;
    }

    private int indexOf(String label) {

        for (int i = 0; i < vertexList.size(); i++) {

            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    /**
     * Метод обхода графа в глубину
     *
     * @param startLabel значение начальной вершины
     */
    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("введено неверное значение вершины: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        vertexVisited(stack, vertex);

        while (!stack.isEmpty()) {

            vertex = getNearUnvisitedVertex(stack.peek());

            if (vertex != null) {
                vertexVisited(stack, vertex);
            } else {
                stack.pop();
            }
        }

        System.out.println();
    }

    /**
     * Метод определяет наилучший путь от пунка "А" в пункт "В" при обходе дерева в глубину
     * @param startLabel начальный пункт
     * @param endLabel конечный пункт
     */
    public void findBestPath(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);

        int indexOfEndPoint = indexOf(endLabel);

        Path path = new Path();

        if (startIndex == -1) {
            throw new IllegalArgumentException("введено неверное значение вершины: " + startLabel);
        }

        if (stopsCounter == edgeCounter) {
            int minPathLength = 0;
            Path bestPath = new Path();

            for (Path pathElem : pathsArray) {
                if (pathElem.getPathLength() >= minPathLength) {
                    bestPath = pathElem;
                }
            }

            System.out.println("Самый короткий путь: " + bestPath);

            return;
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        vertexList.get(indexOfEndPoint).setVisited(false);
        vertexVisited(stack, vertex);
        path.getPathStops().add(vertex.getLabel());

        while (!stack.isEmpty()) {
            stopsCounter++;
            pathLength += getEdgeWeight(vertex, getNearUnvisitedVertex(stack.peek()));
            vertex = getNearUnvisitedVertex(stack.peek());

            if (vertex != null) {
                vertexVisited(stack, vertex);
                path.getPathStops().add(vertex.getLabel());
                if (vertex.getLabel().equals(endLabel)) {
                    path.setPathLength(pathLength);
                    pathsArray.add(path);
                    pathLength = 0;
                    break;
                }
            } else {
                stack.pop();
            }
        }
        System.out.println();
        findBestPath(startLabel, endLabel);

        System.out.println();
    }

    /**
     * Метод определяет вес грани графа между заданными вершинами
     * @param vertex начальная вершина
     * @param nearUnvisitedVertex ближайшая вершина
     * @return вес грани
     */
    private int getEdgeWeight(Vertex vertex, Vertex nearUnvisitedVertex) {

        if (nearUnvisitedVertex != null && vertex != null) {
            return adjMatrix[indexOf(vertex.getLabel())][indexOf(nearUnvisitedVertex.getLabel())];
        }

        return 0;
    }

    /**
     * Метод обхода граф в ширину
     * @param startLabel значение начальной вершины
     */
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("введено неверное значение вершины: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        vertexVisited(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                vertexVisited(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {

            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).getVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void vertexVisited(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void vertexVisited(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));

            for (int j = 0; j < getSize(); j++) {

                if (adjMatrix[i][j] != 0) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }
}
