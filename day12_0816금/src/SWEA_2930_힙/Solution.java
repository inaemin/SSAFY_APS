package SWEA_2930_힙;

import java.util.Scanner;

class MaxHeap {
	private int[] max_heap;
	private final int MAX_NUM = 100001;
	private int heap_size = 0;
	
	MaxHeap() {
		max_heap = new int[MAX_NUM];
	}
	
	void swap(int i, int j) {
		int tmp = max_heap[i];
		max_heap[i] = max_heap[j];
		max_heap[j] = tmp;
	}
	
	void push(int data) {
		
	}
	
	void poll() {
		int popItem = max_heap[0];
		System.out.print(popItem);
		max_heap[0] = max_heap[heap_size--];
		
		int p = 1;
		int ch = p * 2;
		if (ch + 1 <= MAX_NUM && max_heap[ch] < max_heap[ch+1]) {
			ch++;
		}
		
		while (ch <= heap_size && heap[ch] > heap[p])
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			MaxHeap heap = new MaxHeap();
			for (int i=0; i<N; i++) {
				int operator = sc.nextInt();
				if (operator == 1) {
					int x = sc.nextInt();
					// x를 최대 힙에 추가
					heap.push(x);
				} else {
					// 현재 최대 힙의 루트 노드의 키값을 출력
					// 해당 노드를 삭제
					heap.poll();
				}
			}
		}
		sc.close();
	}
}