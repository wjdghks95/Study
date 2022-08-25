package chap14;

import java.util.Date;

@SampleAnnotation1
@SampleAnnotation2
@SampleAnnotation3
public class Sample01 {

    private String name;
//    @Autowired(value = {"service", "repository"})
    @Autowired("service")
    @Autowired("repository")
    @Autowired(value = "controller", name = "oracle")
    @Transactional(ReadOnly = true)
    public void test() {

    }

    @Override
    public String toString() {
        return "Sample01{" +
                "name='" + name + '\'' +
                '}';
    }

}

@FunctionalInterface
interface Testff {
    public void run();
//    public void run1();
}