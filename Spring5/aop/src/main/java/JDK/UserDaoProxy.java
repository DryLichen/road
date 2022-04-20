package JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UserDaoProxy implements InvocationHandler {
    private Object target;

    public UserDaoProxy(Object o){
        target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(("Are You Ready?"));
        System.out.println(method.getName() + "被执行，传入参数为：" + Arrays.toString(args));

        //被代理方法
        Object result = method.invoke(target, args);

        System.out.println("The End... ...");
        //返回被代理方法执行结果
        return result;
    }
}
