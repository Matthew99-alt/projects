package org.example.multithreading1;

import java.util.LinkedList;
import java.util.Objects;

public class Worker implements Runnable {

    private final LinkedList<Runnable> lineOfTasks;

    private final Object monitor1;

    private boolean workFlag;

    public Worker(Object monitor1, LinkedList<Runnable> lineOfTasks, Boolean workFlag) {
        this.lineOfTasks = lineOfTasks;
        this.monitor1 = monitor1;
        this.workFlag = workFlag;
    }
    @Override
    public void run() {
        if (!workFlag){
            throw new IllegalStateException("Pool is already shutdown");
        }
        synchronized (monitor1) {
            if (lineOfTasks.isEmpty()) {
                try {
                    monitor1.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("Worker thread: " + Thread.currentThread().getName() + " - Iteration: " + i) ;
        }
    }
}
