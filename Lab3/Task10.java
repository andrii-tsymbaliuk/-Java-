public class Task10 {

    public static void main(String[] args) {
        printResults(-2, 5);
        printResults(4, 4);
        printResults(0, 3);
        printResults(2, -1);
    }

    public static double calculate(double t, int n) {  // Метод для обчислення значення суми
        if (n <= 0) {  // Перевірка чи n додатнє
            throw new IllegalArgumentException("n має бути позитивним. n= " + n);
        }
        double sum = 0;  // Змінна для збереження проміжного результату обчислень
        if (t < 0) {
            for (int i = 1; i <= n; i++) {
                sum += t * t * i;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                sum += Math.sqrt(t) * i;
            }
        }
        return sum;
    }

    private static void printResults(double t, int n) {  // Метод для виведення результатів обчислень або повідомлення про помилку
        System.out.print("t:" + t + " n:" + n + " результат: ");
        try {  // Пробуєм виконати обчислення
            System.out.println(calculate(t, n));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
