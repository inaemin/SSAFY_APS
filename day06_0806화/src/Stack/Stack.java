package Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> implements StackInterface<T> {
	private List<T> stack = new ArrayList<>();
	
	@Override
	public void push(T item) {
		stack.add(item);		
	}

	@Override
	public T pop() {
		if (!stack.isEmpty())
			return stack.remove(stack.size()-1);
		return null;
	}

	@Override
	public T peek() {
		if (!stack.isEmpty())
			return stack.get(stack.size()-1);
		return null;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public int size() {
		return stack.size();
	}
	
}
