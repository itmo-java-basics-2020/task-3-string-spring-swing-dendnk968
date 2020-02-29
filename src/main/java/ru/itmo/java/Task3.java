package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return new int[0];
        int t = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 2; i >= 0; i--)
            inputArray[i + 1] = inputArray[i];
        inputArray[0] = t;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) return 0;
        if (inputArray.length == 1) return inputArray[0];
        Arrays.sort(inputArray);
        return Math.max(inputArray[0] * inputArray[1],
                inputArray[inputArray.length - 1] * inputArray[inputArray.length - 2]);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) return 0;
        input = input.toLowerCase();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b')
                count++;
        }
        return (count * 100) / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.length() == 0) return false;
        int i = 0;
        int j = input.length() - 1;
        while (i < j)
            if (input.charAt(i++) != input.charAt(j--))
                return false;
        return true;

    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            int j = i;
            while (j < input.length() && input.charAt(i) == input.charAt(j)) j++;
            stringBuilder.append(input.charAt(i));
            stringBuilder.append(j - i);
            i = j;
        }
        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.equals("") || two.equals("") || one.length() != two.length())
            return false;
        int ch[] = new int[256];
        for (int i = 0; i < one.length(); i++)
            ch[one.charAt(i)]++;
        for (int i = 0; i < two.length(); i++)
            if (ch[two.charAt(i)]-- == 0)
                return false;
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) return false;
        int ch[] = new int[256];
        for (int i = 0; i < s.length(); i++)
            if(ch[s.charAt(i)]++ != 0)
                return false;
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0)
            return new int[2][0];
        for(int i = 0; i < m.length; i++){
            for (int j = i; j < m.length; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null)
            return "";
        if(separator == null)
            separator = ' ';
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputStrings.length; i++) {
            stringBuilder.append(inputStrings[i]);
            if (inputStrings.length != i + 1) stringBuilder.append(separator);
        }
        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;

        int count = 0;
        for (String s :
                inputStrings) {
            if(s.startsWith(prefix)) count++;
        }
        return count;
    }
}
