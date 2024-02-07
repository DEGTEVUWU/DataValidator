package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class NumberSchemaTest {

    @Test
    void requiredMethodTest() {
        var actual1 = new NumberSchema();

        actual1.setAllowNull(true);

        var expected1 = new NumberSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);

    }

    @Test
    void positiveMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setAllowPositive(true);

        var expected1 = new NumberSchema();
        expected1.positive();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void rangeMethodTest() {
        var actual1 = new NumberSchema();
        actual1.setMinRange(3);
        actual1.setMaxRange(6);

        var expected1 = new NumberSchema();
        expected1.range(3, 6);

        assertThat(actual1.getMinRange()).isEqualTo(expected1.getMinRange());
        assertThat(actual1.getMaxRange()).isEqualTo(expected1.getMaxRange());

    }

    @Test
    void isValidMethodTest() {
        var obj1 = new NumberSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid(12);

        var obj2 = new NumberSchema();
        obj2.setAllowPositive(true);
        var actual2 = obj2.isValid(12);

        var obj3 = new NumberSchema();
        obj3.setMinRange(3);
        obj3.setMaxRange(6);
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
