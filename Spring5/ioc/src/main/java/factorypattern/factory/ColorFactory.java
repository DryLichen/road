package factorypattern.factory;

import factorypattern.color.Blue;
import factorypattern.color.Color;
import factorypattern.color.Green;
import factorypattern.color.Red;
import factorypattern.shape.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorType) {
        if(colorType == null){
            return null;
        } else if("blue".equalsIgnoreCase(colorType)){
            return new Blue();
        } else if("green".equalsIgnoreCase(colorType)){
            return new Green();
        } else if("red".equalsIgnoreCase(colorType)){
            return new Red();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
