package SWEA_1222_계산기1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int k = sc.nextInt();
			String infix = sc.next();
			String postfix = "";
			boolean isPlus = false;
			// 1. 후위표기식으로 바꾸기
			for (int i=0; i<k; i++) {
				if (infix.charAt(i) != '+') {
					if (!isPlus) {
						postfix += infix.charAt(i);
					} else {
						postfix += infix.charAt(i);
						postfix += '+';
						isPlus = false;
					}
				} else {
					isPlus = true;
				}
			}
			// 2. 후위표기식 계산
			List<Integer> stack = new ArrayList<>();
			for (int i=0; i<k; i++) {
				char nextChar = postfix.charAt(i);
				if (nextChar >= '0' && nextChar <= '9') {
					stack.add(nextChar - '0');
				} else if (nextChar == '+') {
					int num2 = stack.remove(stack.size()-1);
					int num1 = stack.remove(stack.size()-1);
					stack.add(num1 + num2);
				}
			}
			System.out.println("#"+t+" "+stack.get(0));
		}
		sc.close();
	}
}