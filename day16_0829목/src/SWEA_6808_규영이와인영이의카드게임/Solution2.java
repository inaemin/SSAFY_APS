package SWEA_6808_규영이와인영이의카드게임;

import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
	static int T; // 테스트 케이스 개수
	static int[] G = new int[9];
	static int[] I = new int[9];
	static int[] f = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; // 9! (팩토리얼)
	static int[][] b = new int[171][1 << 9]; // 메모이제이션 배열 (171*512)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			int[] num = new int[19]; // 18개 카드 배열. 사용 여부 표시.
			// 규영이의 9장 카드 입력
			for (int i=0; i<9; i++) {
				G[i] = sc.nextInt();
				num[G[i]] = 1;
			}
			
			Arrays.sort(G); // 규영이의 카드를 오름차순으로 정렬
			
			// 인영이의 9장 카드 배열 생성 (규영이가 사용하지 않은 카드)
			for (int i=1, j=0; i<=18; i++) {
				if (num[i] == 0) {
					I[j++] = i; // 사용하지 않은 카드는 인영이의 카드로 설정
				}
			} // 정렬된 카드배열 생성
			
			// 메모이제이션 배열 초기화: -1로 채워서 아직 계산되지 않았음을 표시
			for (int i=0; i<121; i++) {
				Arrays.fill(b[i], -1);
			}
			
			// DFS를 통해 규영이가 이기는 경우의 수를 계산
			dfs(0, 9, 0, 0);
			
			// sb에 append
			sb.append("#").append(t).append(' ');
			sb.append(b[0][0]).append(' ').append(f[9] - b[0][0]).append('\n');
		}
		
		// 출력
		System.out.print(sb.toString());
		sc.close();
	}
	
	// DFS: 규영이와 인영이의 점수를 계산하고 승리 횟수를 기록하는 함수
	static int dfs(int visited, int lev, int scoreA, int scoreB) {
		// 메모이제이션: 이미 계산된 경우 바로 반환
		if (b[scoreA][visited] != -1) {
			return b[scoreA][visited];
		}
		
		// 규영이의 점수가 85점을 넘으면 규영이 승리
		if (scoreA > 85) {
			return b[scoreA][visited] = f[lev]; // 남은 레벨에서 가능한 모든 경우의 수 반환
		}
		// 인영이의 점수가 85점을 넘으면 인영이 승리
		else if (scoreB > 85) {
			return b[scoreA][visited] = 0; // 규영이 승리 가능성 없음
		}
		
		int ret = 0; // 규영이가 이기는 경우의 수
		
		// 인영이의 카드를 하나씩 선택 (카드 순열 생성)
		for (int next=8; next>-1; next--) {
			// 이미 선택한 카드는 패스
			if ((visited & (1 << next)) != 0)
				continue;
			
			int plus = G[lev-1] + I[next];
			if (G[lev-1] > I[next]) {
				ret += dfs((visited | (1 << next)), lev-1, scoreA + plus, scoreB);
			} else if (G[lev-1] < I[next]) {
				ret += dfs((visited | (1 << next)), lev-1, scoreA, scoreB + plus);
			}
		}
		
		return b[scoreA][visited] = ret; // 계산된 결과를 메모이제이션에 저장하고 반환
		
	}
}
