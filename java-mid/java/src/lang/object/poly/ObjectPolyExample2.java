package lang.object.poly;

public class ObjectPolyExample2 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object obj = new Object();

        Object[] objectArray = {dog, car, obj};

        size(objectArray);
    }

    private static void size(Object[] objectArray) {
        System.out.println("Size of objectArray: " + objectArray.length);
    }
}
