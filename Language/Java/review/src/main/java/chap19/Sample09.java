package chap19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample09 {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"))) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
