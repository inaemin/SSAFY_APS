package SWEA_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스의 수
	static int N, M; // N: 집합의 개수, M: 입력으로 주어지는 연산의 개수
	static int[] P; // 루트노드배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt(); // 테스트 케이스 수
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			P = new int[N+1];
			for (int i=0; i<P.length; i++) {
				P[i] = i;
			} // 루트노드 초기화
			// 출력
			System.out.print("#"+t+" ");
			// 합집합: 0 a b
			// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산: 1 a b
			// a와 b는 N이하의 자연수이며 같을 수도 있다.
			for (int i=0; i<M; i++) {
				int C = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				if (C == 0) { // 합집합
					union(A, B);
				} else if (C == 1) { // 확인연산
					System.out.print(findSet(A) == findSet(B) ? 1 : 0);
				}
			}
			System.out.println();
		}
		sc.close();
	}
	
	static void union(int a, int b) {
		int na = findSet(a);
		int nb = findSet(b);
		if (na != nb)
			P[nb] = na; // nb를 na에 연결
	}
	
	// path compression
	static int findSet(int a) {
		if (P[a] != a) {
			P[a] = findSet(P[a]);
		}
		return P[a];
	}
}