package chapter1_2_statckandqueue;

public interface IQueue<Item> extends Iterable<Item>{

    public void enQueue(Item item);

    public Item deQueue();

    public boolean isEmpty();

    public int size();
}
