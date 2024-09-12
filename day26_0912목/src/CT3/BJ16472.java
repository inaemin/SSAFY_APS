package CT3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 
 * */

public class BJ16472 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Character> set = new HashSet<>();
		int N = sc.nextInt();
		String S = sc.next();
		int max = 0;
		int idx = 0;
		while (idx < S.length() && max < S.length()-idx) {
			for (int i=idx; i<S.length(); i++) {
				set.add(S.charAt(i));
				if (set.size() > N) {
					max = Math.max(max, i-idx);
					set.clear();
					break;
				}
			}
			idx++;
		}
		System.out.println(max);
		sc.close();
	}
}
