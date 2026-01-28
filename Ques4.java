package SelfStudy2;
//Factory Design Pattern donot expose the code of how to create a object logic to client.

//defining interface which will tell what the object should not how
interface Shape {
    void draw();
}
//Circle has its own implementation
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
//Rectangle has its own implementation
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
//Square has its own implementation
class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

//shapefactory is responsible for creating object without exposing the logic
class ShapeFactory {

    public static Shape getShape(String shapeType) {

        if (shapeType == null)
            return null;

        if (shapeType.equalsIgnoreCase("CIRCLE"))
            return new Circle(); //If i passed the Circle in getshape method then circle object will be created

        else if (shapeType.equalsIgnoreCase("RECTANGLE"))
            return new Rectangle(); //If i pass the rectangle in getshape method the rectangle object will be created

        else if (shapeType.equalsIgnoreCase("SQUARE"))
            return new Square(); //or square will be created if passed square

        return null; //don't create an object if it doesn't matches the String passed
    }
}

public class Ques4 {
    static void main(String[] args) {
        //calling getshape method to create an object of specific type
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = ShapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
