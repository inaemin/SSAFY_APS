package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // 테스트 케이스 개수
		for (int t=1; t<=tc; t++) {
			int k = sc.nextInt(); // 입력 개수
			List<Integer> arr = new ArrayList<>();
			int sum = 0;
			for (int i=0; i<k; i++) {
				int ele = sc.nextInt();
				if (ele != 0) {
					sum += ele;
					arr.add(ele);					
				} else if (arr.size() > 0) {
					sum -= arr.get(arr.size()-1);
					arr.remove(arr.size() - 1);
				}	
			}
			
			System.out.println("#"+t+" "+sum);
		}
		sc.close();
	}
}