package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public class MapSchema extends BaseSchema<Map<Object, Object>> {
    private boolean allowNull = false;
    private Integer quantityPair;

    public MapSchema required() {
        this.allowNull = true;
        return this;
    }
    public void sizeof(Integer quantity) {
        this.quantityPair = quantity;
    }
    @Override
    public boolean isValid(Map<Object, Object> value) {
        if (value == null) {
            return !this.allowNull;
        }
        if (quantityPair != null && quantityPair != value.size()) {
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
        MapSchema mapSchema = (MapSchema) o;
        return allowNull == mapSchema.allowNull && Objects.equals(quantityPair, mapSchema.quantityPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowNull, quantityPair);
    }
}
