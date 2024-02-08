package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        var v2 = new Validator();
        var schema2 = v2.map();

        Map<Integer, BaseSchema<Integer>> schemas2 = new HashMap<>();
        schemas2.put(1, v2.number().required());
        schemas2.put(2, v2.number().required().positive());
        schemas2.put(3, v2.number().required().positive().range(2, 6));

        schema2.shape(schemas2);

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.put(2, 33);
        map1.put(3, 4);
        System.out.println(schema2.isValid(map1));
    }
}
