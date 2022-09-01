package chap19;

import java.io.*;
import java.net.Socket;

public class Sample10 {
    public static void main(String[] args) {
        long millisecond = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.zip"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.zip"))) {

            millisecond = System.currentTimeMillis();

            int i;
            while ((i = bis.read()) != 1) {
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(millisecond + " 소요되었습니다.");

        Socket socket = new Socket();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            br.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
