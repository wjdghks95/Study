package chap21;

import java.io.File;
import java.io.IOException;

public class Sample01 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\wjdgh\\OneDrive\\바탕 화면\\Study\\Language\\Java\\review\\newFile.txt");
        file.createNewFile();

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());

//        file.delete();
    }
}
