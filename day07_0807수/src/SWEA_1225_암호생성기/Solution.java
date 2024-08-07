package SWEA_1225_암호생성기;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			// 테스트 케이스 번호
			int tc = sc.nextInt();
			// 암호문을 담을 queue 설정
			LinkedList<Integer> encrypt = new LinkedList<>();
			for (int i=0; i<8; i++) {
				encrypt.addLast(sc.nextInt());
			}
			// 한 사이클은 1~5
			// 0과 같거나 작아지는 경우가 나타날때까지 반복
			out: while (true) {
				for (int del=1; del<=5; del++) {
					if (encrypt.get(0) > del) {
						encrypt.addLast(encrypt.removeFirst() - del);
					} else {
						// 0과 같거나 작아지면 0을 뒤에 추가하고
						// while문 탈출
						encrypt.removeFirst();
						encrypt.addLast(0);
						break out;
					}
				}
			}
			
			// 출력
			System.out.print("#"+tc);
			for (int i=0; i<8; i++) {
				System.out.print(" "+encrypt.get(i));
			}
			System.out.println();
		}
		
		sc.close();
	}
}