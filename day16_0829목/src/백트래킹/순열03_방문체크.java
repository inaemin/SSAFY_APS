package 백트래킹;

import java.util.Arrays;

public class 순열03_방문체크 {
	static int[] nums;
	static int N;
	// 추가적인 공간 필요
	static boolean[] visited;
	// 원본배열을 조작하지 않음
	static int[] result;
	
	public static void main(String[] args) {
		nums = new int[] {3, 2, 1};
		N = nums.length;
		visited = new boolean[N];
		result = new int[N];
		perm(0);
	}
	
	// idx: 결과 배열에 저장할 위치
	static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			result[idx] = nums[i];
			perm(idx + 1);
			visited[i] = false;
		}
	}
}
