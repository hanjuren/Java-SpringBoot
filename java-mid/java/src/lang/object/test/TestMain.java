package lang.object.test;

public class TestMain {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 20);
        Rectangle rectangle2 = new Rectangle(10, 20);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println("identity: " + (rectangle1 == rectangle2));
        System.out.println("equality: " + (rectangle1.equals(rectangle2)));
        System.out.println("equality: " + (rectangle2.equals(rectangle1)));
    }
}
