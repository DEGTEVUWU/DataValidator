package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void stringMethodTest() {
        var actual1 = new Validator().string();
        var actual2 = new Validator().string();
        actual2.setRequired(true);
        actual2.setContainsString("Some text");

        var expected1 = new StringSchema();
        var expected2 = true;
        var expected3 = "Some text";
        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2.isRequired()).isEqualTo(expected2);
        assertThat(actual2.getContainsString()).isEqualTo(expected3);

    }
}