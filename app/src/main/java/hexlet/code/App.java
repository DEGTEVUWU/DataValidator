package hexlet.code;

import hexlet.code.schemas.NumberSchema;

public class App {
    public static void main(String[] args) {
        var data1 = new NumberSchema();
        System.out.println(data1.isValid(22));
    }
}
