package chap10;

class Student<G, C> {
    G g;
    C c;

    public void printInfo(String name) {
        System.out.printf("%s은(는) %d학년 %d반\n", name, g, c);
    }

    public Student(G g, C c) {
        this.g = g;
        this.c = c;
    }
}

public class Sample10 {
    public static void main(String[] args) {
        Student<Integer, Integer> younghee = new Student<>(1, 4);
        younghee.printInfo("영희");
    }
}
