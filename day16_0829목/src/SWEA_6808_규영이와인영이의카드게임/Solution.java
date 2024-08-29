package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int T;
	static boolean[] cards;
	static final int total_card_count = 18;
	static final int card_count = 9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			cards = new boolean[total_card_count+1];
			for (int i=0; i<card_count; i++) {
				int num = sc.nextInt();
				cards[num] = true;
			}
			
			
			// 출력
			System.out.println("#"+t+" ");
		}
		sc.close();
	}
}