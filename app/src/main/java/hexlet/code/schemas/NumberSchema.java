package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberSchema {
    private boolean required = false;
    private boolean positive = false;
    private int minLength;
    private int maxLength;

    public NumberSchema required() {

    }

    public NumberSchema positive() {

    }

    public NumberSchema range(int minLength, int maxLength) {

    }

    public boolean isValid(int number) {

    }
}
