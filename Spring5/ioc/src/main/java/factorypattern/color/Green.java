package factorypattern.color;

import factorypattern.color.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
