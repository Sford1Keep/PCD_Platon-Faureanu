import java.util.Random;

public class Main {

    private static final int SIZE = 100;
    private static final String STUDENTS =
            "Faureanu Maxim Platon Stanislav";

    public static void main(String[] args) throws InterruptedException {
        int[] mas = new int[SIZE];
        Random rnd = new Random();
        for (int i = 0; i < SIZE; i++) {
            mas[i] = rnd.nextInt(100) + 1;
        }

        System.out.print("mas[] = ");
        for (int value : mas) {
            System.out.printf("%4d", value);
        }
        System.out.println();
        System.out.println();

        Thread th1 = new Thread(new Variant9(mas, true), "Th1");
        Thread th2 = new Thread(new Variant9(mas, false), "Th2");

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println();
        for (int i = 0; i < STUDENTS.length(); i++) {
            System.out.print(STUDENTS.charAt(i));
            Thread.sleep(100);
        }
        System.out.println();
    }
}
