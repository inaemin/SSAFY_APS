package SWEA_21885_신입사원분반교육;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int TC = sc.nextInt();
		for (int t=1; t<=TC; t++) {
			// N: 학생수, min: 최소인원, max: 최대인원
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			
			// score1, score2를 기준으로 3개반으로 분반했을 때
			// 가장 많은 분반과 적은 분반의 학생 수 차의 최솟값을 구하라
			int[] scores = new int[N];
			for (int i=0; i<scores.length; i++) {
				scores[i] = sc.nextInt();
			}
			// 오름차순 정렬
			Arrays.sort(scores);
			
			// 투포인터
			// p1: ban2가 시작, p2: ban2가 끝
			// ban1: p1
			// ban2: p2-p1+1
			// ban3: N-p2-1
			// p1_arr: p1이 가능한 인덱스
			// p2_arr: p2가 가능한 인덱스
			int p1 = min; // 최소
			List<Integer> p1_arr = new ArrayList<>();
			while (true) {
				while (p1 > 0 && p1 < N && scores[p1-1] == scores[p1]) {
					p1++;
				}
				if (p1 >= min && p1 <= max) {
					p1_arr.add(p1);
					p1++;					
				} else break;
			}
			
			int p2 = N-1-min; // 최소
			List<Integer> p2_arr = new ArrayList<>();
			while (true) {
				while (p2 >= 0 && p2 < N-1 && scores[p2] == scores[p2+1]) {
					p2--;
				}
				if (p2 >= 0 && N-p2-1 >= min && N-p2-1 <= max) {
					p2_arr.add(p2);
					p2--;					
				} else break;
			}
			
			int min_diff = Integer.MAX_VALUE;
			for (int i=0; i<p1_arr.size(); i++) {
				for (int j=0; j<p2_arr.size(); j++) {
					int c1 = p1_arr.get(i);
					int c2 = p2_arr.get(j);
					if (c1 > c2) continue;
					int ban1 = c1;
					if (ban1 < min || ban1 > max) continue;
					int ban2 = c2-c1+1;
					if (ban2 < min || ban2 > max) continue;
					int ban3 = N-c2-1;
					if (ban3 < min || ban3 > max) continue;
					int max_ban = Math.max(ban2, ban3);
					max_ban = Math.max(ban1, max_ban);
					int min_ban = Math.min(ban2, ban3);
					min_ban = Math.min(ban1, min_ban);
					min_diff = Math.min(max_ban - min_ban, min_diff);
				}
			}

			// 출력
			System.out.println("#"+t+" "+(min_diff == Integer.MAX_VALUE ? -1 : min_diff));
		}
		sc.close();
	}
}
