package org.example.multithreading1;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;

import static org.example.multithreading1.demo1.UtilsMultithreading.sleepMs;

/*
Попробуйте реализовать собственный пул потоков.
В качестве аргументов конструктора пулу передается его емкость (количество рабочих потоков).
Как только пул создан, он сразу инициализирует и запускает потоки.
Внутри пула очередь задач на исполнение организуется через LinkedList.
При выполнении у пула потоков метода execute(Runnable), указанная задача должна попасть в очередь исполнения,
и как только появится свободный поток – должна быть выполнена.
Также необходимо реализовать метод shutdown(), после выполнения которого новые задачи больше не принимаются пулом
(при попытке добавить задачу можно бросать IllegalStateException), и все потоки для которых больше нет задач завершают свою работу.
 */
@Getter
@Setter
public class MyCustomThreadPool {
    private LinkedList<Runnable> lineOfTasks;
    private boolean workFlag = true;
    private Integer numberOfThreads;

    private final Object monitor1 = new Object();

    public MyCustomThreadPool(Integer numberOfThreads, LinkedList<Runnable> lineOfTasks){
        this.numberOfThreads = numberOfThreads;
        this.lineOfTasks = lineOfTasks;
        for (int i = 0; i < numberOfThreads; i++) {
            Thread worker = new Thread(new Worker(monitor1, lineOfTasks, workFlag));
            worker.start();
        }
    }
    private void shutdown(){
        workFlag = false;
    }

    private void execute(Runnable task) throws IllegalStateException {
        synchronized (monitor1){
            lineOfTasks.add(task);
            monitor1.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Runnable> tasks = new LinkedList<>(Arrays.asList(new Thread()));
        MyCustomThreadPool myCustomThreadPool = new MyCustomThreadPool(8, tasks);
        myCustomThreadPool.setLineOfTasks(tasks);
        myCustomThreadPool.execute(() -> {
            for (int i = 0; i<tasks.size(); i++)
            {System.out.println("Task"+i); sleepMs(1000);}
        });
        myCustomThreadPool.shutdown();
    }
}