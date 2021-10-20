public class Lesson4MainClass {
    public static void main(String[] args) throws MyException {
        LinkedListImpl<Integer> myLinkedList = new LinkedListImpl<>();

        myLinkedList.insertFirst(8);
        myLinkedList.insertFirst(7);
        myLinkedList.insertFirst(6);
        myLinkedList.insertFirst(5);
        myLinkedList.insertFirst(4);
        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(1);

        myLinkedList.display();

        myLinkedList.removeFirst();
        myLinkedList.remove(4);

        myLinkedList.display();

        for (Integer value : myLinkedList) {

            System.out.println("value: " + value);

        }

        LinkedListDequeImpl<Integer> myDeque = new LinkedListDequeImpl<>();

        myDeque.removeFirst();
        myDeque.removeLast();

        myDeque.insertLast(4);
        myDeque.insertLast(5);
        myDeque.insertLast(6);
        myDeque.insertLast(7);
        myDeque.display();
        System.out.println(myDeque.getFirst());
        System.out.println(myDeque.getLast());
        myDeque.removeFirst();
        myDeque.removeLast();

        myDeque.display();

        myDeque.remove(5);
    }
}
