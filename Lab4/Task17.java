package Lab4;


public class Task17 {
    public static void main(String[] args) {
        System.out.println(maxEven(new int[]{2, 5, 8, -4, 7}));     // 8
        System.out.println(maxEven(new int[]{1, 3, 5}));            // exception
        System.out.println(maxEven(new int[]{0, -2, -8, 10}));      // 10

        // Некоректні випадки:
        // maxEven(null);                     // NullPointerException
        // maxEven(new int[]{});              // IllegalArgumentException
    }

    public static int maxEven(int[] arr) {
        if (arr == null) throw new NullPointerException("Array is null");
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        Integer maxEven = null;
        for (int x : arr) {
            if (x % 2 == 0) {
                if (maxEven == null || x > maxEven) {
                    maxEven = x;
                }
            }
        }

        if (maxEven == null)
            throw new IllegalArgumentException("No even elements in array");

        return maxEven;
    }
}
