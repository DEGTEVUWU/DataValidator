package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class NumberSchema extends BaseSchema<Integer> {
    private boolean allowNull = false;
    private boolean allowPositive = false;
    private Integer minRange = null;
    private Integer maxRange = null;

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
        if (number == null) {
            return !this.allowNull;
        }
        if (this.allowPositive && number <= 0) {
            return false;
        }
        if (this.minRange != null && number < this.minRange) {
            return false;
        }
        if (this.maxRange != null && number > this.maxRange) {
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
