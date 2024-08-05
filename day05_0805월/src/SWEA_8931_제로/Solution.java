package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t=1; t<=tc; t++) {
			int k = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			for (int i=0; i<k; i++) {
				int ele = sc.nextInt();
				if (ele != 0) {
					arr.add(ele);					
				} else if (arr.size() > 0) {
					arr.remove(arr.size() - 1);
				}	
			}
			int sum = 0;
			for (int num : arr) {
				sum += num;
			}
			System.out.println("#"+t+" "+sum);
		}
		sc.close();
	}
}