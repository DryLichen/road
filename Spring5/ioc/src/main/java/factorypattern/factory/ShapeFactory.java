package factorypattern.factory;

import factorypattern.color.Color;
import factorypattern.shape.Circle;
import factorypattern.shape.Rectangle;
import factorypattern.shape.Shape;
import factorypattern.shape.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        } else if("Circle".equalsIgnoreCase(shapeType)){
            return new Circle();
        } else if("Rectangle".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        } else if("Square".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
