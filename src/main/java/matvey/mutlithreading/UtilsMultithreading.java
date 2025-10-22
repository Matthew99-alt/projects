package matvey.mutlithreading;

public class UtilsMultithreading {

    public static void sleepMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void sleepSec(long ms) {
        try {
            Thread.sleep(ms * 1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static void printMark(int mark) {
        System.out.printf("%s - %d\n", Thread.currentThread().getName(), mark);
    }
}
