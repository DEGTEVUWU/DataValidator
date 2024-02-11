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

    public MapSchema required() {
        addCheck(
                "required",
                Objects::nonNull
        );
        return this;
    }
    public MapSchema sizeof(Integer quantity) {
        addCheck(
                "sizeof",
                value -> ((Map) value).size() == quantity
        );
        return this;
    }

    public MapSchema<K, V> shape(Map<K, BaseSchema<V>> shapeMap) {
        addCheck(
                "shape",
                value -> {
                if (Objects.nonNull(value)) {
                    this.mapWithShape = shapeMap;
                    for (var pairs : mapWithShape.entrySet()) {
                        K key = pairs.getKey();
                        if (!mapWithShape.get(key).isValid(((Map) value).get(key))) {
                            return false;
                        }
                    }
                }
                return true;
                }
        );
        return this;

    }
/*
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

 */
}
