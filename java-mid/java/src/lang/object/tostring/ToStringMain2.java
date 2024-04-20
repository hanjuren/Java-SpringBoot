package lang.object.tostring;

public class ToStringMain2 {

    public static void main(String[] args) {
        Car car = new Car("Toyota");
        Dog dog = new Dog("Buddy", 5);

        System.out.println("car = " + car);
        System.out.println("dog = " + dog);

        ObjectPrinter.print(car);
        ObjectPrinter.print(dog);
    }
}
