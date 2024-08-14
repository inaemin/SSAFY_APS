package SWEA_5658_보물상자비밀번호;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	private static int turn16To10(String str) {
		// 0~9는 그대로
		// A: 10, B: 11, C: 12, D: 13, E: 14, F: 15
		int answer = 0;
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			int exp = str.length()-1-i;
			if (c >= '0' && c <= '9') {
				answer += ((int) Math.pow(16, exp)) * (c - '0');
			} else {
				answer += ((int) Math.pow(16, exp)) * (c - 'A' + 10);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			// n, k 입력
			int n = sc.nextInt();
			int k = sc.nextInt();
			String password = sc.next();
			LinkedList<Character> list = new LinkedList<>();
			for (int i=0; i<password.length(); i++) {
				list.add(password.charAt(i));
			}
			// n은 4의 배수. 자물쇠의 한 변을 채우는 숫자의 개수는 n/4개.
			// queue를 만들어서 마지막을 pop해서 앞에 추가한다.
			// 총 n/4번 반복.
			// 만들어지는 16진수 숫자를 10진수를 바꾸어서
			// 중복이 허용되지 않는 set에 추가.
			// set을 sort해서 k번째 큰 수를 구한다.			
			
			Set<Integer> set = new HashSet<>();
			for (int i=0; i<n/4; i++) {
				for (int j=0; j<n; j+=n/4) {
					String possible_pw = "";
					for (int m=j; m<j+n/4; m++) {
						possible_pw += list.get(m);
					}
					set.add(turn16To10(possible_pw));
				}
				// 마지막 글자를 앞으로 보내준다.
				char last_char = list.removeLast();
				list.addFirst(last_char);
			}
			
			int[] list_to_arr = new int[set.size()];
			int idx = 0;
			for (int element : set) {
				list_to_arr[idx] = element;
				idx++;
			}
			Arrays.sort(list_to_arr);
			
			// 출력
			System.out.println("#"+t+" "+list_to_arr[set.size()-k]);
		}
		sc.close();
	}
}
