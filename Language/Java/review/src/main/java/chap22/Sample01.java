package chap22;

class MyThread extends Thread {
    public void run() {
        int i;
        for (i = 1; i <= 200; i++) {
            System.out.print(i + "\t");
        }
    }
}

class RunThread implements Runnable {

    @Override
    public void run() {
        int i;
        for (i = 1; i <= 200; i++) {
            System.out.print(i + "\t");
        }
    }
}

public class Sample01 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + "start");
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();

        System.out.println(Thread.currentThread() + "end");

        RunThread runnable = new RunThread();
        Thread rt1 = new Thread(runnable);
        Thread rt2 = new Thread(runnable);

        System.out.println(Thread.currentThread() + "start");
        rt1.start();
        rt2.start();
        System.out.println(Thread.currentThread() + "end");
    }
}
