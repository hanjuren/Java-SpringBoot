package lang.object.poly;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Car car = new Car();
        Dog dog = new Dog();

        action(car);
        action(dog);
    }

    public static void action(Object obj) {
        // obj.sound() // Compile Error
        // obj.move() // Compile Error

        // down casting
        if (obj instanceof Car car) {
            car.move();
        } else if (obj instanceof Dog dog) {
            dog.sound();
        } else {
            System.out.println("지원하지 않는 객체입니다.");
        }
    }
}
