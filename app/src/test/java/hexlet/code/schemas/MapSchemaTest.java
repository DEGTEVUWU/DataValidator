package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
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
