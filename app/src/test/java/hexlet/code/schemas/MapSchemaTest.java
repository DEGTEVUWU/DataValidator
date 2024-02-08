package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapSchemaTest {
    private final int notAMagicNumberForTests1 = 1;
    private final int notAMagicNumberForTests2 = 2;
    private final int notAMagicNumberForTests3 = 3;
    private final int notAMagicNumberForTest4 = 4;
    private final int notAMagicNumberForTest6 = 6;
    private final Map notAMagicMapForTestNull = null;

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

        actual1.setQuantityPair(notAMagicNumberForTests3);

        var expected1 = new MapSchema();
        expected1.sizeof(notAMagicNumberForTests3);

        assertThat(actual1).isEqualTo(expected1);

    }
    @Test
    void shapeMethodTest() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(notAMagicNumberForTests2));
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
    void shapeMethodTestWithNumberValues() {
        var v = new Validator();
        var schema = v.map();

        Map<Integer, BaseSchema<Integer>> schemas2 = new HashMap<>();
        schemas2.put(notAMagicNumberForTests1, v.number().required());
        schemas2.put(notAMagicNumberForTests2, v.number().required().positive());
        schemas2.put(notAMagicNumberForTests3, v.number().required().positive()
                .range(notAMagicNumberForTests2, notAMagicNumberForTest6));

        schema.shape(schemas2);

        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(notAMagicNumberForTests1, notAMagicNumberForTests1);
        map1.put(notAMagicNumberForTests2, notAMagicNumberForTest6);
        map1.put(notAMagicNumberForTests3, notAMagicNumberForTest4);

        var actual = schema.isValid(map1);

        var expected = true;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void isValidMethodTest() {
        var obj1 = new MapSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid(new HashMap<>());

        var obj2 = new MapSchema();
        obj2.setQuantityPair(notAMagicNumberForTests1);
        var data = new HashMap<>();
        data.put("key", "value");
        var actual2 = obj2.isValid(data);

        var obj3 = new MapSchema();
        var actual3 = obj3.isValid(null);

        var expectedObj1 = new MapSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid(new HashMap<>());

        var expectedObj2 = new MapSchema();
        expectedObj2.sizeof(notAMagicNumberForTests1);
        var dataExpected = new HashMap<>();
        dataExpected.put("key", "value");
        var expected2 = expectedObj2.isValid(dataExpected);

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isTrue();
    }

    @Test
    void isValidMethodTestWithFalseResult() {
        var obj1 = new MapSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid(notAMagicMapForTestNull);

        var obj2 = new MapSchema();
        obj2.setQuantityPair(notAMagicNumberForTests2);
        var data = new HashMap<>();
        data.put("key", "value");
        var actual2 = obj2.isValid(data);

        assertThat(actual1).isFalse();
        assertThat(actual2).isFalse();

    }
}
