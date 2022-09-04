package chap22;

import java.io.IOException;

public class Sample04 extends Thread{

    private boolean flag = false;
    int i;

    public Sample04(String name){
        super(name);
    }

    public void run(){


        while(!flag){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println( getName() + " end" );

    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }


    public static void main(String[] args) throws IOException {

        Sample04 threadA = new Sample04("A");
        Sample04 threadB = new Sample04("B");
        Sample04 threadC = new Sample04("C");

        threadA.start();
        threadB.start();
        threadC.start();

        int in;
        while(true){
            in = System.in.read();
            if ( in == 'A'){
                threadA.setFlag(true);
            }else if(in == 'B'){
                threadB.setFlag(true);
            }else if( in == 'C'){
                threadC.setFlag(true);
            }else if( in == 'M'){
                threadA.setFlag(true);
                threadB.setFlag(true);
                threadC.setFlag(true);
                break;
            }else{
                System.out.println("type again");
            }
        }

        System.out.println("main end");

    }

}