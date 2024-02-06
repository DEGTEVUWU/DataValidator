package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void testMethod() {
        var actual = App.testMethod("Hello!");
        var actual2 = App.testMethod("");

        var expected = "Hello!";
        var expected2 = "";

        assertThat(actual).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected2);

    }
}
