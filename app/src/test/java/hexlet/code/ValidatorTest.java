package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {
    @Test
    void stringMethodTest() {
        Validator v = new Validator();
        StringSchema stringObj = v.string();

        assertThat(stringObj.isValid(null)).isTrue();
        assertThat(stringObj.isValid("")).isTrue();
        assertThat(stringObj.isValid("Some text")).isTrue();

        stringObj.required();

        assertThat(stringObj.isValid(null)).isFalse();
        assertThat(stringObj.isValid("")).isFalse();
        assertThat(stringObj.isValid("Some text")).isTrue();
        assertThat(stringObj.isValid("hexlet")).isTrue();

        stringObj.contains("wh");

        assertThat(stringObj.isValid(null)).isFalse();
        assertThat(stringObj.isValid("")).isFalse();
        assertThat(stringObj.isValid("what does the fox say")).isTrue();

        stringObj.contains("what");

        assertThat(stringObj.isValid("what does the fox say")).isTrue();

        stringObj.contains("whatthe");

        assertThat(stringObj.required().contains("whatthe").isValid("what does the fox say")).isFalse();
    }

    @Test
    void numberMethodTest() {
        Validator v = new Validator();
        NumberSchema numberObj = v.number();

        assertThat(numberObj.isValid(null)).isTrue();
        assertThat(numberObj.isValid(7)).isTrue();

        numberObj.positive();
        assertThat(numberObj.isValid(null)).isTrue();

        numberObj.required();

        assertThat(numberObj.isValid(null)).isFalse();
        assertThat(numberObj.isValid(7)).isTrue();
        assertThat(numberObj.isValid(-7)).isFalse();
        assertThat(numberObj.isValid(0)).isFalse();

        numberObj.range(1, 7);

        assertThat(numberObj.isValid(1)).isTrue();
        assertThat(numberObj.isValid(7)).isTrue();
        assertThat(numberObj.isValid(4)).isTrue();
        assertThat(numberObj.isValid(77)).isFalse();
        assertThat(numberObj.isValid(0)).isFalse();
        assertThat(numberObj.isValid(-7)).isFalse();

    }

    @Test
    void mapMethodTest() {
        Validator v = new Validator();
        MapSchema mapObj = v.map();

        Map emptyMap = new HashMap();
        Map notEmptyMap = new HashMap();
        notEmptyMap.put("key", "value");

        var actual1 = mapObj.isValid(null);
        var actual2 = mapObj.required().isValid(null);
        var actual3 = mapObj.required().isValid(emptyMap);
        var actual4 = mapObj.required().isValid(notEmptyMap);
        var actual5 = mapObj.required().sizeof(1).isValid(emptyMap);
        var actual6 = mapObj.required().sizeof(1).isValid(notEmptyMap);
        var actual7 = mapObj.required().sizeof(2).isValid(notEmptyMap);

        notEmptyMap.put("key2", "value2");

        var actual8 = mapObj.required().sizeof(2).isValid(notEmptyMap);
        var actual9 = mapObj.required().sizeof(1).isValid(notEmptyMap);

        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
        assertThat(actual3).isTrue();
        assertThat(actual4).isTrue();
        assertThat(actual5).isFalse();
        assertThat(actual6).isTrue();
        assertThat(actual7).isFalse();
        assertThat(actual8).isTrue();
        assertThat(actual9).isFalse();
    }

    @Test
    void mapMethodTestWithNestedValidationTesting() {
        Validator v = new Validator();
        MapSchema mapObj = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();

        schemas.put("key", v.string().required());
        schemas.put("key2", v.string().required().minLength(2));

        mapObj.shape(schemas);

        Map<String, String> nestedValidation1 = new HashMap();
        nestedValidation1.put("key", "value");
        nestedValidation1.put("key2", "value2");

        Map<String, String> nestedValidation2 = new HashMap();
        nestedValidation2.put("key", "");
        nestedValidation2.put("key2", "value2");

        Map<String, String> nestedValidation3 = new HashMap();
        nestedValidation3.put("key", "value");
        nestedValidation3.put("key2", "V");

        Map<String, String> nestedValidation4 = new HashMap();
        nestedValidation4.put("key", null);
        nestedValidation4.put("key2", "value2");

        Map<String, String> nestedValidation5 = new HashMap();
        nestedValidation5.put("key", "value");
        nestedValidation5.put("key2", "VA");

        var actual1 = mapObj.isValid(nestedValidation1);
        var actual2 = mapObj.isValid(nestedValidation2);
        var actual3 = mapObj.isValid(nestedValidation3);
        var actual4 = mapObj.isValid(nestedValidation4);
        var actual5 = mapObj.isValid(nestedValidation5);

        assertThat(actual1).isTrue();
        assertThat(actual2).isFalse();
        assertThat(actual3).isFalse();
        assertThat(actual4).isFalse();
        assertThat(actual5).isTrue();

    }

    @Test
    public void testNumberValidator() {
        var v = new Validator();
        var schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.positive();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(0)).isFalse();
        assertThat(schema.isValid(10)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();

        schema.range(6, 9);
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid(10)).isFalse();
    }
}
