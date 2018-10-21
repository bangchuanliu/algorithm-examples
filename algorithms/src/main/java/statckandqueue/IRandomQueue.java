package statckandqueue;

public interface IRandomQueue<Item> {
    public void enQueue(Item item);

    public Item deQueue();

    public Item sample();

    public boolean isEmpty();

    public int size();
}
