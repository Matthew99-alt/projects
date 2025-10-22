package matvey.mutlithreading;

import java.util.LinkedList;


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

public class MyCustomThreadPool {
    private LinkedList<Runnable> tasks = new LinkedList<>();
    private volatile boolean isShutdown = false;
    private Thread[] threads;

    private final Object monitor = new Object();

    public MyCustomThreadPool(Integer numberOfThreads) {
        threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(new Worker(), "CustomWorker-" + i);
            threads[i] = thread;
            thread.start();
        }
    }

    public void shutdown() {
        isShutdown = true;
        synchronized (monitor) {
            monitor.notifyAll();
        }
    }

    public void execute(Runnable task) {
        synchronized (monitor) {
            if (isShutdown) {
                throw new IllegalStateException("ThreadPool is already shutdown");
            }
            tasks.addLast(task);
            monitor.notifyAll();
        }
    }

    private final class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (monitor) {
                    while (tasks.isEmpty() && !isShutdown) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    if (tasks.isEmpty() && isShutdown) {
                        return;
                    }
                    // Тут есть задача гарантированно
                    task = tasks.removeFirst();
                }
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}