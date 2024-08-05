package Stack1;

public class Stack_FunctionCall {
	public static void main(String[] args) {
		System.out.println("main 호출");
		
		func1();
		
		System.out.println("main 종료");
	}
	
	public static void func1() {
		System.out.println("func1 호출");
		
		func2();
		
		System.out.println("func1 종료");
	}
	
	public static void func2() {
		System.out.println("func2 호출");
		
		func3();
		
		System.out.println("func2 종료");
	}
	
	public static void func3() {
		System.out.println("func3 호출");		
		System.out.println("func3 종료");
	}
}
