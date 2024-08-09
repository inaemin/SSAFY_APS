package swea5356;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// 문자열 5개를 입력받기 위한 배열
			String[] arr = new String[5];
			// 최대 문자열의 길이
			int max_len = 0;
			for (int i=0; i<5; i++) {
				String str = sc.next();
				arr[i] = str;
				max_len = Math.max(max_len, str.length());
			}
			// 결과문자열 초기화
			String result = "";
			// 문자열 인덱스
			int idx = 0;
			// 문자열 인덱스가 최대 문자열 길이보다 작을때까지 반복
			while (idx < max_len) {
				for (int i=0; i<5; i++) {
					// 문자열의 길이보다 인덱스가 작은 경우만
					if (arr[i].length() > idx)
					result += arr[i].charAt(idx);
				}
				// 인덱스 증가
				idx++;
			}
			// 출력
			System.out.println("#"+t+" "+result);
			
		}
		sc.close();
	}
}
