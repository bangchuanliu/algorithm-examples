package leetcode.design;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iterator;
	private int peek;
	private boolean hasPeeked = false;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (hasPeeked) {
			return peek;
		} else {
			if (hasNext()) {
				peek = iterator.next();
				hasPeeked = true;
				return peek;
			}
		}

		return null;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (hasPeeked) {
			hasPeeked = false;
			return peek;
		} else {
			if (hasNext()) {
				return iterator.next();
			}
		}

		return null;
	}

	@Override
	public boolean hasNext() {
		return hasPeeked || iterator.hasNext();
	}
}
