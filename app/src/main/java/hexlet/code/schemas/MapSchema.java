package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
    private boolean allowNull = false;
    private boolean allowShape = false;
    private Integer quantityPair;
    private Map<K, BaseSchema<V>> mapWithShape = new HashMap<>();

    public void required() {
        this.allowNull = true;
    }
    public void sizeof(Integer quantity) {
        this.quantityPair = quantity;
    }

    public void shape(Map<K, V> map) {
        this.allowShape = true;
        mapWithShape.putAll((Map<? extends K, ? extends BaseSchema<V>>) map);
    }
    @Override
    public boolean isValid(Map<K, V> value) {
        if (value == null) {
            return !this.allowNull;
        } else if (quantityPair != null && quantityPair != value.size()) {
            return false;
        } else if (allowShape) {
            for (var pairs : mapWithShape.entrySet()) {
                K key = pairs.getKey();
                V valueForValidation = value.get(key);
                if (!mapWithShape.get(key).isValid(valueForValidation)) {
                    return false;
                }
            }
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
