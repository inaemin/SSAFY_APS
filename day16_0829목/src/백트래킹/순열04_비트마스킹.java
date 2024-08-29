package 백트래킹;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순열04_비트마스킹 {
	static int[] nums;
	static int N;
	static int[] result;
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		result = new int[N];
		perm(0, 0);
		
		// 결과를 모아서 보려고 했을때 잘 해야한다. 이슈가 생길 수 있음.	
		// 얕은복사이기 때문. 깊은복사를 해야 함.
		for (int [] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	// idx: 결과 배열에 저장할 위치
	// visited : 사용한 원소를 기록하기 위한 정수
	static void perm(int idx, int visited) {
		// 기저조건
//		if (visited == (1<<N)-1) return;
		if (idx == N) {
//			System.out.println(Arrays.toString(result));
			list.add(Arrays.copyOf(result, result.length));
			return;
		}
		
		// 재귀부분
		for (int i=0; i<N; i++) {
			if ((visited & (1<<i)) != 0)
				continue;
			result[idx] = nums[i];
			perm(idx+1, visited | (1<<i));
		}

	}
}
