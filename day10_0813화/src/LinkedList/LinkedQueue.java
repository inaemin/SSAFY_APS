package LinkedList;

public class LinkedQueue<T> implements IQueue<T>{

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    private static class DoubleNode<T> {
        T data;
        DoubleNode<T> next;
        DoubleNode<T> prev;

        DoubleNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public LinkedQueue() {
    	this.head = new DoubleNode<>(null); // 더미 노드
        this.tail = new DoubleNode<>(null); // 더미 노드
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    @Override
    public void add(T item) {
    	DoubleNode<T> newNode = new DoubleNode<>(item);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public boolean offer(T item) {
    	try {
            add(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public T remove() {
    	if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        DoubleNode<T> firstNode = head.next;
        T data = firstNode.data;
        head.next = firstNode.next;
        firstNode.next.prev = head;
        size--;
        return data;
    }

    @Override
    public T poll() {
    	if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override
    public T element() {
    	if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.next.data;
    }

    @Override
    public T peek() {
    	if (isEmpty()) {
            return null;
        }
        return head.next.data;
    }

    @Override
    public boolean isEmpty() {
    	return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

}
