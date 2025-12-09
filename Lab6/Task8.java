package Lab6;

public class Task8 {

    public static void main(String[] args) {
        String s = "The user with the nickname koala757677 this month wrote 3 times more comments "
                 + "than the user with the nickname croco181dile920 4 months ago";

        System.out.println(countNumbers(s));   // 2

        // Некоректні випадки:
        // countNumbers(null);    // NullPointerException
        // countNumbers("");      // IllegalArgumentException
    }

    public static int countNumbers(String s) {
        if (s == null) throw new NullPointerException("String is null");
        if (s.trim().isEmpty()) throw new IllegalArgumentException("Empty string");

        String[] parts = s.split("\\s+");
        int count = 0;

        for (String part : parts) {
            if (part.matches("[0-9]+")) {
                count++;
            }
        }

        return count;
    }
}
