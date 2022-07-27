package proxy.pureproxy.proxy.code;

/**
 * 프록시 패턴
 * 클라이언트
 */
public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void execute() {
        subject.operation();
    }
}
