package matvey;

import java.util.LinkedList;

public class ThreadPool {
    private LinkedList<Runnable> tasks; // + final и будет монитор)
    private boolean isShutdown;
    private final Object monitor = new Object();

    //TODO: В качестве аргументов конструктора пулу передается его емкость (количество рабочих потоков).
    public ThreadPool(LinkedList<Runnable> tasks, boolean shutdown) {
        this.tasks = tasks;
        this.isShutdown = shutdown;
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
        Thread thread1 = new Thread(() -> {
            // пересмотреть условие, не просто И - ИЛИ
            // а что ты делаешь? может условие только на… завершение? ожидание?
            // что делать если задач нет, но и пул еще не выключают?
            while (!tasks.isEmpty() || !isShutdown) {
                try {
                    this.takeTask().run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            //TODO: почему внутри потока ВАЖНО отлавливать исключение возможное внутри метода run() ?
            // разве это не то же самое что выше?
            // тут ок, вопрос что должно быть выше
            try {
                this.takeTask().run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            while (!tasks.isEmpty() || !isShutdown)
                while (!tasks.isEmpty() || !isShutdown) {
                    try {
                        this.takeTask().run();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            try {
                this.takeTask().run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3 = new Thread(() -> {
            while (!tasks.isEmpty() || !isShutdown) {
                try {
                    this.takeTask().run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                this.takeTask().run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            while (!tasks.isEmpty() || !isShutdown) {
                try {
                    this.takeTask().run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                this.takeTask().run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public void execute(Runnable task) {
        synchronized (monitor) {
            if (!isShutdown) {
                tasks.add(task);
                monitor.notify();
            } else {
                throw new IllegalStateException(); // не молчи Матвей)
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
            if (!isShutdown) {
                while (tasks.isEmpty()) {
                    monitor.wait();
                }
                Runnable takenTask = tasks.getLast();// есть метод сразу с удалением
                tasks.remove(takenTask);
                return takenTask;
            } else {
                while (!tasks.isEmpty()) {
                    Runnable takenTask = tasks.getFirst();
                    tasks.remove(takenTask);
                    return takenTask;
                }
            }
        }
        return () -> {
            System.out.println(Thread.currentThread().getName() + " Работа окончена. Выключаюсь...");
        };
    }

    public static void main(String[] args) {

        LinkedList<Runnable> tasks = new LinkedList<Runnable>();

        ThreadPool threadPool = new ThreadPool(tasks, false);
        ;

//        threadPool.startThreads();

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
