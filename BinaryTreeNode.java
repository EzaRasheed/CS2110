public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(){
		this(null,null,null);
	}
	
	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}
	
	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}
	
	public int size(){
		int size = 0; //the size of the tree
		
		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> dc = new BinaryTreeNode<T>(this.data); // create a copy of the data in BinaryTreeNode 
		BinaryTreeNode<T> leftCopy = null; // making left node empty
        BinaryTreeNode<T> rightCopy = null; // making right node empty
        if (this.left != null) { // if the left node(child) is not empty(null),
        	leftCopy = this.left.deepCopy(); // make a deep copy of the left node
            dc.setLeft(leftCopy); // set the new deep copied left node
        }
        if (this.right != null) { // if the right node(child) is not empty(null),
        	rightCopy = this.right.deepCopy(); // make a deep copy of the right node 
            dc.setRight(rightCopy); // set the new deep copied right node
        }
        return dc; // return the copied node, whether the left child or right child
	}

	
	@Override
	public boolean equals(Object o){
		if (o instanceof BinaryTreeNode) { // if there is no left node, but there is a right node, return it and its "data"
			BinaryTreeNode compare = (BinaryTreeNode) o;
			if ((left == null) && (right != null)) {
				return (getRight().equals(compare.getRight())) && (getData().equals(compare.getData()));
            } 
			else if ((left != null) && (right == null)) { // else if there is a left node, but there is no right node, return the left node and its "data"
                return (getLeft().equals(compare.getLeft())) && (getData().equals(compare.getData()));
			} 
			else if ((left == null) && (right == null)) { // else if there isn't a left node nor right node, just return the data
                return (getData().equals(compare.getData()));
            } 
			else {
                return (getLeft().equals(compare.getLeft())) && (getRight().equals(compare.getRight())) && (getData().equals(compare.getData())); // else return both the left node and right node and all of their respective data 
            }
		} 
			else {
				return false; // else it's none of the above, return false
			}
	}

	
	public int height(){
		if ((this.left != null) && (this.right == null)) { // if there is a left child
			return 1 + this.getLeft().height(); // return the current root node plus the present left child node to get the total height of that subtree
		} 
		else if ((this.right != null) && (this.left == null)) { // else if there is a right child
            return 1 + this.getRight().height(); // return the current root node plus the present right child node to get the total height of that subtree
		} 
		else if ((this.right != null) && (this.left != null)) { // else if there are both right and left child nodes
            return 1 + Math.max(this.getRight().height(), this.getLeft().height()); // return the current root node plus the maximum height of all nodes in the tree to get the total height
		} 
		else if ((this.right == null) && (this.left == null)) { // else if  there is no child nodes present
            return 1; // return the height of the root of the tree, which is 1
		} 
		else { 
            return 0; // height of root could be 0
		}
	}


	public boolean full(){
		boolean tree = false; // instantiate tree to not be full (false)
		if ((this.left != null) && (this.right != null)) { // if there is both a left child and right child present
			tree = true; // the tree is full(true)
        }
		return tree; // return true if the tree is full or false if it isn't
	}

	
	public void mirror(){
		BinaryTreeNode<T> btn = new BinaryTreeNode<T>();// create a new BinaryTreeNode in order to modify it to its mirror
		if (this.left != null && this.right == null) { // else if there is only a left node
        	btn = this.getLeft().deepCopy(); // create a deep copy of the left child in the new BinaryTreeNode
            this.setLeft(null); // set the left node to be empty
            this.setRight(btn); // set the right node in the modified new BinaryTreeNode
            this.right.mirror(); // mirror the right node 
        } 
		else if (this.left == null && this.right != null) { // if there is only a right node
        	btn = this.getRight().deepCopy(); // create a deep copy of the right child in the new BinaryTreeNode
            this.setLeft(btn);  // set the left node in the modified new BinaryTreeNode
            this.setRight(null); // set the right node to be empty
            this.left.mirror(); // mirror the left node
        } 
        else if (this.left != null && this.right != null) { // else if there is both a left node and right node
        	btn = this.getLeft().deepCopy(); // create a deep copy of the left child in the new BinaryTreeNode
            this.setLeft(this.getRight().deepCopy()); // // set the left node to be the deep copy of the right node
            this.setRight(btn); // set the right node in the modified new BinaryTreeNode
            this.right.mirror(); // mirror the right node
            this.left.mirror(); // mirror the left node
        }
	}

	
	public String inOrder(){
		String order = ""; // create empty string
        if (this.left != null) { // if a left node is present(first step) 
        	order = order + this.getLeft().inOrder(); // add left node's data to the initially empty string
        }
        order = order + "(" + this.getData() + ")"; // put data in parenthesis 
        if (this.right != null) { // if a right node is present(last step)
                order = order + this.getRight().inOrder(); // add right node's data to the string
        }
        return order; // returns the string with the data held at each node in parenthesis
	}
}