package Queue2;

public class 우선순위큐 {
	static int[] queue = new int[100];
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		enQueue(10);
		enQueue(12);
		enQueue(3);
		enQueue(9);
		enQueue(8);
		
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}
	
	static void enQueue(int data) {
		int i= ++rear;
		int j;
		for (j=i-1; j>=0 && queue[j] > data; j--) {
			queue[j+1] = queue[j];
		}
		queue[j+1] = data;
	}
	
	static int deQueue() {
		return queue[++front];
	}
}
