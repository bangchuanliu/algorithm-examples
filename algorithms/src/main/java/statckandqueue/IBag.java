package statckandqueue;

public interface IBag<Item> extends Iterable<Item>{
    public void add(Item item);

    public boolean isEmpty();

    public int size();
}
