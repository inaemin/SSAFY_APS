package SWEA_3499_퍼펙트셔플;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 수
		int t = sc.nextInt();
		// 테스트 반복
		for (int tc=1; tc<=t; tc++) {
			// 카드의 개수
			int n = sc.nextInt();
			// 셔플덱
			List<String> arr = new ArrayList<>();
			// 카드를 2세트로 나눠서 담을 queue 2개
			LinkedList<String> queue1 = new LinkedList<>();
			LinkedList<String> queue2 = new LinkedList<>();
			int idx = 0;
			// 카드를 queue 2개에 나눠 담기.
			// 홀수개의 경우 첫번째 queue에 담겨야 하기 때문에
			// n/2가 아니라 double로 형변환한 n을 2로 나눈다.
			while (idx < n) {
				if (idx < ((double) n)/2) {
					queue1.add(sc.next());
				} else {
					queue2.add(sc.next());
				}
				idx++;
			}
			// 번갈아가면서 queue에서 제거한 front를 arr에 담아준다.
			for (int i=0; i<n; i++) {
				if (i % 2 == 0) {
					arr.add(queue1.removeFirst());
				} else {
					arr.add(queue2.removeFirst());
				}
			}
			// 출력
			System.out.print("#"+tc);
			for (int i=0; i<arr.size(); i++) {
				System.out.print(" "+arr.get(i));
			}
			System.out.println();
		}
		sc.close();
	}
}