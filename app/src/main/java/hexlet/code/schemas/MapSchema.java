package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public final class MapSchema<K, V> extends BaseSchema<Map<K, V>> {
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
                        return shapeMap.entrySet().stream()
                                .allMatch(entry ->
                                        shapeMap.get(entry.getKey()).isValid(((Map) value).get(entry.getKey())));
                    }
                    return true;

                });
        return this;
    }
}
