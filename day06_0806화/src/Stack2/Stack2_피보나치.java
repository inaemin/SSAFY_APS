package Stack2;

public class Stack2_피보나치 {
	public static void main(String[] args) {
		System.out.println(fib(10));
	}
	
	static int[] dp = new int[500];
	static {
		dp[1] = 1;
	}
	
	static int fib(int N) {
		if (N <= 1)
			return N;
		if (dp[N] > 0)
			return dp[N];
		return dp[N] = fib(N-1) + fib(N-2);
	}	
}
