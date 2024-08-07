package Queue;

public interface QueueInterface<T> {
	void add(T item); // 큐의 끝에 요소를 추가. 큐의 용량을 초과하면 예외를 발생.
	boolean offer(T item); // 큐의 끝에 요소를 추가. 큐의 용량을 초과하면 false를 반환.
	T remove(); // 큐의 헤드를 제거하고 반환. 큐가 비어있으면 예외를 발생.
	T poll(); // 큐의 헤드를 제거하고 반환. 큐가 비어있으면 null을 반환.
	T element(); // 큐의 헤드를 반환. 큐가 비어있으면 예외를 발생.
	T peek(); // 큐의 헤드를 반환. 큐가 비어있으면 null을 반환.
	boolean isEmpty(); // 큐가 비어있는지의 여부.
	int size(); // 큐의 요소의 개수.
}
