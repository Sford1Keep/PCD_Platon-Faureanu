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

        StringBuilder allValues = new StringBuilder("mas[] =\n");
        for (int i = 0; i < mas.length; i++) {
            allValues.append(String.format("%4d", mas[i]));
            if ((i + 1) % 10 == 0) {
                allValues.append('\n');
            }
        }
        show(allValues.toString());

        Faureanu task1 = new Faureanu(mas, 0);
        Faureanu task2 = new Faureanu(mas, 1);
        Thread th1 = new Thread(task1, "Th1");
        Thread th2 = new Thread(task2, "Th2");
        Thread th3 = new Thread(new Platon(mas),"TH3");
        Thread th4 = new Thread(new Platon(mas),"TH4");

        show("Вычисления четырёх потоков:\n");
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th1.join();
        th2.join();
        th3.join();
        th4.join();

        show("\n");
        for (int i = 0; i < STUDENTS.length(); i++) {
            show(String.valueOf(STUDENTS.charAt(i)));
            Thread.sleep(100);
        }
    }

    private static void create() {
        area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

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
