package tag.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

	private Map<K, Node<K, V>> cache;
	private Node<K, V> head;
	private Node<K, V> tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>(capacity);
		head = new Node<>();
		tail = new Node<>();
		head.next = tail;
		tail.pre = head;
	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			Node<K,V> node = cache.get(key);
			removeNode(node);
			addNode(node);

			return node.value;
		}

		return null;
	}

	public void removeNode(Node node) {
		Node pre = node.pre;
		Node next = node.next;

		pre.next = next;
		next.pre = pre;
	}

	public void addNode(Node node) {
		node.next = head.next;
		node.pre = head;

		head.next = node;
		node.next.pre = node;
	}

	public Node removeTail() {
		Node node = tail.pre;

		node.pre.next = tail;
		tail.pre = node.pre;

		return node;
	}

	public void put(K key, V value) {
		if (cache.containsKey(key)) {
			Node<K,V> node = cache.get(key);
			node.value = value;
			cache.put(key, node);
			removeNode(node);
			addNode(node);
		}else{
			if (capacity == cache.size()) {
				Node node = removeTail();
				cache.remove(node.key);
			}
			Node node = new Node(key, value);
			cache.put(key, node);
			addNode(node);
		}
	}

	class Node<KEY, VAL> {
		KEY key;
		VAL value;
		Node<KEY, VAL> pre;
		Node<KEY, VAL> next;
		public Node(){}
		
		public Node(KEY key, VAL value) {
			this.key = key;
			this.value = value;
		}
	}
}
