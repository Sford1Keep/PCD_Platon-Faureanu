public class Thread1 extends Thread {

    public Thread1(ThreadGroup group, String name, int priority) {
        super(group, name);
        setPriority(priority);
    }

    public void run() {
        ThreadGroup group = getThreadGroup();
        String path = group.getName();
        while (group.getParent() != null && group.getParent().getParent() != null) {
            group = group.getParent();
            path = group.getName() + " -> " + path;
        }
        Main.show(getName() + "  приоритет " + getPriority() + "  " + path + "\n");
    }
}