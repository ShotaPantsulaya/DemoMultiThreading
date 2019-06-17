package demoThreads.countDownLatch;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_TASKS = 5;
        Student student1 = new Student(3242, NUMBER_TASKS);
        for (int i = 0; i < NUMBER_TASKS; i++) {
            Task t = new Task("Task#" + i);
            student1.addTask(t);
        }
        final int NUMBER_TASKS_2 = 4;
        Student student2 = new Student(2135, NUMBER_TASKS_2);
        for (int i = 0; i < NUMBER_TASKS_2; i++) {
            Task t = new Task("Task #" + i);
            student2.addTask(t);
        }
        ArrayList<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        Tutor tutor = new Tutor(list);
        student1.start();
        student2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tutor.start();
    }
}
