package 백트래킹;

public class 순열01_반복문 {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		
		// 중복을 허용하지 않는 순열만들기 - 반복문 이용
		// 최대 3개까지만 하는 것을 권장
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i != j) {
					for (int k=0; k<N; k++) {
						if (i !=k && j != k) {
							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);							
						}
					}					
				}
			}
		}
	}

}
