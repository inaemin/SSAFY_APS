package SWEA_1860_진기의최고급붕어빵;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 개수
		int tc = sc.nextInt();
		test: for (int t=1; t<=tc; t++) {
			// n명의 손님
			int n = sc.nextInt();
			// m초의 시간을 들이면 k개의 붕어빵을 만듦
			int m = sc.nextInt();
			int k = sc.nextInt();
			// n명의 손님이 도착하는 시간
			// n초 : 0명
			Map<Integer, Integer> arrival_time_cnt = new TreeMap<>();
			for (int i=0; i<n; i++) {
				int time = sc.nextInt();
				if (arrival_time_cnt.containsKey(time)) {
					arrival_time_cnt.put(time, arrival_time_cnt.get(time)+1);
				} else {
					arrival_time_cnt.put(time, 1);
				}
			}
			
			// 모든 사람이 기다리는 시간이 없이 붕어빵을 제공할 수 있으면
			// "Possible", 아니면 "Impossible"을 출력
			int sold_fish = 0;
			for (int time : arrival_time_cnt.keySet()) {
				if (time / m * k - sold_fish >= arrival_time_cnt.get(time)) {
					sold_fish += arrival_time_cnt.get(time);
				} else {
					System.out.println("#"+t+" "+"Impossible");
					continue test;
				}
			}
			
			// 출력
			System.out.println("#"+t+" "+"Possible");			
			
		}
		sc.close();
	}
}