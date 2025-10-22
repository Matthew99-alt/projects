package matvey.mutlithreading;

import static matvey.mutlithreading.UtilsMultithreading.printMark;
import static matvey.mutlithreading.UtilsMultithreading.sleepMs;

public class MainMuti {

    public static void main(String[] args) throws InterruptedException {
        MyCustomThreadPool myCustomThreadPool = new MyCustomThreadPool(4);
        for (int i = 0; i < 5; i++) {
            int current = i;
            myCustomThreadPool.execute(() -> {
                printMark(current);
                sleepMs(1000);

            });
        }

        Thread.sleep(5000);


        for (int i = 0; i < 15; i++) {
            int current = i;
            myCustomThreadPool.execute(() -> {
                printMark(current);
                sleepMs(1000);

            });
        }
        myCustomThreadPool.shutdown();
    }
}
