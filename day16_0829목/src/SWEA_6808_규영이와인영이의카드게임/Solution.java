package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int T; // 테스트 케이스 개수
	static final int total_card_count = 18;
	static int[] kyu_cards, in_cards;
	static int kyu_won, in_won;
	static boolean[] used;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			kyu_cards = new int[total_card_count/2];
			in_cards = new int[total_card_count/2];
			used = new boolean[total_card_count+1];
			kyu_won = 0;
			in_won = 0;
			
			for (int i=0; i<total_card_count/2; i++) {
				kyu_cards[i] = sc.nextInt();
				used[kyu_cards[i]] = true;
			}
			
			int idx = 0;
			for (int i=1; i<=total_card_count; i++) {
				if (!used[i])
					in_cards[idx++] = i;
			}
			
			// 점수를 얻기 위해선 높은 수를 낸 사람은 
			// 두 카드에 적힌 수의 합만큼 점수를 얻고
			// 낮은 수가 적힌 카드를 낸 사람은 아무 점수 얻을 수 없음
			// 아홉 라운드가 끝난 후 총점을 따졌을때, 총점이 더 높은 사람이 승자
			
			backtrack(0, 0, 0);
			
			// 출력
			System.out.println("#"+t+" "+kyu_won+" "+in_won);
		}
		sc.close();
	}
	
	static void backtrack(int depth, int kyu_score, int in_score) {
		if (depth == total_card_count/2) {
			if (kyu_score > in_score)
				kyu_won++;
			else if (kyu_score < in_score)
				in_won++;
			return;
		}
		if (kyu_score > 171 || in_score > 171) {
			if (kyu_score > in_score)
				kyu_won++;
			else 
				in_won++;
			return;
		}
		
		for (int i=1; i<=total_card_count; i++) {
			if (!used[i]) {
				used[i] = true;
				if (kyu_cards[depth] > i) {
					backtrack(depth+1, kyu_score + kyu_cards[depth] + i, in_score);
				} else {
					backtrack(depth+1, kyu_score, in_score + kyu_cards[depth] + i);
				}
				used[i] = false;
			}
		}
	}
	
}