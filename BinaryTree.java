public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) { // Are you a binary tree?
			BinaryTree bt = (BinaryTree) o; // Assign new binary tree object (cast to a BinaryTree)
            return (getRoot().equals(bt.getRoot())); // Compares BinaryTree objects, returns true if they equal each other
        } 
		else {
			return false; // BinaryTree objects do not match(equal)
        }
	}

	
	public BinaryTree<T> deepCopy() {
		BinaryTree<T> bi = new BinaryTree<T>(); // create new BinaryTree
        bi.setRoot(this.getRoot().deepCopy()); // set the root by getting the deep copy of the root
        return bi; // return deep copy of calling object
	}

	
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) {
		BinaryTree<T> bi = new BinaryTree<T>(); // create new BinaryTree
        if (left) { // if the root of the tree is the left child
        	bi.setRoot(newRoot.deepCopy()); // make a deep copy of the left child and set it as the root
            newRoot.setLeft(t.getRoot().deepCopy()); // set the calling tree as the left child
            newRoot.setRight(this.getRoot().deepCopy()); // set passing tree as right child
        } 
        else { // else the root of the tree is the right child
        	bi.setRoot(newRoot.deepCopy()); // make a deep copy of the right child and set it as the root
        	newRoot.setRight(t.getRoot().deepCopy()); // set the calling tree as the right child
            newRoot.setLeft(this.getRoot().deepCopy()); // set passing tree as left child
        }
        return bi; // returns a new binary object with the left child or right child being the root of the appropriate BinaryTree 
	}
	
	
	public int size(){
		if (this.getRoot() == null) { // if the root is empty
			return 0; // size is zero
        } 
		else { 
             return this.getRoot().size(); // else call size starting at the root of the tree
        }
	}
 
	
	public int height(){
		if (this.getRoot() == null) { // if the root is empty
			return 0; // height is zero
		} 
		else {
             return this.getRoot().height(); // else call height starting at the root of the tree
        }
	}

	
	public boolean full(){
		if (this.getRoot().getLeft().full() && this.getRoot().getRight().full()) { // if the roots have two children, left and right nodes
			return true; // return true as the tree is full
		}
		else {
			return false; // else it is not full, return false
		}	
	}

	
	public void mirror(){
		if (this.getRoot() != null) { // if there is a root present 
			this.getRoot().mirror(); // mirror the root
        }
	}

	
	public String inOrder(){
		if (this.getRoot() != null) { // if there is a root node present(middle step)
			return this.getRoot().inOrder(); // // return the data held at the root
        } 
		else {
			return null; // else, there is no data available for the root 
        }
	}
}