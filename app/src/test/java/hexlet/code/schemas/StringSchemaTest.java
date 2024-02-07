package hexlet.code.schemas;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StringSchemaTest {

    @Test
    void requiredMethodTest() {
        var actual1 = new StringSchema();
        actual1.setAllowNull(true);

        var expected1 = new StringSchema();
        expected1.required();

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void containsMethodTest() {
        var actual1 = new StringSchema();
        actual1.setContainsString("Som");

        var expected1 = new StringSchema();
        expected1.contains("Som");

        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    void isValidMethodTest() {
        var obj1 = new StringSchema();
        obj1.setAllowNull(true);
        var actual1 = obj1.isValid("Some text");

        var obj2 = new StringSchema();
        obj2.setContainsString("So");
        var actual2 = obj2.isValid("Some text");

        var obj3 = new StringSchema();
        obj3.setLength(5);
        var actual3 = obj3.isValid("Some text");

        var expectedObj1 = new StringSchema();
        expectedObj1.required();
        var expected1 = expectedObj1.isValid("Some text");

        var expectedObj2 = new StringSchema();
        expectedObj2.contains("So");
        var expected2 = expectedObj2.isValid("Some text");

        var expectedObj3 = new StringSchema();
        expectedObj3.minLength(5);
        var expected3 = expectedObj3.isValid("Some text");

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);
        assertThat(actual3).isEqualTo(expected3);


    }
}
