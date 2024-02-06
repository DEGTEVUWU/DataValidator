package hexlet.code.schemas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSchemaTest {

    @Test
    void requiredMethodTest() {
        var actual1 = new StringSchema();
        actual1.setRequired(true);

        var expected1 = new StringSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void containsMethodTest() {
        var actual1 = new StringSchema();
        actual1.setContainsString("Some text");

        var expected1 = new StringSchema();
        expected1.contains("Some text");

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void isValidMethodTest() {
        var obj1 = new StringSchema();
        obj1.setRequired(true);
        var actual1 = obj1.isValid("Some text");

        var obj2 = new StringSchema();
        obj2.setContainsString("So");
        var actual2 = obj2.isValid("Some text");

        var expectedObj1 = new StringSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid("Some text");

        var expectedObj2 = new StringSchema();
        expectedObj2.contains("So");
        var expected2 = expectedObj2.isValid("Some text");

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);

    }
}