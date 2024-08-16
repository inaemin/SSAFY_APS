package SWEA_21886_스위치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 스위치 개수
		int n = sc.nextInt();
		// 각 스위치의 상태 입력
		int[] switches = new int[n];
		for (int i=0; i<n; i++) {
			switches[i] = sc.nextInt();
		}
		// 학생 수
		int stuNum = sc.nextInt();
		for (int i=0; i<stuNum; i++) {
			// 학생의 성별(남:1, 여:2), 학생이 받은 수
			int gender = sc.nextInt();
			int num = sc.nextInt();
			if (gender == 1) {
			// 남학생이라면 자신이 받은 번호의 배수를 토글
				for (int j=1; j<=n/num; j++) {
					switches[j*num - 1] ^= 1;
				}
			} else {
			// 여학생이라면 자신이 받은 번호 양 옆으로 스위치 상태가 같다면 토글
				switches[num-1] ^= 1;
				for (int j=1; j < num && num+j-1 < n; j++) {
					if (switches[num-1-j] == switches[num+j-1]) {
						switches[num-1-j] ^= 1;
						switches[num+j-1] ^= 1;
					}
				}
			}
		}
		// 스위치 출력
		for (int i=0; i<n; i++) {
			if (i != 0 && i % 20 == 0) {
				System.out.println();
			}
			System.out.print(switches[i]+" ");
		}
		
		sc.close();
	}
}
