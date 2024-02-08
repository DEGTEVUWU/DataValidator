package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    private static final int notAMagicNumberForTests2 = 2;
    private static final int notAMagicNumberForTests3 = 3;
    private static final int notAMagicNumberForTest6 = 6;

    @Test
    void stringMethodTest() {
        var actual1 = new Validator().string();
        var actual2 = new Validator().string();
        actual2.setAllowNull(true);
        actual2.setContainsString("Some text");

        var expected1 = new StringSchema();
        var expected2 = true;
        var expected3 = "Some text";
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2.isAllowNull()).isEqualTo(expected2);
        assertThat(actual2.getContainsString()).isEqualTo(expected3);

    }
    @Test
    void numberMethodTest() {
        var actual1 = new Validator().number();
        actual1.setAllowNull(true);
        actual1.setAllowPositive(true);
        actual1.setMinRange(notAMagicNumberForTests3);
        actual1.setMaxRange(notAMagicNumberForTest6);


        var expected1 = true;
        var expected2 = true;
        var expected3 = notAMagicNumberForTests3;
        var expected4 = notAMagicNumberForTest6;

        assertThat(actual1.getAllowNull()).isEqualTo(expected1);
        assertThat(actual1.getAllowPositive()).isEqualTo(expected2);
        assertThat(actual1.getMinRange()).isEqualTo(expected3);
        assertThat(actual1.getMaxRange()).isEqualTo(expected4);
    }

    @Test
    void mapMethodTest() {
        var baseSchemaTestObj = new Validator();
        var actual1 = new Validator().map();
        actual1.setAllowNull(true);
        actual1.setAllowShape(true);
        actual1.setQuantityPair(notAMagicNumberForTests3);

        var mapWithSchema = new HashMap<String, BaseSchema<String>>();
        mapWithSchema.put("key1", baseSchemaTestObj.string().required());
        mapWithSchema.put("key2", baseSchemaTestObj.string().required().contains("val"));

        var expected1 = true;
        var expected2 = true;
        var expected3 = notAMagicNumberForTests3;

        assertThat(actual1.isAllowNull()).isEqualTo(expected1);
        assertThat(actual1.isAllowShape()).isEqualTo(expected2);
        assertThat(actual1.getQuantityPair()).isEqualTo(expected3);
    }
    @Test
    void mapMethodTestWithSchemas() {
        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(notAMagicNumberForTests2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");

        var actual1 = schema.isValid(human1);
        var actual2 = schema.isValid(human2);
        var actual3 = schema.isValid(human3);

        var expected1 = true;
        var expected2 = false;
        var expected3 = false;

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);


    }
}
