package SWEA_1238_Contact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static final int MAX_N = 101; // 최대 노드 수 (1부터 100까지)
    static List<Integer>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int tc = 1; tc <= 10; tc++) {
            int dataLength = sc.nextInt(); // 데이터의 길이
            int start = sc.nextInt(); // 시작점
            
            // 그래프 초기화
            graph = new ArrayList[MAX_N];
            for (int i = 0; i < MAX_N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 거리 배열과 방문 배열 초기화
            distance = new int[MAX_N];
            visited = new boolean[MAX_N];
            
            // 그래프 구성
            for (int i = 0; i < dataLength / 2; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph[from].add(to);
            }
            
            // BFS 실행
            bfs(start);
            
            // 결과 도출
            int maxDistance = 0;
            int maxNode = 0;
            for (int i = 1; i < MAX_N; i++) {
                if (distance[i] >= maxDistance) {
                    if (distance[i] > maxDistance || i > maxNode) {
                        maxDistance = distance[i];
                        maxNode = i;
                    }
                }
            }
            
            // 출력
            System.out.println("#" + tc + " " + maxNode);
        }
        
        sc.close();
    }
    
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                }
            }
        }
    }
}