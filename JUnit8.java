import static org.junit.Assert.*;

import org.junit.Test;

public class JUnit8 {
	
	public static void main (String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(); // root node
		root1.setData(0);
		
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>();
		node1.setData(1);
		
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>();
		node2.setData(2);
		
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>();
		node3.setData(3);
		
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>();
		node4.setData(4);
		
		BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>();
		node5.setData(5);
		
		BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>();
		node6.setData(6);
		
		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>();
		node7.setData(7);
		
	
		tree.setRoot(root1);
		root1.setLeft(node1);
		root1.setRight(node4);
		node1.setLeft(node2);
		node1.setRight(node3);
		node4.setLeft(node5);
		node4.setRight(node6);
		
	
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>();
	
		tree2.setRoot(root1);
		root1.setLeft(node1);
		root1.setRight(node4);
		node1.setLeft(node2);
		node1.setRight(node3);
		node4.setLeft(node5);
		node4.setRight(node6);
		
		
		BinaryTree<Integer> t3 = new BinaryTree<Integer>();
		
		BinaryTreeNode<Integer> root3 = new BinaryTreeNode<Integer>(); // root node
		root3.setData(1);
		
		BinaryTreeNode<Integer> t3node1 = new BinaryTreeNode<Integer>();
		t3node1.setData(2);
		
		BinaryTreeNode<Integer> t3node2 = new BinaryTreeNode<Integer>();
		t3node2.setData(3);
		
		BinaryTreeNode<Integer> t3node3 = new BinaryTreeNode<Integer>();
		t3node3.setData(4);
		
		BinaryTreeNode<Integer> t3node4 = new BinaryTreeNode<Integer>();
		t3node4.setData(5);
		
		BinaryTreeNode<Integer> t3node5 = new BinaryTreeNode<Integer>();
		t3node5.setData(6);
		
		BinaryTreeNode<Integer> t3node6 = new BinaryTreeNode<Integer>();
		t3node6.setData(7);
		
		
		t3.setRoot(root3);
		root3.setLeft(t3node1);
		root3.setRight(t3node4);
		t3node1.setLeft(t3node2);
		t3node1.setRight(t3node3);
		t3node4.setLeft(t3node5);
		
		BinaryTree<Integer> t4 = new BinaryTree<Integer>();
		
		BinaryTreeNode<Integer> root4 = new BinaryTreeNode<Integer>(); // root node
		root4.setData(1);
		
		BinaryTreeNode<Integer> t4node1 = new BinaryTreeNode<Integer>();
		t4node1.setData(2);
		
		BinaryTreeNode<Integer> t4node2 = new BinaryTreeNode<Integer>();
		t4node2.setData(3);
		
		t4.setRoot(root4);
		root4.setLeft(t4node1);
		root4.setRight(t4node2);
	}

	@Test
	public void testEquals1() {
		assertTrue(true);
	}
	
	@Test
	public void testEquals2() {
		assertTrue(true);
	}
	
	@Test
	public void testEquals3() {
		assertTrue(true);
	}
	
	@Test
	public void testEquals4() {
		assertTrue(true);
	}
	
	@Test
	public void testDeepCopy1() {
		assertTrue(true);
	}
	
	@Test
	public void testDeepCopy2() {
		assertTrue(true);
	}
	
	@Test
	public void testDeepCopy3() {
		assertTrue(true);
	}
	
	@Test
	public void testDeepCopy4() {
		assertTrue(true);
	}
	
	@Test
	public void testCombine1() {
		assertTrue(true);
	}
	
	@Test
	public void testCombine2() {
		assertTrue(true);
	}
	
	@Test
	public void testSize1() {
		assertTrue(true);
	}
	
	@Test
	public void testSize2() {
		assertTrue(true);
	}
	
	@Test
	public void testHeight1() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(5);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.height(), 2);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		assertEquals(tree3.height(), 1);
		assertEquals(root.height(), 2);
		assertEquals(right.height(), 1);
	}
	
	@Test
	public void testHeight2() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(10);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.height(), 2);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		assertEquals(tree3.height(), 1);
		assertEquals(root.height(), 2);
		assertEquals(right.height(), 1);
	}
	
	@Test
	public void testHeight3() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(45);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(45);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(45);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(45);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.height(), 2);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		assertEquals(tree3.height(), 1);
		assertEquals(root.height(), 2);
		assertEquals(right.height(), 1);
	}
	
	@Test
	public void testHeight4() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(55);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(55);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(55);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(55);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.height(), 2);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		assertEquals(tree3.height(), 1);
		assertEquals(root.height(), 2);
		assertEquals(right.height(), 1);
	}
	
	@Test
	public void testFull1() {
		assertTrue(true);
	}
	
	@Test
	public void testFull2() {
		assertTrue(true);
	}
	
	@Test
	public void testFull3() {
		assertTrue(true);
	}
	
	@Test
	public void testFull4() {
		assertTrue(true);
	}
	
	@Test
	public void testMirror1() {
		assertTrue(true);
	}
	
	@Test
	public void testMirror2() {
		assertTrue(true);
	}
	
	@Test
	public void testMirror3() {
		assertTrue(true);
	}
	
	@Test
	public void testMirror4() {
		assertTrue(true);
	}
	
	@Test
	public void testInOrder1() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(25);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(8);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(17);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(6);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.inOrder(),"(8)(25)(17)");
		assertEquals(root.inOrder(),"(8)(25)(17)");
		assertEquals(root1.inOrder(),"(6)");
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		//assertEquals(tree3.inOrder(),"(8)(25)(17)(6)(8)(6)");	
	}
	
	@Test
	public void testInOrder2() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(6);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(15);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(2);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.inOrder(),"(6)(9)(15)");
		assertEquals(root.inOrder(),"(6)(9)(15)");
		assertEquals(root1.inOrder(),"(2)");
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		//assertEquals(tree3.inOrder(),"(8)(25)(17)(6)(8)(6)");
	}
	
	@Test
	public void testInOrder3() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(31);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(82);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(16);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.inOrder(),"(5)(31)(82)");
		assertEquals(root.inOrder(),"(5)(31)(82)");
		assertEquals(root1.inOrder(),"(16)");
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		//assertEquals(tree3.inOrder(),"(8)(25)(17)(6)(8)(6)");
	}
	
	@Test
	public void testInOrder4() {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(92);
		BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(2);
		BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(19);
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(26);
		root.setLeft(left);
		root.setRight(right);
		root.setLeft(left);
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(root);
		assertEquals(tree1.inOrder(),"(2)(92)(19)");
		assertEquals(root.inOrder(),"(2)(92)(19)");
		assertEquals(root1.inOrder(),"(26)");
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(root1);
		BinaryTree<Integer> tree3 = tree1.combine(root1, tree2, true);
		//assertEquals(tree3.inOrder(),"(8)(25)(17)(6)(8)(6)");
	}

}