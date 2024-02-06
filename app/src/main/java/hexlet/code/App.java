package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello!");

        System.out.println("");

        var v = new Validator();
        var schema = v.string();

        System.out.println(schema.isValid(""));
        System.out.println(schema.isValid(null));
        schema.required();
        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid(""));
/*
        System.out.println("");
        System.out.println(schema.isValid("Hello!"));
        System.out.println(schema.contains("He!!"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));
        System.out.println(schema.isValid("what does the fox say"));
        System.out.println("");


 */
        System.out.println("");

        System.out.println(schema.contains("wh").isValid("what does the fox say")); // true
        System.out.println(schema.contains("what").isValid("what does the fox say")); // true
        System.out.println(schema.contains("whatthe").isValid("what does the fox say")); // false
        System.out.println(schema.isValid("what does the fox say"));
        System.out.println(schema.contains("wh").isValid("what"));

    }
    public static String testMethod(String test) {
        return test;
    }
}
