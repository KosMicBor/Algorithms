public class ArithmeticOperations {
    private static final int ZERO_VAL = 0;
    private static final int ONE_VAL = 1;

    public Integer exponentiation (Integer value, Integer degree){

        if (degree == ZERO_VAL) {
            return ONE_VAL;
        }

        return exponentiation(value, value, degree);
    }

    /**
     * Метод выполняет арифметическую операцию возведения в степень полученного числа
     * @param originalValue изначально полученное число
     * @param value число после операции умножения, полученное путём рекурсивного выполнения функции
     * @param degree степень в которую необходимо возвести число
     * @return
     */
    public Integer exponentiation (Integer originalValue, Integer value, Integer degree){
        Integer resultValue = value;

        if (degree == ONE_VAL) {
            return resultValue;
        }

        if (originalValue < 0 && degree % 2 == 0) {
            resultValue = -originalValue * value;
        } else {
            resultValue = originalValue * value;
        }

        return exponentiation(originalValue, resultValue, degree - ONE_VAL);
    }
}


