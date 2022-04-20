package factorypattern;

import factorypattern.factory.AbstractFactory;
import factorypattern.factory.FactoryProducer;

public class FactoryTest {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        shapeFactory.getShape("rectangle").draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        colorFactory.getColor("red").fill();
    }
}
