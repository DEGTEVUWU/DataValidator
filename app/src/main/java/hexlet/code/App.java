package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        System.out.println(schema.isValid(human1)); // true

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        System.out.println(schema.isValid(human2)); // false

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        System.out.println(schema.isValid(human3)); // false


        var v2 = new Validator();
        var schema2 = v.map();

        Map<Integer, BaseSchema<Integer>> schemas2 = new HashMap<>();
        schemas2.put(1, v.number().required());
        schemas2.put(2, v.number().required().positive());
        schemas2.put(3, v.number().required().positive().range(2, 6));

        schema2.shape(schemas2);

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.put(2, 33);
        map1.put(3, 4);
        System.out.println(schema2.isValid(map1));
    }
}
