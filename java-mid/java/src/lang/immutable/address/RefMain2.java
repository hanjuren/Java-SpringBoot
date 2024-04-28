package lang.immutable.address;

public class RefMain2 {

    public static void main(String[] args) {
        ImmutableAddress address1 = new ImmutableAddress("서울");
        ImmutableAddress address2 = address1; // 참조값 대입을 막을 수 있는 방법은 없다. 자바 문법상 오류가 아님.

        System.out.println("address1 = " + address1);
        System.out.println("address2 = " + address2);

//        address2.setValue("부산");
        address2 = new ImmutableAddress("부산");
        System.out.println("address1 = " + address1);
        System.out.println("address2 = " + address2);
    }
}
