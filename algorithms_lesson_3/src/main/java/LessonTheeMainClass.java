import java.util.ArrayList;

public class LessonTheeMainClass {
    public static void main(String[] args) {
        RandomValuesGenerator randomValuesGenerator = new RandomValuesGenerator();
        ArrayList<Integer> basicArray = randomValuesGenerator.createIntArr(10);
        ArrayList<Integer> changedArray = randomValuesGenerator.removeRandomElement(basicArray);


        System.out.println(basicArray);
        System.out.println(changedArray);

        SearchMaster.findLostNumOn(changedArray);
        SearchMaster.findLostNumOLogN(changedArray);

        DequeImpl<Integer> deque = new DequeImpl<>(10);

        deque.insertRight(1);
        deque.insertRight(2);
        deque.display();
        deque.insertRight(3);
        deque.insertRight(4);
        deque.display();
        deque.insertRight(5);
        deque.insertRight(6);
        deque.display();
        deque.insertLeft(0);
        deque.display();
        deque.removeLeft();
        deque.display();
        deque.removeLeft();
        deque.display();
        deque.removeRight();
        deque.display();
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
    }
}
