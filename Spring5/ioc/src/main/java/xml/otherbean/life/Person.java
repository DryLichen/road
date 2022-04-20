package xml.otherbean.life;

//演示Bean的生命周期
public class Person {
    private String name;

    public Person(){
        System.out.println("第一步，无参构造器创造实例");
    }
    public void setName(String name) {
        this.name = name;
        System.out.println("第二部，设置属性");
    }

    public void initMethod(){
        System.out.println("第三步 执行初始化的方法");
    }

    public void destroyMethod(){
        System.out.println("第五步 执行销毁的方法");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
