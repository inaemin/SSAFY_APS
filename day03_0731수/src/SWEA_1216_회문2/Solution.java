package SWEA_1216_회문2;

public class Solution {
	
	private static boolean isPalindrome(String str) {
		for (int i=0; i<=str.length()/2; i++) {
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}