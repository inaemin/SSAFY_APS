package SWEA_1208_flatten;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int dump = sc.nextInt(); // 덤프 횟수
			int[] boxHeights = new int[100]; // 박스 높이
			for (int i=0; i<100; i++) {
				int ele = sc.nextInt();
				boxHeights[i] = ele;
			}
			
			int[] count = new int[101]; // 상자높이카운트
			for (int height : boxHeights) {
				count[height]++;
			}
			
			int minHeight = 0;
			int maxHeight = 100;
			for (int i=0; i<dump; i++) {
				// 가장 높은 상자 찾기
				while (count[maxHeight] == 0) {
					maxHeight--;
				}
				// 가장 낮은 상자 찾기
				while (count[minHeight] == 0) {
					minHeight++;
				}
				
				// 높이 차이가 1 이하면 더 이상 덤프가 필요 없음
				if (maxHeight - minHeight <= 1) {
					break;
				}
				
				// 덤프 수행
				count[maxHeight]--;
				count[maxHeight - 1]++;
				count[minHeight]--;
				count[minHeight + 1]++;
			}
			
			// 최종 높이 차이 계산
			while (count[maxHeight] == 0) {
				maxHeight--;
			}
			while (count[minHeight] == 0) {
				minHeight++;
			}
			
			int result = maxHeight - minHeight;			
			System.out.println("#"+t+" "+result);
		}
		sc.close();
	}
}