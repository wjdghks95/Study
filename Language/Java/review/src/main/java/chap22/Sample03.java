package chap22;

public class Sample03 extends Thread {

    int start;
    int end;
    int total;

    public Sample03(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        int i;
        for (i = start; i <= end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) {
        Sample03 jt1 = new Sample03(1, 50);
        Sample03 jt2 = new Sample03(51, 100);

        jt1.start();
        jt2.start();

        try {
            jt1.join();
            jt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int lastTotal = jt1.total + jt2.total;

        System.out.println("jt1.total = " + jt1.total);
        System.out.println("jt2.total = " + jt2.total);

        System.out.println("lastTotal = " + lastTotal);
    }
}
