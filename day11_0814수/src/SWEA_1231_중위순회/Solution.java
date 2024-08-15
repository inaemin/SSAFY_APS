package SWEA_1231_중위순회;

import java.util.Scanner;

public class Solution {
	private static String inorder(String[] tree, int idx) {
		String answer = "";
		// L -> V -> R
		if (idx >= tree.length) {
			return answer;
		}
		answer += inorder(tree, idx * 2);
		answer += tree[idx];
		answer += inorder(tree, idx * 2 + 1);
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int n = sc.nextInt();
			// 정점정보 : 해당 정점의 문자, 왼쪽 자식, 오른쪽 자식의 정점 번호 순서
			// ArrayList 사용
			String[] tree = new String[n+1];
			for (int i=1; i<=n; i++) {
				int idx = sc.nextInt();
				tree[i] = sc.next();
				if (idx * 2 <= n)
					sc.nextInt();
				if (idx * 2 + 1 <= n)
					sc.nextInt();
			}
			
			// inorder 형식으로 트리 읽기
			String answer = inorder(tree, 1);

			// 출력
			System.out.println("#"+t+" "+answer);
		}
		sc.close();
	}
}