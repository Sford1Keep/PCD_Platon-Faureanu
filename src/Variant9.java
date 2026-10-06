public class Variant9 implements Runnable {

    private final int[] mas;
    private final boolean fromFirstElement;

    public Variant9(int[] mas, boolean fromFirstElement) {
        this.mas = mas;
        this.fromFirstElement = fromFirstElement;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int[] values = new int[mas.length];
        int count = 0;

        if (fromFirstElement) {
            for (int i = 0; i < mas.length; i++) {
                if (i % 2 == 0) {
                    values[count] = mas[i];
                    count++;
                }
            }
        } else {
            for (int i = mas.length - 1; i >= 0; i--) {
                if (i % 2 == 0) {
                    values[count] = mas[i];
                    count++;
                }
            }
        }

        String direction = "первого";
        if (fromFirstElement == false) {
            direction = "последнего";
        }
        System.out.println(name + " | поиск с " + direction + " элемента");

        int previousProduct = 0;
        for (int k = 0; k + 1 < count; k = k + 2) {
            int product = values[k] * values[k + 1];

            String line = name + " | пара " + (k / 2 + 1) + ": " + values[k] + " * " + values[k + 1] + " = " + product;

            if (k == 0) {
                line = line + " разность: это первая пара";
            } else {
                line = line + " разность: " + product + " - " + previousProduct + " = " + (product - previousProduct);
            }

            System.out.println(line);

            previousProduct = product;
        }
    }
}
