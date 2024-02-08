package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class NumberSchema extends BaseSchema<Integer> {
    private boolean allowNull = false;
    private boolean allowPositive = false;
    private int minRange;
    private int maxRange;

    public NumberSchema required() {
        this.allowNull = true;
        return this;
    }

    public NumberSchema positive() {
        this.allowPositive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
        return this;
    }

    @Override
    public boolean isValid(Integer number) {

        if (allowNull && number == null) {
            return false;
        } else if (allowPositive && number <= 0) {
            return false;
        } else if (number < this.minRange || number > this.maxRange) {
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
        NumberSchema that = (NumberSchema) o;
        return allowNull == that.allowNull && allowPositive == that.allowPositive
                && Objects.equals(minRange, that.minRange) && Objects.equals(maxRange, that.maxRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowNull, allowPositive, minRange, maxRange);
    }

}
