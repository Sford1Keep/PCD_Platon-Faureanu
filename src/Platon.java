public class Platon implements Runnable {

    private final int[] mas;

    public Platon(int[] mas) {
        this.mas = mas;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        int[] values = new int[mas.length];
        int count = 0;

        Main.show(name + " поиск с первого элемента\n");

        for (int i = 0; i < mas.length; i++) {
            if (i % 2 == 0) {
                values[count] = mas[i];
                count++;
            }
        }

        int previousProduct = 0;
        for (int k = 0; k + 1 < count; k = k + 2) {
            int product = values[k] * values[k + 1];

            String line = name + " пара " + (k / 2 + 1) + ": " + values[k] + " * " + values[k + 1] + " = " + product;

            if (k == 0) {
                line = line + " разность: это первая пара";
            } else {
                line = line + " разность: " + product + " - " + previousProduct + " = " + (product - previousProduct);
            }

            Main.show(line + "\n");

            previousProduct = product;
        }
    }
}
