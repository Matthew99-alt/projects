package matvey;

import java.util.LinkedList;

public class ThreadPool {
    private final LinkedList<Runnable> tasks; // + final и будет монитор)
    private boolean isShutdown;
    private final Object monitor = new Object();
    private final int capacity;

    //TODO: В качестве аргументов конструктора пулу передается его емкость (количество рабочих потоков).
    public ThreadPool(LinkedList<Runnable> tasks, boolean shutdown, int capacity) {
        this.tasks = tasks;
        this.isShutdown = shutdown;
        this.capacity = capacity;
        startThreads();
    }

    public void shutdown() {
        synchronized (monitor) {
            isShutdown = true;
            monitor.notifyAll();
        }
    }

    //TODO: тут создаются потоки в цикле, исходя из параметра конструктора
    private void startThreads() {
        for(int i = 0; i<capacity; i++) {
            new Thread(() -> {
                // пересмотреть условие, не просто И - ИЛИ
                // а что ты делаешь? может условие только на… завершение? ожидание?
                // что делать если задач нет, но и пул еще не выключают?
                while (true) {
                    Runnable task;
                    try {
                        task = takeTask();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(task==null){
                        break;
                    }
                    task.run();
                }

                //TODO: почему внутри потока ВАЖНО отлавливать исключение возможное внутри метода run() ?
                // разве это не то же самое что выше?
                // тут ок, вопрос что должно быть выше

            }).start();
        }
    }

    public void execute(Runnable task) {
        synchronized (monitor) {
            if (!isShutdown) {
                tasks.add(task);
                monitor.notify();
            }
            if (isShutdown) {
                throw new IllegalStateException("А всё, опоздали! Больше не принимаем!"); // не молчи Матвей)
            }

            /*
            if (isShutdown) {
                throw new IllegalStateException();
            }

            твой код…
             */
        }
    }

    public Runnable takeTask() throws InterruptedException {
        synchronized (monitor) {
            while (tasks.isEmpty() && !isShutdown) {
                monitor.wait();
            }
            if (!tasks.isEmpty()) {
                return tasks.removeFirst();
            }
        }
        return null;
    }

    public static void main(String[] args) {

        LinkedList<Runnable> tasks = new LinkedList<Runnable>();

        ThreadPool threadPool = new ThreadPool(tasks, false,2);

        threadPool.execute(() -> {
            System.out.println("Робим" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим2" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились2" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим3" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились3" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим4" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились4" + Thread.currentThread().getName());
        });

        threadPool.execute(() -> {
            System.out.println("Робим5" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились5" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим6" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились6" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим7" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились7" + Thread.currentThread().getName());
        });
        threadPool.execute(() -> {
            System.out.println("Робим8" + Thread.currentThread().getName());
            try {
                // Пауза на 2 секунды (2000 миллисекунд)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был прерван");
            }
            ;
            System.out.println("Отробились8" + Thread.currentThread().getName());
        });


        threadPool.shutdown();

        threadPool.execute(() -> System.out.println("Робим5"));

    }
}
