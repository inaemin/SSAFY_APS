package Stack2;

public class Stack2_팩토리얼 {
	public static void main(String[] args) {
		System.out.println(factorial1(10));
		
		System.out.println(factorial2(10));
	}
	
	static int factorial1(int N) {
		// 1부터 N까지의 곱을 return
		int result = 1;
		for (int i=1; i<=N; i++) {
			result *= i;
		}
		return result;
	}
	
	static int factorial2(int N) {
		// 기저 조건
		if (N == 0 || N == 1) return 1;
		
		// 재귀 파트
		return N * factorial2(N-1);
	}
}
