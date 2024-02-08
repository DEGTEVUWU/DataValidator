package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapSchemaTest {

    @Test
    void requiredMethodTest() {
        var actual1 = new MapSchema();

        actual1.setAllowNull(true);

        var expected1 = new MapSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);

    }

    @Test
    void sizeofMethodTest() {
        var actual1 = new MapSchema();

        actual1.setQuantityPair(3);

        var expected1 = new MapSchema();
        expected1.sizeof(3);

        assertThat(actual1).isEqualTo(expected1);

    }
    @Test
    void shapeMethodTest() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        var actual1 = schema.isValid(human1);

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        var actual2 = schema.isValid(human2);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        var actual3 = schema.isValid(human3);

        schema.setAllowShape(true);

        var expected1 = true;
        var expected2 = false;
        var expected3 = false;
        var expected4 = true;

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);
        assertThat(schema.isAllowShape()).isEqualTo(expected4);

    }

    @Test
    void isValidMethodTest() {
        var obj1 = new MapSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid(new HashMap<>());

        var obj2 = new MapSchema();
        obj2.setQuantityPair(1);
        var data = new HashMap<>();
        data.put("key", "value");
        var actual2 = obj2.isValid(data);

        var obj3 = new MapSchema();
        var actual3 = obj3.isValid(null);

        var expectedObj1 = new MapSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid(new HashMap<>());

        var expectedObj2 = new MapSchema();
        expectedObj2.sizeof(1);
        var dataExpected = new HashMap<>();
        dataExpected.put("key", "value");
        var expected2 = expectedObj2.isValid(dataExpected);

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isTrue();

    }
}
