package 위상정렬;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class jewelSolution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // 배열과 기준점 입력
        int N = sc.nextInt(); // 배열의 크기
        int[] jewels = new int[N]; // 보석 배열
        for (int i = 0; i < N; i++) {
            jewels[i] = sc.nextInt(); // 1: 보석 있음, 0: 보석 없음
        }
        int start = sc.nextInt(); // 기준점 (index)

        // 보석이 있는 인덱스만이 담긴 리스트를 만든다.
        // start와 제일 가까운 인덱스를 구한다.
        // 제일 가까운 보석인덱스로 이동해서 왼쪽과 오른쪽에 있는 보석 인덱스와의 거리를 구한다.
        // 거리가 짧은 쪽으로 이동
        // 만약 두 거리가 같다면 stop하고 start에서 두번째 가까운 인덱스에 더 가깝게 이동
        
        // 만약 제일 가까운 인덱스가 첫 인덱스 또는 마지막 인덱스라면 시작점에서 이동하지않음 -> 0 출력
        // 
        
        List<Integer> jewelIndices = new ArrayList<>();
        for (int i=0; i<N; i++) {
        	if (jewels[i] == 1) {
        		jewelIndices.add(i);
        	}
        }
        
        // 제일 가까운 보석 인덱스 찾기
        int closestIndex = findClosestJewel(jewelIndices, start);
        // jewelIndices들을 start에 가까운 순서대로 정렬
        
        
        // 만약 첫 번째 인덱스나 마지막 인덱스라면 이동할 필요가 없음
        if (closestIndex == jewelIndices.get(0) || closestIndex == jewelIndices.get(jewelIndices.size()-1)) {
        	System.out.println(0);
        } else {
        	// 보석을 가져갈 첫 포인트만 잡으면 start와의 차이로 거리를 구할 수 있음
        	// 첫 포인트 잡는걸 중점으로
        	// 첫 시작 포인트는 closestIndex고 
        	
        }
        
        
    }
    
    static int findClosestJewel(List<Integer> jewelIndices, int currentPosition) {
    	int minDistance = Integer.MAX_VALUE;
    	int closestIndex = -1;
    	
    	for (int i=0; i<jewelIndices.size(); i++) {
    		int distance = Math.abs(currentPosition - i);
    		if (distance < minDistance) {
    			minDistance = distance;
    			closestIndex = i;
    		}
    	}
    	
    	return closestIndex;
    }
}