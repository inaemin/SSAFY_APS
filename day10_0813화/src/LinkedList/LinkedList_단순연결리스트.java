package LinkedList;

class Node {
	String data;
	Node link;
}

class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	// 삽입 i는 인덱스
	void addData(int i, String data) {
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if (i < 0 || i > size) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		size++; // 사이즈 증가
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;
		for (int k=0; k<i; k++) {
			curr = curr.link;
		}
		
		// 새 노드부터 연결
		newNode.link = curr.link;
		curr.link = newNode;
		
	}
	
	// 삭제
	void removeData(int i) {
		// 0번 : 제일 앞에 있는 데이터 삭제
		// (size-1)번 : 마지막 데이터 삭제
		
		if (i < 0 || i >= size) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}
		size--; // 사이즈 감소
		
		// 삭제할 노드의 앞 노드로 이동
		Node curr = head;
		
		for (int k=0; k<i; k++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
	}
	
	// 조회
	void printAll() {
		Node curr = head.link;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.link;
		}
		System.out.println();
	}	
}

public class LinkedList_단순연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "1번");
		list.printAll();
		list.addData(0, "2번");
		list.addData(0, "3번");
		list.addData(0, "4번");
		list.addData(0, "5번");
		list.printAll();
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.removeData(0);
		list.printAll();
	}
}
