package chap10;

class Student1<G extends Integer, C extends Integer> {
    G g;
    C c;

    public void printInfo(String name) {
        System.out.printf("%s은(는) %d학년 %d반\n", name, g, c);
    }

    public Student1(G g, C c) {
        this.g = g;
        this.c = c;
    }
}

public class Sample11 {
    public static void main(String[] args) {
        Student1<Integer, Integer> younghee = new Student1<>(1, 4);
        younghee.printInfo("영희");
    }
}
