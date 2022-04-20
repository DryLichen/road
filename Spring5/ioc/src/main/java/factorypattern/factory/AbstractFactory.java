package factorypattern.factory;

import factorypattern.color.Color;
import factorypattern.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
