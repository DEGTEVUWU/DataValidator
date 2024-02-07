package hexlet.code.schemas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSchemaTest {

    @Test
    void requiredMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setRequired(true);

        var expected1 = new NumberSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void positiveMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setPositive(true);

        var expected1 = new NumberSchema();
        expected1.positive();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void rangeMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setMinLength(3);
        actual1.setMaxLength(6);

        var expected1 = new NumberSchema();
        expected1.range(3, 6);

        assertThat(actual1.getMinLength()).isEqualTo(expected1.getMinLength());
        assertThat(actual1.getMaxLength()).isEqualTo(expected1.getMaxLength());

    }

    @Test
    void isValidMethodTest() {
        var obj1 = new NumberSchema();
        obj1.setRequired(true);
        var actual1 = obj1.isValid(12);

        var obj2 = new NumberSchema();
        obj2.setPositive(true);
        var actual2 = obj2.isValid(12);

        var obj3 = new NumberSchema();
        obj3.setMinLength(3);
        obj3.setMaxLength(6);
        var actual3 = obj3.isValid(5);

        var expectedObj1 = new NumberSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid(12);

        var expectedObj2 = new NumberSchema();
        expectedObj2.positive();
        var expected2 = expectedObj2.isValid(12);

        var expectedObj3 = new NumberSchema();
        expectedObj3.range(3, 6);
        var expected3 = expectedObj3.isValid(5);


        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);

    }
}