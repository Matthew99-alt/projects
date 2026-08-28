package matvey;

import java.util.LinkedList;

public class ThreadPool {
    private final LinkedList<Runnable> tasks;
    private boolean isShutdown;
    private final int capacity;

    public ThreadPool(int capacity) {
        tasks = new LinkedList<>();
        this.capacity = capacity;
        startThreads();
    }

    public void shutdown() {
        synchronized (tasks) {
            isShutdown = true;
            tasks.notifyAll();
        }
    }

    private void startThreads() {
        for (int i = 0; i < capacity; i++) {
            new Thread(() -> {
                while (true) {
                    Runnable task;
                    synchronized (tasks) {
                        if (tasks.isEmpty() && !isShutdown) {
                            try {
                                tasks.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (tasks.isEmpty() && isShutdown) {
                            return;
                        }

                        task = tasks.removeFirst();

                        try {
                            task.run();
                        } catch (Exception e) {
                            throw new RuntimeException("Ошибка: " + e.getMessage());
                        }
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable task) {
        synchronized (tasks) {
            if (isShutdown) {
                throw new IllegalStateException("А всё, опоздали! Больше не принимаем!");
            }
            tasks.add(task);
            tasks.notify();
        }
    }

    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool(4);

        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName()+" start");
                try {
                    // Пауза на 2 секунды (2000 миллисекунд)
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Поток был прерван");
                }
                System.out.println(Thread.currentThread().getName()+" finish");
            });
        }

        threadPool.shutdown();

        threadPool.execute(() -> System.out.println("Робим5"));

    }
}
