package chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample09 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "학건"));
        list.add(new Employee(3, "상도"));
        list.add(new Employee(2, "인호"));
        list.add(new Employee(4, "빵형"));

        System.out.println(list.toString());
        Collections.sort(list);
        System.out.println(list.toString());
    }
}

class Employee implements Comparable<Employee> {
    private int sabun;
    private String name;

    public Employee(int sabun, String name) {
        this.sabun = sabun;
        this.name = name;
    }

    public int getSabun() {
        return sabun;
    }

    public void setSabun(int sabun) {
        this.sabun = sabun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sabun=" + sabun +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
//        return this.sabun - o.sabun; // 순정렬
//        return o.sabun - this.sabun; // 역정렬
        return this.name.compareTo(o.name); // 순정렬
//        return o.name.compareTo(this.name); // 역정렬
    }
}


