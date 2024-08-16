package SWEA_1232_사칙연산;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    private static int calculate(List<String> postfix) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : postfix) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(performOperation(num1, num2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private static int performOperation(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": 
                if (num2 == 0) throw new ArithmeticException("Division by zero");
                return num1 / num2;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    private static List<String> postorder(String[] tree, int idx) {
        List<String> postfix = new ArrayList<>();
        if (idx >= tree.length || tree[idx] == null) {
            return postfix;
        }
        postfix.addAll(postorder(tree, idx*2));
        postfix.addAll(postorder(tree, idx*2+1));
        postfix.add(tree[idx]);
        return postfix;
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = 10; // 테스트 케이스 수
            for (int t = 1; t <= T; t++) {
                int n = sc.nextInt();
                String[] tree = new String[n+1];
                for (int i = 1; i <= n; i++) {
                    sc.nextInt(); // 노드 번호 (무시)
                    if (sc.hasNextInt()) {
                        tree[i] = sc.next(); // 숫자
                    } else {
                        tree[i] = sc.next(); // 연산자
                        sc.nextInt(); sc.nextInt(); // 자식 노드 번호 (무시)
                    }
                }
                
                int answer = calculate(postorder(tree, 1));
                System.out.println("#" + t + " " + answer);
            }
        }
    }
}