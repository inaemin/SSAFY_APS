package Heap;

public class Solution {
	public static void main(String[] args) {
		/*
		 * 힙(Heap)
		 * 완전 이진트리에 있는 노드 중에서 키 값이 가장 큰 노드나 키 값이 가장 작은
		 * 노드를 찾기 위해서 만든 자료구조
		 * 
		 * 최대 힙(max heap)
		 * - 키 값이 가장 큰 노드를 찾기 위한 완전 이진 트리
		 * - 부모 노드의 키 값 >= 자식 노드의 키 값
		 * - 루트 노드: 키 값이 가장 큰 노드
		 * 
		 * 최소 힙(min heap)
		 * - 키 값이 가장 작은 노드를 찾기 위한 완전 이진 트리
		 * - 부모 노드의 키 값 <= 자식 노드의 키 값
		 * - 루트 노드 : 키 값이 가장 작은 노드
		 * 
		 * 힙의 활용 1 - 우선순위 큐
		 * - 우선순위 큐를 구현하는 가장 효율적인 방법이 힙을 사용하는 것이다.
		 *   - 노드 하나의 추가/삭제의 시간 복잡도가 O(logN)이고 최댓값/최솟값을 O(1)에 구할 수 있다.
		 *   - 완전정렬보다 관리 비용이 적다.
		 * - 배열을 통해 트리 형태를 쉽게 구현할 수 있다.
		 *   - 부모나 자식 노드를 O(1) 연산으로 쉽게 찾을 수 있다.
		 *   - n 위치에 있는 노드의 자식은 2*n과 (2*n)+1에 위치한다.
		 *   - 완전이진트리의 특성에 의해 추가/삭제의 위치는 자료의 시작과 끝 인덱스로 쉽게 판단할 수 있다.
		 *   
		 * 힙의 활용 2 - 힙 정렬
		 * - 힙 정렬은 힙 자료구조를 이용해서 이진 트리와 유사한 방법으로 수행된다
		 * - 정렬을 위한 2단계
		 *   - 하나의 값을 힙에 삽입한다.(반복)
		 *   - 힙에서 순차적(오름차순)으로 값을 하나씩 제거한다.
		 * - 힙정렬의 시간복잡도
		 *   - N개의 노드 삽입 연산 + N개의 노드 삭제 연산
		 *   - 삽입과 삭제 연산은 각각 O(logN)이다.
		 *   - 따라서, 전체 정렬은 O(NlogN)이다.
		 * - 힙 정렬은 배열에 저장된 자료를 정렬하기에 유용하다.
		 * */
	}
}