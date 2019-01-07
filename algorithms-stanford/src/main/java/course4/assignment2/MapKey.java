package course4.assignment2;

import java.util.List;
import java.util.Objects;

public class MapKey {
    public List<Integer> list;
    public int v;

    public MapKey(List<Integer> list, int v) {
        this.list = list;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapKey mapKey = (MapKey) o;
        return v == mapKey.v &&
                Objects.equals(list, mapKey.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, v);
    }
}
