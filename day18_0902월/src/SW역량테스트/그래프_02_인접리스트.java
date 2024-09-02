package SW역량테스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// V, E의 개수를 준다.
		int V = sc.nextInt(); // 정점의 개수 (0 or 1로 시작을 한다.)
		int E = sc.nextInt(); // 간선의 개수
		
		List<Integer>[] adjList = new ArrayList[V];
		
		// 기본적으로 전부 생성을 해주어야 null point exception이 뜨지 않음.
		for (int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i=0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// 가중치를 같이 저장하고 싶다면
			// 1. 클래스를 정의해서 넣던지,
			// 2. int[] 이용해서 넣던지
			adjList[A].add(B);
			adjList[B].add(A);
			
		}
		
		sc.close();
	}
	
	// 인접행렬 vs 인접리스트
	
}
