package chap14;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Retention(SOURCE)
@Target({TYPE, FIELD, CONSTRUCTOR, METHOD})
public @interface SampleAnnotation1 {
}

@Retention(CLASS)
@interface SampleAnnotation2{}

@Retention(RUNTIME)
@interface SampleAnnotation3{}


@Documented
@Target({TYPE, METHOD})
@interface Transactional {
    String value() default "service";
    boolean ReadOnly() default false;
}

@Documented
@Retention(CLASS)
@Repeatable(AutowiredElement.class)
@interface Autowired {
    String value() default "service";
    String name() default "";
}

@Documented
@Retention(CLASS)
@interface AutowiredElement {
    Autowired[] value();
}