package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class NumberSchema {
    private boolean required = false;
    private boolean positive = false;
    private int minLength;
    private int maxLength;

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        return this;
    }

    public boolean isValid(int number) {
        NumberSchema schema = new NumberSchema();
        schema.required = this.required;
        schema.positive = this.positive;
        schema.minLength = this.minLength;
        schema.maxLength = maxLength;

        if (required || positive) {
            return false;
        }
        if (minLength > number || maxLength < number) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberSchema that = (NumberSchema) o;
        return required == that.required && positive == that.positive && minLength == that.minLength && maxLength == that.maxLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(required, positive, minLength, maxLength);
    }
}
