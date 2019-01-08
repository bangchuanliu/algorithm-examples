package course4.assignment2;

import java.util.List;
import java.util.Objects;

public class Key {
    public List<Integer> list;
    public int v;

    public Key(List<Integer> list, int v) {
        this.list = list;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return v == key.v &&
                Objects.equals(list, key.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, v);
    }
}
