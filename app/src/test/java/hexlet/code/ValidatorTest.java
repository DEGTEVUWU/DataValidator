package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

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
        actual1.setMinRange(3);
        actual1.setMaxRange(6);


        var expected1 = true;
        var expected2 = true;
        var expected3 = 3;
        var expected4 = 6;

        assertThat(actual1.getAllowNull()).isEqualTo(expected1);
        assertThat(actual1.getAllowPositive()).isEqualTo(expected2);
        assertThat(actual1.getMinRange()).isEqualTo(expected3);
        assertThat(actual1.getMaxRange()).isEqualTo(expected4);


    }
}
