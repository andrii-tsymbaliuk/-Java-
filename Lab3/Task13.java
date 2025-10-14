public class Task13 {

    public static void main(String[] args) {
        printResults(0.001);
        printResults(0.00001);
        printResults(-0.5);
    }

    public static double calculate(double eps) {  // Метод для обчислення суми ряду з точністю eps (допустимою похибкою)
        if (eps <= 0) {  // Перевірка: eps має бути додатним
            throw new IllegalArgumentException("eps має бути позитивним. Отримав " + eps);
        }
        double sum = 0;  // Змінна для накопичення результату (сума ряду)
        double term;    // Один доданок ряду
        int i = 1;  // Лічильник номера доданку
        while (true) {  // Нескінченний цикл, який перерветься вручну (через break)
            term = Math.pow(-1, i) / factorial(i);  // Обчислюємо доданок ряду:
            if (Math.abs(term) < eps) {   // Якщо абсолютне значення доданка стало менше за eps → досягли потрібної точності
                break;  // Виходимо з циклу
            }
            sum += term;  // Додаємо поточний доданок до суми
            i++;  // Збільшуємо лічильник для наступного доданка
        }
        return sum;
    }

    private static long factorial(int n) {  // Допоміжний метод для обчислення факторіала n! (n факторіал)
        long f = 1;   // Початкове значення факторіала
        for (int i = 2; i <= n; i++) {
            f *= i;  // Множимо послідовно всі числа від 2 до n
        }
        return f;
    }

    private static void printResults(double eps) {  // Метод для виведення результатів обчислень
        System.out.print("eps:" + eps + " результат: ");
        try {
            System.out.println(calculate(eps));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
