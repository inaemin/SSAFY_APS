package SWEA_7465_창용마을무리의개수;

import java.util.*;

class Solution {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 사람의 수
            M = sc.nextInt(); // 관계의 수

            // 그래프 초기화
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 관계 입력
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[N + 1];
            count = 0;

            // DFS 수행
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
        
        sc.close();
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}