package hexlet.code;

import hexlet.code.schemas.NumberSchema;

public class App {
    public static void main(String[] args) {
      var v = new Validator();
      var test1 = v.number();
        System.out.println(test1.isValid(-2));
    }
}
