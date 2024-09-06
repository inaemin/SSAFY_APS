package SWEA_1251_하나로_크루스칼;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution2 {
	static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;
		
		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
		
	}
	
	static int T; // 테스트 케이스의 수
	static int N; // 섬의 개수
	static int[] X, Y; // 섬의 X좌표, Y좌표 배열
	static double E; // 환경부담세율
	static int[] P; // 부모노드배열
	
	public static void main(String[] args) {
		// 환경 부담금 : E(환경부담세율) * L(해저터널길이)^2
		// 총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템
		// 64비트 integer 및 double로 처리하지 않는 경우 overflow 발생 가능
		// 크루스칼로 풀기
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			N = sc.nextInt(); // 섬의 개수
			X = new int[N]; // X좌표
			Y = new int[N]; // Y좌표
			P = new int[N]; // 루트 저장
			for (int i=0; i<N; i++) {
				X[i] = sc.nextInt();
				P[i] = i;
			}
			for (int i=0; i<N; i++) {
				Y[i] = sc.nextInt();
			}
			
			E = sc.nextDouble();
			
			// 모든 섬들 사이의 환경 부담금 계산
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {
					double dx = X[i] - X[j];
					double dy = Y[i] - Y[j];
					double cost = (dx * dx + dy * dy) * E;
					pq.add(new Edge(i, j, cost));
				}
			}
			
			double totalCost = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				if (findSet(edge.from) != findSet(edge.to)) {
					union(edge.from, edge.to);
					totalCost += edge.cost;
				}
			}

			// 출력
			System.out.println("#"+t+" "+Math.round(totalCost));
		}
		sc.close();
		
	}
	
	static int findSet(int a) {
		if (P[a] != a) {
			P[a] = findSet(P[a]);
		}
		return P[a];
	}
	
	static void union(int a, int b) {
		int na = findSet(a);
		int nb = findSet(b);
		if (na != nb) {
			P[nb] = na;
		}
	}
}