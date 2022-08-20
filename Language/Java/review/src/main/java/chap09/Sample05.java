package chap09;

public class Sample05 {
    public static void main(String[] args) {
        ICompute a= new Apartment();
        float area = a.compute(30);
        System.out.println(area);
    }
}


class Apartment implements ICompute {

    @Override
    public float compute(int area) {
//        pyung++;
        return area * pyung;
    }
}
class Apartment2 implements ICompute {

    @Override
    public float compute(int area) {
//        pyung++;
        return area * pyung;
    }
}
class Apartment3 implements ICompute {

    @Override
    public float compute(int area) {
//        pyung++;
        return area * pyung;
    }
}
interface ICompute {
    float pyung = 3.3f; // static final float pyung = 3.3f;
    float compute(int area);
    default float toPyung(int area) {
        return area / pyung;
    } // 새로운 메서드 추기
}
