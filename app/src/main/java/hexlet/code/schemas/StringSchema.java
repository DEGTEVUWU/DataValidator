package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class StringSchema extends BaseSchema<String> {
    private boolean allowNull = false;
    private String containsString = "";
    private int length;

    public StringSchema required() {
        this.allowNull = true;
        return this;
    }

    public StringSchema contains(String chars) {
        this.containsString = chars;
        return this;
    }
    public StringSchema minLength(int minLength) {
        this.length = minLength;
        return this;
    }

    @Override
    public boolean isValid(String str) {
        if (allowNull && (str == null || str.isEmpty())) {
            return false;
        } else if (!containsString.isEmpty() && !str.contains(containsString)) {
            return false;
        } else if (str.length() < length) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringSchema that = (StringSchema) o;
        return allowNull == that.allowNull && Objects.equals(containsString, that.containsString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowNull, containsString);
    }
}
