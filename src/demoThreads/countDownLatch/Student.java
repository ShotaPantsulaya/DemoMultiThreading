package demoThreads.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
    private Integer idStudent;
    private List<Task> taskList;
    private CountDownLatch latch;

    public Student(Integer id, int numberTask) {
        this.idStudent = id;
        this.taskList = new ArrayList<Task>(numberTask);
        this.latch = new CountDownLatch(numberTask);
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public Student(List<Task> taskList) {
        this.taskList = taskList;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public boolean addTask(Task task) {
        return taskList.add(task);
    }

    @Override
    public void run() {
        int i = 0;
        for (Task task : taskList) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.setAnswer("Answer #" + ++i);
            System.out.println("Answer #" + i + " from " + idStudent);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float averageMark = 0;
        for (Task task : taskList) {
            averageMark += task.getMark();
        }
        averageMark /= taskList.size();
        System.out.println("Student " + idStudent + ": Average mark =" + averageMark);

    }
}
