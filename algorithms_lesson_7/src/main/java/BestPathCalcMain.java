public class BestPathCalcMain {
    public static void main(String[] args) {
        int necessarySize = 10;
        GraphImpl graph = new GraphImpl(necessarySize);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Курск");

        graph.addEdge("Москва", "Тула", 20);
        graph.addEdge("Тула", "Липецк", 30);
        graph.addEdge("Липецк", "Воронеж", 30);
        graph.addEdge("Москва", "Рязань", 5);
        graph.addEdge("Рязань", "Тамбов", 10);
        graph.addEdge("Тамбов", "Саратов", 15);
        graph.addEdge("Саратов", "Воронеж", 8);
        graph.addEdge("Москва", "Калуга", 10);
        graph.addEdge("Калуга", "Орёл", 20);
        graph.addEdge("Орёл", "Курск", 20);
        graph.addEdge("Курск", "Воронеж", 15);

        graph.display();

        //graph.dfs("Москва");
        graph.findBestPath("Москва", "Воронеж");
    }
}
