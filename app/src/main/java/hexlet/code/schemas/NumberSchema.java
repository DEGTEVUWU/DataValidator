package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public final class NumberSchema extends BaseSchema<Integer> {
    private Boolean allowNull = null;
    private Boolean allowPositive = null;
    private int minRange = Integer.MIN_VALUE;
    private int maxRange = Integer.MAX_VALUE;

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
        if (allowNull == null && number == null) {
            return true;
        } else if (allowNull != null && number == null) {
            return false;
        } else if (allowPositive != null && number <= 0) {
            return false;
        } else if (number < this.minRange  || number > this.maxRange) {
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
//some text
