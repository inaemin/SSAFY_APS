package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int k = sc.nextInt();
			String infix = sc.next();
			// 1. 후위표기식으로 바꾸기
			String postfix = "";
			List<Character> stack = new ArrayList<>();
			for (int i=0; i<k; i++) {
				char nextChar = infix.charAt(i);
				if (nextChar >= '0' && nextChar <= '9') {
					// 피연산자가 바로 나오면 postfix에 더하기
					postfix += nextChar;
				} else if (nextChar == '(') {
					// 여는 괄호는 스택에 push
					stack.add(nextChar);
				} else if (nextChar == ')') {
					// 닫는 괄호는 여는 괄호가 나올때까지 pop
					char top = stack.remove(stack.size()-1);
					while (top != '(') {
						postfix += top;
						top = stack.remove(stack.size()-1);						
					}
				} else {
					// 연산자의 경우
					// 자신의 우선순위보다 높은 연산자가 나올때까지 pop
					// 그리고 스택에 push
					while (!stack.isEmpty() 
							&& stack.get(stack.size()-1) != '(' 
							&& map.get(stack.get(stack.size()-1)) >= map.get(nextChar)) {
						postfix += stack.remove(stack.size()-1);
					}
					stack.add(nextChar);
				}
			}
			
			// 2. 후위표기식 연산
			List<Integer> stack2 = new ArrayList<>();
			for (int i=0; i<postfix.length(); i++) {
				char nextChar = postfix.charAt(i);
				if (nextChar >= '0' && nextChar <= '9') {
					stack2.add(nextChar - '0');
				} else {
					int num2 = stack2.remove(stack2.size()-1);
					int num1 = stack2.remove(stack2.size()-1);
					switch (nextChar) {
						case '+' :
							stack2.add(num1 + num2);
							break;
						case '-' :
							stack2.add(num1 - num2);
							break;
						case '*' :
							stack2.add(num1 * num2);
							break;
						case '/' :
							stack2.add(num1 / num2);
							break;
					}
				}
			}
			
			System.out.println("#"+t+" "+stack2.get(0));
		}
		sc.close();
		
		
	}
	
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+',  1);
		map.put('-',  1);
		map.put('*',  2);
		map.put('/',  2);
		map.put('(', 0);
	}
}