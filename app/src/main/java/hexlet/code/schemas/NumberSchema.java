package hexlet.code.schemas;

import hexlet.code.Validator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addCheck(
                "required",
                Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> value != null && ((int) value) > 0
        );
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck(
                "range",
                value -> value != null && ((int) value) >= min && ((int) value <= max)
        );
        return this;
    }

    public static void main(String[] args) {
        var v = new Validator();
        var test = v.number();

        System.out.println(test.range(2, 5).isValid(null));
    }

}
