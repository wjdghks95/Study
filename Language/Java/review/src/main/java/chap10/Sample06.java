package chap10;

public class Sample06<T> {
//    클래스명<타입> 인스턴스명 = new 생성자<타입>();
    private T t;

    public T getA() {
        return t;
    }

    public void setA(T t) {
        this.t = t;
    }
}
