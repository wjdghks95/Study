package chap08.sample16;

public class Sample17 {
    public static void main(String[] args) {
        Student st = new Student("빵형", 21, 1);
        System.out.println(st.toString());
        System.out.println(st);
    }
}

class Student {
    String name;
    int age;
    int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
