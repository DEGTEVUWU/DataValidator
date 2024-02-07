package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var test1 = v.number();
        System.out.println(test1.required().positive().range(2, 5));
        System.out.println(test1.isValid(null));
        System.out.println("");

        var test2 = v.string();
        System.out.println(test2.required().contains("d3").minLength(5).isValid("d323553rfe"));

    }
}
