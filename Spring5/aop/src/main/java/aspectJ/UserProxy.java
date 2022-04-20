package aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    @Pointcut(value = "execution(* aspectJ.User.user())")
    public void point(){
    }

//    @Before(value = "execution(* aspectJ.User.user())")
    @Before(value = "point()")
    public void before(){
        System.out.println("Before user... ...");
    }

    @AfterReturning(value = "execution(* aspectJ.User.user())")
    public void afterReturning(){
        System.out.println("AfterReturning user... ...");
    }

    @After(value = "execution(* aspectJ.User.user(..))")
    public void after(){
        System.out.println("After user... ...");
    }

    @AfterThrowing(value = "execution(* aspectJ.User.user(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing.........");
    }

    //环绕方法包围所有方法
    @Around(value = "execution(* aspectJ.User.user(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后.........");
    }
}
