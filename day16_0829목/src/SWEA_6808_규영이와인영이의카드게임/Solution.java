package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
    static int[] kyu_cards;  // 규영이의 카드
    static int[] in_cards;   // 인영이의 카드 (백트래킹에서 순서를 만든다)
    static boolean[] used;   // 인영이가 카드를 사용했는지 여부를 체크
    static int kyu_won;      // 규영이가 이긴 횟수
    static int in_won;       // 인영이가 이긴 횟수
    static final int TOTAL_CARD_COUNT = 18;  // 전체 카드 개수 (1~18)
    static final int MAX_SCORE = 86;         // 86점 이상이면 승부가 결정됨

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            kyu_cards = new int[9];
            boolean[] cards = new boolean[TOTAL_CARD_COUNT + 1];  // 1~18 카드 사용 여부
            in_cards = new int[9];  // 인영이의 카드 배열
            used = new boolean[9];  // 인영이 카드 사용 여부 체크
            kyu_won = 0;
            in_won = 0;

            // 규영이 카드 입력 및 사용된 카드 체크
            for (int i = 0; i < 9; i++) {
                kyu_cards[i] = sc.nextInt();
                cards[kyu_cards[i]] = true;  // 규영이가 가진 카드는 true로 표시
            }

            // 인영이의 카드 배열 생성 (규영이가 가진 카드를 제외한 나머지 카드)
            int idx = 0;
            for (int i = 1; i <= TOTAL_CARD_COUNT; i++) {
                if (!cards[i]) {
                    in_cards[idx++] = i;
                }
            }

            // 백트래킹을 통해 인영이 카드의 모든 순열을 탐색
            backtrack(0, 0, 0, 0);

            // 결과 출력
            System.out.println("#" + t + " " + kyu_won + " " + in_won);
        }
        sc.close();
    }

    // 백트래킹 함수
    static void backtrack(int depth, int kyu_score, int in_score, int visited) {
        // 종료 조건 1: 한 쪽이 86점 이상이면 더 이상 볼 필요 없다.
        if (kyu_score >= MAX_SCORE || in_score >= MAX_SCORE) {
            if (kyu_score > in_score)
                kyu_won++;
            else
                in_won++;
            return;
        }

        // 종료 조건 2: 9라운드 모두 진행했을 경우
        if (depth == 9) {
            if (kyu_score > in_score)
                kyu_won++;
            else if (kyu_score < in_score)
                in_won++;
            return;
        }

        // 백트래킹: 인영이가 남은 카드 중에서 카드를 선택
        for (int i = 0; i < 9; i++) {
            if ((visited & (1 << i)) != 0) continue;  // 이미 사용한 카드면 넘어감

            int in_card = in_cards[i];
            int next_visited = visited | (1 << i);  // 카드를 사용했음을 기록

            // 규영이와 인영이의 카드를 비교하여 점수 계산
            if (kyu_cards[depth] > in_card) {
                backtrack(depth + 1, kyu_score + kyu_cards[depth] + in_card, in_score, next_visited);
            } else {
                backtrack(depth + 1, kyu_score, in_score + kyu_cards[depth] + in_card, next_visited);
            }
        }
    }
}