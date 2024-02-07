package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var test1 = v.string();
        System.out.println(test1.minLength(5).isValid("ssss"));
    }
}
