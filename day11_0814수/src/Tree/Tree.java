package Tree;

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	List<Node> children;
	
	Node(int data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
	
	void addChild(Node child) {
		this.children.add(child);
	}
}

public class Tree {
	private static Node root;
	
	public Tree() {
		root = null;
	}
	
	public void setRoot(int data) {
		root = new Node(data);
	}
	
	public Node getRoot() {
		return root;
	}
	
	// 노드 추가
	public void addNode(int parentData, int childData) {
		if (root == null) {
			System.out.println("루트 노드가 없습니다.");
			return;
		}
		
		Node parent = findNode(root, parentData);
		
		if (parent != null) {
			parent.addChild(new Node(childData));
		} else {
			System.out.println("부모 노드를 찾을 수 없습니다.");
		}
	}
	
	// 노드 찾기
	private Node findNode(Node current, int data) {
		if (current.data == data) {
			return current;
		}
		for (Node child : current.children) {
			Node found = findNode(child, data);
			if (found != null) {
				return found;
			}
		}
		return null;
	}
	
	// 전위 순회
	public void preorder(Node node) {
		if (node == null) return;
		
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preorder(child);
		}
	}
	
	// 중위 순회
	public void inorder(Node node) {
		if (node == null) return;
		
		if (node.children.size() > 0) {
			inorder(node.children.get(0));
		}
		
		System.out.print(node.data + " ");
		
		for (int i=1; i<node.children.size(); i++) {
			inorder(node.children.get(i));
		}
	}
	
	// 후위 순회
	public void postorder(Node node) {
		if (node == null) return;
		
		for (Node child : node.children) {
			postorder(child);
		}
		System.out.print(node.data + " ");
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.setRoot(1);
		tree.addNode(1, 2);
		tree.addNode(1, 3);
		tree.addNode(1, 4);
		tree.addNode(2, 5);
		tree.addNode(2, 6);
		tree.addNode(3, 7);
		tree.addNode(4, 8);
		
		System.out.println("전위 순회: ");
		tree.preorder(root);
		System.out.println();
		
		System.out.println("중위 순회: ");
		tree.inorder(root);
		System.out.println();
		
		System.out.println("후위 순회: ");
		tree.postorder(root);
		System.out.println();
	}
}
