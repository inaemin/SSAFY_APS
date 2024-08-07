package Queue;

import java.util.LinkedList;

public class QueueImpl<T> implements QueueInterface<T> {
	private LinkedList<T> queue;
	
	public QueueImpl() {
		queue = new LinkedList<>();
	}

	@Override
	public void add(T item) {
		queue.add(item);
	}

	@Override
	public boolean offer(T item) {
		try {
			queue.add(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public T remove() {
		return queue.removeFirst();
	}

	@Override
	public T poll() {
		return queue.isEmpty() ? null : queue.removeFirst();
	}

	@Override
	public T element() {
		return queue.getFirst();
	}

	@Override
	public T peek() {
		return queue.isEmpty() ? null : queue.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public int size() {
		return queue.size();
	}

}
