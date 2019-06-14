package demoThreads.commonResourceMethod;

public class Main {

    public static void main(String[] args) {
        Common com = new Common();
        for (int i = 1; i < 6; i++) {
            Thread t = new Thread(new CountThread(com), String.valueOf(i));
            t.start();
        }
    }
}
