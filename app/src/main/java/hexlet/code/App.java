package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var test1 = v.string();
        System.out.println(test1.minLength(5).isValid("ssss"));
        System.out.println("");

        var  test2 = v.number();
        System.out.println(test2.range(3, 6).isValid(4));
    }
}
