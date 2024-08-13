package LinkedList;

class DoubleNode extends Node {
	String data;
	DoubleNode prev;
	DoubleNode next;
}

class DoublyLinkedList {
	DoubleNode head;
	DoubleNode tail;
	int size;
	
	DoublyLinkedList() {
		head = new DoubleNode();
		tail = new DoubleNode();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int idx, String data) {
		// 0 이면 제일 앞에 삽입
		// size면 제일 뒤에 삽입
		
		if (idx < 0 || idx > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		// 삽입 위치 앞의 노드를 찾는다
		DoubleNode curr = head;
		
		for (int k=0; k<idx; k++) {
			curr = curr.next;
		}
		
		// 새 노드 만들어주기
		DoubleNode newNode = new DoubleNode();
		newNode.data = data;
		
		// 새 노드 연결해주기
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;
	}
	
	void removeData(int idx) {
		// 0: 제일 앞의 데이터 삭제
		// size - 1 : 제일 뒤의 데이터 삭제
		
		if (idx < 0 || idx >= size) {
			System.out.println("삭제 할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		// 삭제할 위치를 찾기
		// rmNode는 지역변수이므로 메서드 리턴과 동시에 접근불가 (Garbage Collector)
		DoubleNode rmNode = head.next;
		
		for (int k=0; k<idx; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
	}
	
	void printReverse() {
		DoubleNode curr = tail.prev;
		while (curr != head) {
			System.out.print(" <- " + curr.data);
			curr = curr.prev;
		}
	}
}

public class LinkedList_양방향연결리스트 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "1번");
		list.addData(0, "2번");
		list.addData(0, "3번");
		list.addData(0, "4번");
		list.addData(0, "5번");
		list.printReverse();
	}
}
