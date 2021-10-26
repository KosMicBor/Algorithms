import java.util.ArrayList;

public class LessonSixMainClass {
    public static void main(String[] args) throws MyException {
        Generator<Integer> generator = new Generator<>();
        int treesQuantity = 20;
        double treesIsBalanced = 0.0;
        ArrayList<TreeImpl<Integer>> arrayOfTrees = generator.generateTreesArray(-25, 25, 14, treesQuantity);

        for (TreeImpl<Integer> elem : arrayOfTrees) {
            elem.display();
            if (isBalanced(elem.getRoot())) {
                System.out.println("Дерево сбалансированно");
                treesIsBalanced++;
            } else {
                System.out.println("Дерево не сбалансированно");
            }
            System.out.println();
        }

        countPercentOfBalancedTrees(treesIsBalanced, treesQuantity);
    }

    private static void countPercentOfBalancedTrees(double treesIsBalanced, int treesQuantity) {
        double percentOfBalancedTrees = (treesIsBalanced / treesQuantity) * 100;
        System.out.println("Процент сбалансированных деревьев: " + percentOfBalancedTrees);
    }

    public static boolean isBalanced(Node<Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node<Integer> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
