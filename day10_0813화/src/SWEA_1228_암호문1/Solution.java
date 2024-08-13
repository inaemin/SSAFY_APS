package SWEA_1228_암호문1;

import java.util.Scanner;

class Node {
	int data;
	Node link;
	Node() {}
	Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	int size;
	SinglyLinkedList() {
		this.head = new Node();
	}
	SinglyLinkedList(int[] arr) {
		this.head = new Node();
		Node curr = this.head;
		for (int i=0; i<arr.length; i++) {
			curr.link = new Node(arr[i]);
			curr = curr.link;
			size++;
		}
	}
	
	void addNumbers(int idx, int[] arr) {
		if (idx < 0 || idx > size) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}
		
		Node curr = this.head;
		// 삽입할 위치 앞에 있는 노드 찾기
		for (int i=0; i<idx; i++) {
			curr = curr.link;
		}
		// arr 순서 반대로 새 노드를 만들어서 연결하기
		for (int i=arr.length-1; i>=0; i--) {
			Node newNode = new Node(arr[i]);
			newNode.link = curr.link;
			curr.link = newNode;
			size++;
		}
	}
	
	void printFirstTenNumbers() {
		Node curr = this.head;
		for (int i=0; i<10; i++) {
			curr = curr.link;
			System.out.print(" "+curr.data);
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			// 원본 암호문의 길이
			int n = sc.nextInt();
			// 원본 암호문
			int[] original_list = new int[n];
			for (int i=0; i<n; i++) {
				original_list[i] = sc.nextInt();
			}
			SinglyLinkedList list = new SinglyLinkedList(original_list);
			// 명령어의 개수
			int commandNum = sc.nextInt();
			for (int i=0; i<commandNum; i++) {
				sc.next(); // 삽입 I
				int addingIndex = sc.nextInt(); // 앞에서부터 x의 위치 바로 다음에 추
				int addNumLength = sc.nextInt(); // y개의 숫자를 삽
				int[] addNumArr = new int[addNumLength]; // 덧붙일 숫자들
				for (int j=0; j<addNumLength; j++) {
					addNumArr[j] = sc.nextInt();
				}
				list.addNumbers(addingIndex, addNumArr);
			}
			
			// 출력
			System.out.print("#"+t);
			list.printFirstTenNumbers();
			System.out.println();
		}
		sc.close();
	}
}