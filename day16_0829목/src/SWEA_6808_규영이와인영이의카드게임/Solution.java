package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int T;
	static int[] cards;
	static final int card_count = 9;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			cards = new int[card_count];
			for (int i=0; i<card_count; i++) {
				cards[i] = sc.nextInt();
			}
			
			
			// 출력
			System.out.println("#"+t+" ");
		}
		sc.close();
	}
}