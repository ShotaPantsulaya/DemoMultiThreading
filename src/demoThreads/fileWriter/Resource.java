package demoThreads.fileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Resource {
    private FileWriter writer;

    public Resource(String file) throws IOException {
        writer = new FileWriter(file, true);
    }

    public synchronized void writing(String str, int i) {
        try {
            writer.append(str + i);
            System.out.println(str + i);
            TimeUnit.MILLISECONDS.sleep(((long) (Math.random() * 50)));
            writer.append("->" + i + " ");
            System.out.println("->" + i + " ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void close(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}