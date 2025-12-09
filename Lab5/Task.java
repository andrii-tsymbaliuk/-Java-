package Lab5;

public class Task {

    public static void main(String[] args) {
        short[] arr1 = {5, -2, 9, 0, 3};
        short[] arr2 = {12, 7, -4, 2, 9};

        System.out.println("Selection sort:");
        short[] sorted1 = selectionSort(arr1.clone());
        printArray(sorted1);

        System.out.println("Insertion sort:");
        short[] sorted2 = insertionSort(arr2.clone());
        printArray(sorted2);
    }

    // ------------------------------
    // Метод 1: Selection Sort
    // ------------------------------
    public static short[] selectionSort(short[] arr) {
        if (arr == null) throw new NullPointerException("Array is null");
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            short temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // ------------------------------
    // Метод 2: Insertion Sort
    // ------------------------------
    public static short[] insertionSort(short[] arr) {
        if (arr == null) throw new NullPointerException("Array is null");
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        for (int i = 1; i < arr.length; i++) {
            short key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }

    // Допоміжний метод
    public static void printArray(short[] arr) {
        for (short x : arr) System.out.print(x + " ");
        System.out.println();
    }
}

