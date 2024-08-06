package Stack;

public interface StackInterface<T> {
	void push(T item); // 스택에 삽입
	T pop(); // 스택의 마지막을 제거하고 리턴
	T peek(); // 스택의 마지막을 리턴
	boolean isEmpty(); // 스택이 비어있는지 확인
	int size(); // 스택의 크기 반환
}
