package SWEA_1989_초심자의외문검사;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1; i<=t; i++) {
			boolean isPalindrome = true;
			String str = sc.next();
			for (int j = 0; j < str.length() / 2; j++) {
                if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
                    isPalindrome = false;
                    break; // 팰린드롬이 아니라고 판단되면 반복문 종료
                }
            }
			System.out.println("#"+i+" "+(isPalindrome ? 1 : 0));
		}
		sc.close();
	}
}