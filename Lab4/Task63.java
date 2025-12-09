package Lab4;

public class Task63 {
    public static void main(String[] args) {
        int[] result = transform(new int[]{-3, 0, 5, -1, 2});
        // очікуваний результат: [-3+5, 1, 10, -1+5, 4] → [2,1,10,4,4]

        for (int x : result) System.out.print(x + " ");
        System.out.println();

        // Некоректні випадки:
        // transform(null);      // NullPointerException
        // transform(new int[]{}); // IllegalArgumentException
    }

    public static int[] transform(int[] arr) {
        if (arr == null) throw new NullPointerException("Array is null");
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        int max = arr[0];
        for (int x : arr) if (x > max) max = x;

        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (x < 0) newArr[i] = x + max;
            else if (x == 0) newArr[i] = 1;
            else newArr[i] = x * 2;
        }

        return newArr;
    }
}
