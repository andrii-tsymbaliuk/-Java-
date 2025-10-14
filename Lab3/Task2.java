public class Task2 {

    public static void main(String[] args) {
        printResults(-3, 10, 2.0);
        printResults(1, 1, 2.0);
        printResults(1, 30, 2.0);
    }

    public static double calculate(double t, int k, double s) {    // Метод для обчислення математичної суми 
        if (k <= 2 || k > 25) {      // Перевірка для k                                                          
            throw new IllegalArgumentException("Параметр k має бути 2 < k <= 25. k= " + k);
        }
        double sum = 0;  // Накопичення результату суми
        for (int i = 1; i <= k; i++) {    // Цикл від 1 до k на кожній ітерації додається один елемент до суми
            double arg = -t * i;    // Обчислення аргументу для логарифма
            if (arg <= 0) {  // Перевірка чи аргумент логарифма більший за 0
                throw new IllegalArgumentException("Аргумент логарифма має бути > 0. Отримав " + arg);
            }
            sum += Math.log(arg) * Math.cos(Math.sqrt(s * 1.0 / (i * i)));
        }
        return sum; // Повертаємо обчислену суму
    }

    private static void printResults(double t, int k, double s) {     // Метод для виведення результатів 
        System.out.print("t:" + t + " k:" + k + " s:" + s + " результат: ");  // Виводимо параметри
        try {  // Пробуєм виконати обчислення 
            System.out.println(calculate(t, k, s));     // Якщо помилок нема виводиться результат
        } catch (IllegalArgumentException e) {   // Запускаємо цей метод, щоб якщо була помилка програма не завершувалась аварійно
            System.out.println("EXCEPTION! " + e.getMessage());  // Виводить помилку
        }
    }
}
