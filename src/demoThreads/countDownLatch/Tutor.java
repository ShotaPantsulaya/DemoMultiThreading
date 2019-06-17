package demoThreads.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tutor extends Thread {
    private Integer idTutor;
    private List<Student> list;

    public Tutor() {
        list = new ArrayList<>();
    }

    public Tutor(List<Student> list) {
        this.list = list;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Integer idTutor) {
        this.idTutor = idTutor;
    }

    @Override
    public void run() {
        for (Student student : list) {
            List<Task> list = student.getTaskList();
            for (Task task : list) {
                int mark = 3 + new Random().nextInt(7);
                task.setMark(mark);
                System.out.println(mark + " for student N " + student.getIdStudent());
                student.getLatch().countDown();
            }
        }
    }
}
