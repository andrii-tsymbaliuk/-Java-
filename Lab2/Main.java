public class Main {
    public static void main(String[] args) {
        // Завдання 7
        double a1 = -3.45, b1 = 2.34, c1 = 1.45, d1 = 0.83;
        double y1 = Math.pow(
                4 * Math.cosh(Math.sqrt(Math.abs(a1) / Math.abs(b1))) +
                3 * Math.acos(d1),
                c1
        );
        System.out.println("Завдання 7: y = " + y1);

        // Завдання 17
        double a2 = -1.49, b2 = 23.4, c2 = 1.23, d2 = 2.254;
        double y2 = 2 * Math.sqrt(Math.tan(Math.abs(a2 + c2))) +
                    Math.log(b2) / Math.pow(c2, d2);
        System.out.println("Завдання 17: y = " + y2);

        // Завдання 27
        double a3 = 0.478, b3 = -1.26, c3 = 2.68, d3 = 18.24;
        double y3 = Math.sin(Math.pow(a3, -b3)) +
                    3 * Math.acos(Math.abs(c3) / Math.sqrt(d3));
        System.out.println("Завдання 27: y = " + y3);
    }
}
