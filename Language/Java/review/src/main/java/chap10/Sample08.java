package chap10;

// 컴퓨터 내장 부품 대상 객체
class ComputerPart {

}

// 그래픽 카드
class Graphics extends ComputerPart {}

// 메모리
class Memory extends ComputerPart {}

// 모니터
class Monitor {
    Computer<Memory> me = new Computer<>();
}

class Computer<T extends ComputerPart> {
    private T component;

    public void toInfo() {
        System.out.println(component.getClass().getName());
    }

    public Computer(T component) {
        this.component = component;
    }

    public Computer() {}

    public void setComponent(T component) {
        this.component = component;
    }
}

public class Sample08 {
    public static void main(String[] args) {
        Computer<ComputerPart> vga = new Computer<>();
        vga.setComponent(new Graphics());
//        vga.setComponent(new Monitor());
        vga.toInfo();

        Computer<ComputerPart> mem = new Computer<>(new Memory());
        mem.toInfo();
    }
}
