package Lab4;

public class Task47 {
    public static void main(String[] args) {
        System.out.println(maxIndex6(new int[]{5,3,7,1,9,2,11,4}));   // index 6 → value 11
        System.out.println(maxIndex6(new int[]{10,20,30,40,50,60,70})); // 70

        // Некоректні випадки:
        // maxIndex6(null);                         // NullPointerException
        // maxIndex6(new int[]{});                  // IllegalArgumentException
        // maxIndex6(new int[]{1,2,3,4,5});         // IndexOutOfBoundsException (немає індексу 6)
    }

    public static int maxIndex6(int[] arr) {
        if (arr == null) throw new NullPointerException("Array is null");
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        if (arr.length <= 6)
            throw new IndexOutOfBoundsException("Array has no index divisible by 6");

        int max = arr[0];
        for (int i = 0; i < arr.length; i += 6) {
            if (i % 6 == 0) {
                if (i >= arr.length)
                    break;
                if (arr[i] > max) max = arr[i];
            }
        }
        return max;
    }
}
