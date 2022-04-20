package JDK;

import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        // 1.生成目标类对象
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        // 2.获取目标对象的接口
        Class[] interfaces = userDaoImpl.getClass().getInterfaces();

        // 3.得到代理类对象，它与被代理类实现同一接口 UserDao
        UserDao proxy = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDaoImpl));

        // 4.此时调用代理对象的任何方法，都会跳转到InvocationHandler的invoke方法
        int sum = proxy.add(2, 3);
        String id = proxy.update("玉蝴蝶");
        System.out.println("sum: " + sum + " ; id: " + id);
    }
}
