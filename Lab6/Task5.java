package Lab6;

public class Task5 {

    public static void main(String[] args) {
        // Коректні випадки
        System.out.println(binaryStringToInt("10101"));   // 21
        System.out.println(binaryStringToInt("0"));       // 0
        System.out.println(binaryStringToInt("1111"));    // 15

        // Некоректні випадки:
        // binaryStringToInt(null);        // NullPointerException
        // binaryStringToInt("");          // IllegalArgumentException
        // binaryStringToInt("10A01");     // IllegalArgumentException
    }

    public static int binaryStringToInt(String s) {
        if (s == null) throw new NullPointerException("String is null");
        if (s.isEmpty()) throw new IllegalArgumentException("Empty string");

        // Перевірка валідності
        for (char c : s.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Not a binary string: " + s);
            }
        }

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result = result * 2 + (s.charAt(i) - '0');
        }

        return result;
    }
}
