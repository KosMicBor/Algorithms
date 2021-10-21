import java.util.ArrayList;

public class LessonFiveMainClass {
    public static void main(String[] args) {
        // 1. Написать программу по возведению числа в степень с помощью рекурсии.
        ArithmeticOperations operations = new ArithmeticOperations();
        Integer value = -3;
        Integer degree = 5;
        Integer expValue = operations.exponentiation(value, degree);
        displayResult(value, degree, expValue);

        // 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
        Generator generator = new Generator();
        ArrayList<Thing> thingsInRoomArray = generator.createThingsArray();
        Backpack backpack = new Backpack(3.0);
        backpack.findBestSet(thingsInRoomArray);
        backpack.displayBestSet();
    }

    private static void displayResult (Integer originalValue, Integer degree, Integer expValue) {
        StringBuilder sb = new StringBuilder();
            sb.append("\n");
            sb.append("Число ");
            sb.append(originalValue);
            sb.append(" в степени ");
            sb.append(degree);
            sb.append(" будет равно: ");
            sb.append(expValue);
        System.out.println(sb);
    }


}
