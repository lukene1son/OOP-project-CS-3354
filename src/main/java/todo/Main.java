package todo;

public class Main {
    public static void main(String[] args) {
        TaskManager m = new TaskManager();
        new TaskGUI(m);
    }
}
