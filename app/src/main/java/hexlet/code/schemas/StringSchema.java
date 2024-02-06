package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringSchema {
    private boolean required = false;
    private String containsString = "";

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema contains(String chars) {
        this.containsString = chars;
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
        return true;
    }
}
