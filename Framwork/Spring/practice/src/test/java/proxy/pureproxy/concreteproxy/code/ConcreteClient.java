package proxy.pureproxy.concreteproxy.code;

/**
 * 프록시 패턴 - 구체 클래스 기반
 * 클라이언트
 */
public class ConcreteClient {

    private ConcreteLogic concreteLogic; //ConcreteLogic, TimeProxy 모두 주입 가능

    public ConcreteClient(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public void execute() {
        concreteLogic.operation();
    }
}
