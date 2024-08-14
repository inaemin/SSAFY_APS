package Tree;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinaryTree {
	private TreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	// 노드 삽입
	public void insert(int data) {
		root = insertRec(root, data);
	}
	
	private TreeNode insertRec(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode(data);
			return root;
		}
		
		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);
		return root;
	}
	
	// 전위 순회
	public void preorder() {
		preorderHelper(root);
		System.out.println();
	}
	private void preorderHelper(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderHelper(root.left);
			preorderHelper(root.right);
		}
	}
	
	// 중위 순회
	public void inorder() {
		inorderHelper(root);
		System.out.println();
	}
	
	private void inorderHelper(TreeNode root) {
		if (root != null) {
			inorderHelper(root.left);
			System.out.print(root.data + " ");
			inorderHelper(root.right);
		}
	}
	
	// 후위 순회
	public void postorder() {
		postorderHelper(root);
		System.out.println();
	}
	
	private void postorderHelper(TreeNode root) {
		if (root != null) {
			postorderHelper(root.left);
			postorderHelper(root.right);
			System.out.print(root.data + " ");
		}		
	}
}

public class Tree_이진트리 {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		System.out.println("전위 순회: ");
		tree.preorder();
		System.out.println("중위 순회: ");
		tree.inorder();
		System.out.println("후위 순회: ");
		tree.postorder();
	}
}
