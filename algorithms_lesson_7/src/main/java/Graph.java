public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String endLabel, int weight);

    int getSize();

    void dfs(String startLabel);

    void bfs(String startLabel);

    void display();
}
