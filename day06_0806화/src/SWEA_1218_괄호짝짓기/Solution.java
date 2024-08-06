package SWEA_1218_괄호짝짓기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t=1; t<=10; t++) {
			int k = sc.nextInt();
			String[] arr = sc.next().split("");
			List<String> stack = new ArrayList<>();
			boolean isValid = true;
			for (int i=0; i<k; i++) {
				String nextStr = arr[i];
				if (isOpeningBracket(nextStr)) {
					stack.add(nextStr);
				} else if (isValidClosingBracket(stack, nextStr)) {
					stack.remove(stack.size()-1);
				} else {
					isValid = false;
					break;
				}
			}
			System.out.println("#"+t+" "+ (isValid ? 1 : 0));
		}
		sc.close();
	}
	
	private static boolean isOpeningBracket(String str) {
		return str.equals("(") || str.equals("{") || str.equals("<") || str.equals("[");
	}
	
	private static boolean isValidClosingBracket(List<String> stack, String str) {
		String lastStr = stack.get(stack.size()-1);
		if ((lastStr.equals("(") && str.equals(")"))
				|| (lastStr.equals("{") && str.equals("}"))
				|| (lastStr.equals("[") && str.equals("]"))
				|| (lastStr.equals("<") && str.equals(">"))) {
			return true;
		}
		return false;
	}
}