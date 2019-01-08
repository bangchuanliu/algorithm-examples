package leetcode.easy.design;

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
	}

	public V get(K key) {
		if (cache.containsKey(key)) {
			Node<K, V> node = cache.get(key);
			removeNode(node);
			setHead(node);
			return node.value;
		}
		return null;
	}

	public void removeNode(Node<K, V> node) {
		if (node == head) {
			head = head.next;
		} else {
			node.pre.next = node.next;
		}

		if (node == tail) {
			tail = tail.pre;
		} else {
			node.next.pre = node.pre;
		}
	}

	public void setHead(Node<K, V> node) {
		node.next = head;
		if (head != null) {
			head.pre = node;
		}

		if (tail == null) {
			tail = node;
		}

		head = node;
	}

	public void set(K key, V value) {
		if (cache.containsKey(key)) {
			Node<K, V> node = cache.get(key);
			node.value = value;
			removeNode(node);
			setHead(node);
		} else {
			if (cache.size() == capacity) {
				cache.remove(tail.key);
				removeNode(tail);
			}
			Node<K, V> node = new Node<K, V>(key, value);
			setHead(node);
			cache.put(key, node);
		}
	}

	class Node<KEY, VAL> {
		KEY key;
		VAL value;
		Node<KEY, VAL> pre;
		Node<KEY, VAL> next;

		public Node(KEY key, VAL value) {
			this.key = key;
			this.value = value;
		}
	}
}
