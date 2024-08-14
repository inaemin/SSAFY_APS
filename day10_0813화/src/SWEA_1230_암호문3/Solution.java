package SWEA_1230_암호문3;

import java.util.Scanner;

class Node {
	Node next;
	Node prev;
	int data;
	
	Node() {}
	
	Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;
	
	DoublyLinkedList() {
		this.head = new Node();
		this.tail = new Node();
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}
	
	DoublyLinkedList(int[] arr) {
		this.head = new Node();
		this.tail = new Node();
		this.head.next = this.tail;
		this.tail.prev = this.head;
		
		Node curr = this.head;
		for (int i=arr.length-1; i>=0; i--) {
			Node newNode = new Node(arr[i]);
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next.prev = newNode;
			curr.next = newNode;
		}
	}
	
	// x번째 암호문 바로 다음에 y개의 암호문을 삽입한다.
	void insertData(int idx, int[] arr) {
		Node curr = this.head;
		for (int i=0; i<idx; i++) {
			curr = curr.next;
		}
		
		for (int i=arr.length-1; i>=0; i--) {
			Node newNode = new Node(arr[i]);
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next.prev = newNode;
			curr.next = newNode;
		}
	}
	
	// x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.
	void removeData(int idx, int y) {
		Node start = this.head.next;
		Node end = this.head.next;
		for (int i=0; i<idx; i++) {
			start = start.next;
			end = end.next;
		}
		for (int i=0; i<=y; i++) {
			end = end.next;
		}
		
		// start와 end 노드를 잇는다
		start.next.prev = null;
		end.prev.next = null;
		start.next = end;
		end.prev = start;
	}
	
	// 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다.
	void addData(int[] arr) {
		Node curr = tail.prev;
		for (int i=arr.length-1; i>=0; i--) {
			Node newNode = new Node(arr[i]);
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next.prev = newNode;
			curr.next = newNode;
		}
	}
	
	void printFirstTenNumbers() {
		Node curr = this.head.next;
		for (int i=0; i<10; i++) {
			System.out.print(" "+curr.data);
			curr = curr.next;
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			// 원본 암호문 뭉치 속 암호문의 개수
			int n = sc.nextInt();
			int[] original_list = new int[n];
			for (int i=0; i<n; i++) {
				original_list[i] = sc.nextInt();
			}
			// 링크드리스트 생성
			DoublyLinkedList list = new DoublyLinkedList(original_list);
			// 명령어의 개수 m
			int m = sc.nextInt();
			for (int i=0; i<m; i++) {
				String command = sc.next();
				if (command.equals("I")) {
					// I 삽입 : x번째 암호문 바로 다음에 y개의 암호문 삽입
					int x = sc.nextInt();
					int y = sc.nextInt();
					int[] arr = new int[y];
					for (int j=0; j<y; j++) {
						arr[j] = sc.nextInt();
					}
					list.insertData(x, arr);
				} else if (command.equals("D")) {
					// D 삭제
					int x = sc.nextInt();
					int y = sc.nextInt();
					list.removeData(x, y);
				} else if (command.equals("A")) {
					// A 추가
					int y = sc.nextInt();
					int[] arr = new int[y];
					for (int j=0; j<y; j++) {
						arr[j] = sc.nextInt();
					}
					list.addData(arr);
				}
			}
			
			// 출력
			System.out.print("#"+t);
			list.printFirstTenNumbers();
			System.out.println();
		}
		sc.close();
	}
}