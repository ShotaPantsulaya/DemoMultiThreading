package demoThreads.daemon;

public class Main {
    public static void main(String[] args) {
        SimpleThread thread1 = new SimpleThread();
        SimpleThread thread2 = new SimpleThread();
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
    }
}
