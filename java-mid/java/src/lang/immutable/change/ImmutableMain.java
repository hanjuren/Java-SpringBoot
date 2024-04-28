package lang.immutable.change;

public class ImmutableMain {

    public static void main(String[] args) {
        ImmutableObj obj = new ImmutableObj(10);
        ImmutableObj addObj = obj.add(20);

        System.out.println("obj = " + obj);
        System.out.println("addObj = " + addObj);
    }
}
