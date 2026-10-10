import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main {

    private static final int SIZE = 100;
    private static final String STUDENTS = "Faureanu Maxim CR-243 Platon Stanislav CR-243";
    private static JTextArea area;

    public static void main(String[] args) throws InterruptedException {
        create();

        int[] mas = new int[SIZE];
        Random rnd = new Random();
        for (int i = 0; i < SIZE; i++) {
            mas[i] = rnd.nextInt(100) + 1;
        }

        String allValues = "mas[] =";
        for (int value : mas) {
            allValues = allValues + String.format("%4d", value);
        }
        show(allValues + "\n");

        Thread th1 = new Thread(new Platon(mas), "Th1");
        Thread th2 = new Thread(new Platon(mas), "Th2");

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        show("\n");
        for (int i = 0; i < STUDENTS.length(); i++) {
            show(String.valueOf(STUDENTS.charAt(i)));
            Thread.sleep(100);
        }
    }

    private static void create() {
        area = new JTextArea();
        area.setEditable(false);

        JFrame frame = new JFrame("PCD, Lab 1 var 9");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(area));
        frame.setSize(750, 550);
        frame.setVisible(true);
    }

    public static void show(final String part) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                area.append(part);
            }
        });
    }
}
