package SWEA_6808_규영이와인영이의카드게임;

import java.util.*;

class Solution {
    static int[] G = new int[9]; // 규영이 카드 배열
    static int[] I = new int[9]; // 인영이 카드 배열
    static int[] f = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; // 9! (팩토리얼)
    static int[][] b = new int[171][1 << 9]; // 메모이제이션 배열 (121 * 512 크기)

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  // Scanner로 입력 처리
        StringBuilder sb = new StringBuilder(); // 출력 최적화를 위한 StringBuilder
        int TC = sc.nextInt(); // 테스트 케이스 수 입력

        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(' '); // 테스트 케이스 번호 출력 준비
            int[] num = new int[19]; // 전체 18개의 카드에서 사용 여부를 체크하기 위한 배열

            // 규영이의 9장 카드 입력
            for (int i = 0; i < 9; i++) {
                G[i] = sc.nextInt(); // 규영이 카드 입력
                num[G[i]] = 1; // 해당 카드는 사용되었음을 기록
            }

            Arrays.sort(G); // 규영이의 카드를 오름차순으로 정렬

            // 인영이의 9장 카드 배열 생성 (규영이가 사용하지 않은 카드)
            for (int i = 1, j = 0; i <= 18; i++) {
                if (num[i] == 0) {
                    I[j++] = i; // 사용되지 않은 카드는 인영이의 카드로 설정
                }
            }

            // 메모이제이션 배열 초기화: -1로 채워서 아직 계산되지 않았음을 표시
            for (int i = 0; i < 121; i++) {
                Arrays.fill(b[i], -1);
            }

            // DFS를 통해 규영이가 이기는 경우의 수를 계산
            dfs(0, 9, 0, 0);

            // 규영이가 이긴 횟수는 b[0][0]에 저장되며, 전체 경우의 수에서 빼면 인영이가 이긴 횟수
            sb.append(b[0][0]).append(' ').append(f[9] - b[0][0]).append('\n');
        }

        // 출력
        System.out.print(sb.toString());
        sc.close();
    }

    // DFS 함수: 규영이와 인영이의 점수를 계산하고 승리 횟수를 기록하는 함수
    // visited: 인영이가 이미 사용한 카드
    // lev: 현재 남은 카드의 수
    // scoreA: 규영이의 현재 점수, scoreB: 인영이의 현재 점수
    // visited & (1 << next): next번째 카드가 사용되었는지 확인
    // visited | (1 << next): next번째 카드를 사용상태로 기록
    private static int dfs(int visited, int lev, int scoreA, int scoreB) {
        // 메모이제이션: 이미 계산된 경우 바로 반환
        if (b[scoreA][visited] != -1) {
            return b[scoreA][visited];
        }

        // 규영이의 점수가 85점을 넘으면 규영이 승리
        if (scoreA > 85) {
            return b[scoreA][visited] = f[lev]; // 남은 레벨에서 가능한 모든 경우의 수 반환
        }

        // 인영이의 점수가 85점을 넘으면 인영이 승리
        else if (scoreB > 85) {
            return b[scoreA][visited] = 0; // 규영이 승리 가능성 없음
        }

        int ret = 0; // 규영이가 이기는 경우의 수

        // 인영이의 카드를 하나씩 선택 (카드 순열 생성)
        for (int next = 8; next > -1; next--) {
            // visited에서 next번째 카드가 사용되었는지 확인
        	// 0: 사용하지 않음, 0이 아님: 사용함.
            if ((visited & (1 << next)) == 0) {
                int plus = G[lev - 1] + I[next]; // 현재 규영이 카드와 인영이 카드의 합

                // 규영이의 카드가 더 크면 규영이 점수에 합산
                if (G[lev - 1] > I[next]) {
                    ret += dfs(visited | (1 << next), lev - 1, scoreA + plus, scoreB);
                }
                // 인영이의 카드가 더 크면 인영이 점수에 합산
                else if (G[lev - 1] < I[next]) {
                    ret += dfs(visited | (1 << next), lev - 1, scoreA, scoreB + plus);
                }
            }
        }

        return b[scoreA][visited] = ret; // 계산된 결과를 메모이제이션에 저장하고 반환
    }
}