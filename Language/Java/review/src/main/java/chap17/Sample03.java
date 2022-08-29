package chap17;

import java.util.Arrays;
import java.util.stream.Stream;

public class Sample03 {
    public static void main(String[] args) {
        DataObj[] data = {
                new DataObj(1, "빵형"),
                new DataObj(2, "상도"),
                new DataObj(3, "타노스"),
        };

        Stream<DataObj> stm = Arrays.stream(data);

        stm.forEach(System.out::println);
        System.out.println("====");
        Arrays.stream(data).forEach(System.out::print);
    }
}

class DataObj {
    int no;
    String name;

    public DataObj(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataObj{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}