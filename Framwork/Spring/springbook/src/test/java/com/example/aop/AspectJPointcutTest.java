package com.example.aop;

import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AspectJPointcutTest {

    @Test
    public void methodSignaturePointcut() throws SecurityException, NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public int com.example.aop.AspectJPointcutTest$Target.minus(int,int) throws java.lang.RuntimeException)");;
//        pointcut.setExpression("execution(int minus(int,int))"); // int 타입의 리턴값, minus라는 메소드 이름, 두 개의 int 파라미터를 가진 모든 메소드를 선정하는 포인트컷 표현식
//        pointcut.setExpression("execution(* minus(int,int))"); // 리턴 타입은 상관없이 minus라는 메소드 이름, 두 개의 int 파라미터를 가진 모든 메소드를 선정하는 포인트컷 표현식
//        pointcut.setExpression("execution(* minus(...))"); // 리턴 타입과 파라미터의 종류, 개수에 상관없이 misnus라는 메소드 이름을 가진 모든 메소드를 선정하는 포인트컷 표현식
//        pointcut.setExpression("execution(* *(...))"); // 리턴 타입, 파라미터, 메소드 이름에 상관없이 모든 메소드 조건을 다 허용하는 포인트컷 표현식


        // Target.minus()
        assertThat(pointcut.getClassFilter().matches(Target.class)
                        && pointcut.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null),
                is(true));

        // Target.plus()
        assertThat(pointcut.getClassFilter().matches(Target.class) &&
                pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null),
                is(false));

        // Bean.method()
        assertThat(pointcut.getClassFilter().matches(Bean.class) &&
                        pointcut.getMethodMatcher().matches(Target.class.getMethod("method"), null),
                is(false));
    }

    @Test
    public void pointcut() throws Exception {
        targetClassPointcutMatches("execution(* hello(..))", true, true, false, false, false, false);
        targetClassPointcutMatches("execution(* hello())", true, false, false, false, false, false);
        targetClassPointcutMatches("execution(* hello(String))", false, true, false, false, false, false);
        targetClassPointcutMatches("execution(* meth*(..))", false, false, false, false, true, true);
        targetClassPointcutMatches("execution(* *(int,int))", false, false, true, true, false, false);
        targetClassPointcutMatches("execution(* *())", true, false, false, false, true, true);
        targetClassPointcutMatches("execution(* com.example.aop.AspectJPointcutTest$Target.*(..))", true, true, true, true, true, false);
        targetClassPointcutMatches("execution(* com.example.aop.*.*(..))", false, false, false, false, false, false);
        targetClassPointcutMatches("execution(* com.example.aop..*.*(..))", true, true, true, true, true, true);
        targetClassPointcutMatches("execution(* com.example..*.*(..))", true, true, true, true, true, true);
        targetClassPointcutMatches("execution(* springbook..*.*(..))", false, false, false, false, false, false);
        targetClassPointcutMatches("execution(* *..Target.*(..))", true, true, true, true, true, false);
        targetClassPointcutMatches("execution(* *..Tar*.*(..))", true, true, true, true, true, false);
        targetClassPointcutMatches("execution(* *..*get.*(..))", true, true, true, true, true, false);
        targetClassPointcutMatches("execution(* *..B*.*(..))", false, false, false, false, false, true);
        targetClassPointcutMatches("execution(* *..TargetInterface.*(..))", true, true, true, true, false, false);
        targetClassPointcutMatches("execution(* *(..) throws Runtime*)", false, false, false, true, false, true);
        targetClassPointcutMatches("execution(int *(..))", false, false, true, true, false, false);
        targetClassPointcutMatches("execution(void *(..))", true, true, false, false, true, true);
    }

    public void targetClassPointcutMatches(String expression, boolean... expected) throws Exception {
        pointcutMatches(expression, expected[0], Target.class, "hello");
        pointcutMatches(expression, expected[1], Target.class, "hello", String.class);
        pointcutMatches(expression, expected[2], Target.class, "plus", int.class, int.class);
        pointcutMatches(expression, expected[3], Target.class, "minus", int.class, int.class);
        pointcutMatches(expression, expected[4], Target.class, "method");
        pointcutMatches(expression, expected[5], Bean.class, "method");
    }

    public void pointcutMatches(String expression, Boolean expected, Class<?> clazz, String methodName, Class<?>... args) throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);

        assertThat(pointcut.getClassFilter().matches(clazz) && pointcut.getMethodMatcher().matches(clazz.getMethod(methodName, args), null), is(expected));
    }

    static class Target implements TargetInterface {

        @Override
        public void hello() {}

        @Override
        public void hello(String a) {}

        @Override
        public int minus(int a, int b) throws RuntimeException {return 0;}

        @Override
        public int plus(int a, int b) {return 0;}

        public void method() {};
    }

    static class Bean {
        public void method() throws RuntimeException {};
    }

    static interface TargetInterface {
        public void hello();
        public void hello(String a);
        public int minus(int a, int b) throws RuntimeException;
        public int plus(int a, int b);
    }
}
