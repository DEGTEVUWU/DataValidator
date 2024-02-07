package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class StringSchema {
    private boolean required = false;
    private String containsString = "";
    private int length;

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema contains(String chars) {
        this.containsString = chars;
        return this;
    }
    public StringSchema minLength(int length) {
        this.length = length;
        return this;
    }

    public boolean isValid(String str) {
        StringSchema schema = new StringSchema();
        schema.required = this.required;
        schema.containsString = this.containsString;

        if (required && (str == null || str.isEmpty())) {
            return false;
        }
        if (!containsString.isEmpty()) {
            return str.contains(containsString);
        }
        if (str.length() < length) {
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
        return required == that.required && Objects.equals(containsString, that.containsString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(required, containsString);
    }
}
