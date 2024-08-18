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
		max_heap[++heap_size] = data;
		
		int p = heap_size / 2;
		int ch = heap_size;
		while (ch != 1 && max_heap[p] < max_heap[ch]) {
			swap(p, ch);
			ch = p;
			p = ch/2;
		}
	}
	
	void poll() {
		if (heap_size == 0) {
			System.out.print(" " + -1);
			return;
		}
		
		int popItem = max_heap[1];
		System.out.print(" "+popItem);
		max_heap[1] = max_heap[heap_size--];
		
		int p = 1;
		int ch = p * 2;
		
		if (ch + 1 <= heap_size && max_heap[ch] < max_heap[ch+1]) {
			ch++;
		}
		
		while (ch <= heap_size && max_heap[ch] > max_heap[p]) {
			swap(p, ch);
			p = ch;
			ch = p * 2;
			if (ch + 1 <= heap_size && max_heap[ch] < max_heap[ch+1]) {
				ch++;
			}
		}
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			MaxHeap heap = new MaxHeap();
			System.out.print("#"+t);
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
			System.out.println();
		}
		sc.close();
	}
}