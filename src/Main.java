import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Main {

    private static JTextArea area;

    public static void main(String[] args) {
        create();

        ThreadGroup root = Thread.currentThread().getThreadGroup();
        ThreadGroup ge = new ThreadGroup(root, "GE");
        ThreadGroup gh = new ThreadGroup(ge, "GH");
        ThreadGroup gk = new ThreadGroup(root, "GK");

        Thread1[] threads = new Thread1[10];
        threads[0] = new Thread1(root, "Th1", 3);
        threads[1] = new Thread1(root, "Th2", 7);
        threads[2] = new Thread1(ge, "ThA", 3);
        threads[3] = new Thread1(gh, "Tha", 4);
        threads[4] = new Thread1(gh, "Thb", 3);
        threads[5] = new Thread1(gh, "Thc", 2);
        threads[6] = new Thread1(gh, "Thd", 1);
        threads[7] = new Thread1(gk, "Th1", 3);
        threads[8] = new Thread1(gk, "Th2", 6);
        threads[9] = new Thread1(gk, "Th3", 3);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public static void show(final String part) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                area.append(part);
            }
        });
    }

    private static void create() {
        area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JFrame frame = new JFrame("PCD, Lab 2 var 5");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(area));
        frame.setSize(750, 550);
        frame.setVisible(true);
    }
}
