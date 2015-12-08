import java.util.*;

public class BinaryTree implements Iterable {

	public static void main ( String [] args ) {
		public BinaryTree biTree;
		biTree.traverse;
	}

	// Private instances data for BinaryTree class. 
	private BinaryTree root;
	private BinaryTree leftSubtree;
	private BinaryTree rightSubtree;
	private BinaryTree fatherSubtree;
	private Object data;
	private BinaryTree cursor;
	
	
	// Constructs an empty tree 
	public BinaryTree () {
		this.root = null;
		this.data = null;
		this.leftSubtree = null;
		this.rightSubtree = null;
		this.fatherSubtree = null;
		this.cursor = null;	
		}

	// constructs a tree with just a root node decorated with (i.e., referring to) obj 
	public BinaryTree (Object obj) {
		this.root = this;
		this.data = obj;
		this.leftSubtree = null;
		this.rightSubtree = null;
		this.fatherSubtree = null;
		this.cursor = null;
	}

	//  returns true iff the tree contains an object equivalent to obj
	public boolean contains ( Object obj ) {
		if ( this.root == null ) {
			return false;
		}
		else if ( obj.equals ( this.root ) ) {
			return true;
		}
		return false;
	}
	// has a left child?
	public boolean hasLeft () {
		return this.leftSubtree != null;
	}

	// has a right child?
	public boolean hasRight () {
		return this.rightSubtree != null;
	}

	// returns true iff obj is a similar binary tree- i.e., obj must have identical structure (only)
	public boolean similar ( Object obj) {
		if ( !( obj instanceof BinaryTree ) ) {
			return false;
		}
		BinaryTree newTree = ( BinaryTree ) obj;
		if ( this.hasLeft () != newTree.hasLeft () || this.hasRight () != newTree.hasRight () ) {
			return false;
		}
		else if ( this.hasLeft () && !( this.leftSubtree.equals ( newTree.leftSubtree ) ) ) {
			return false;
		}
		else if ( this.hasRight() && !( this.rightSubtree.equals ( newTree.rightSubtree ) ) ) {
			return false;
		}
		return true;		
	}
	
	

	// 
	public boolean equals ( Object obj ) {
		if ( !( obj instanceof BinaryTree ) ) {
			return false;
		}
		BinaryTree newTree = ( BinaryTree ) obj;
		if ( this.hasLeft () != newTree.hasLeft () || this.hasRight () != newTree.hasRight () ) {
			return false;
		}
		else if ( !( this.root.equals ( newTree.root ) ) ) {
			return false;
		}
		else if ( this.hasLeft () && !( this.leftSubtree.equals ( newTree.leftSubtree ) ) ) {
			return false;
		}
		else if ( this.hasRight() && !( this.rightSubtree.equals ( newTree.rightSubtree ) ) ) {
			return false;
		}
		return true;
	}

	// returns whether the tree is empty
	public boolean isEmpty () {
		return this.root == null;
	}

	// returns size of the tree
	public int size() {
		int count = 1;
		if ( hasLeft () ) {
			count += leftSubtree.size ();
		}
		if ( hasRight () ) {
			count += rightSubtree.size ();
		}
		return count;
	}
	
	public int hashCode() {
        throw new UnsupportedOperationException();
    }

	// returns iterator 
	public Iterator iterator() {
		
		return new Iterable ( this );
	}

	private class InorderIterator implements Iterator {

		private BinaryTree bt;
		private BinaryTree tree;
		private Stack <BinaryTree> s;

		public InorderIterator (BinaryTree bt) {
			this.bt = bt;
			this.tree = null;
			this.s = new Stack <BinaryTree> ();
		}

		public boolean hasNext () {
			if (this.tree == null) {
				return this.bt != null;
			}
			if (this.tree.hasLeft() || ! (this.s.isEmpty())) {
				return true;
			}
			return false;
		}

		public Object next () {
			if ( ! (this.hasNext()) ) {
				throw new NoSuchElementException();
			}
			if ( this.tree == null ) {
				this.tree = this.bt;
			}
			else {
				if(this.tree != null) {
					this.s.push(this.tree);
					this.tree = this.tree.leftSubtree;
				} 	
				if ( this.tree.hasRight() ) {
					this.tree = this.tree.rightSubtree;
				}
				else if ( ! (this.s.isEmpty()) ) {
					this.tree = this.s.pop();
				}
			}
			if (this.tree.hasLeft()) {
				this.s.push(this.tree.leftSubtree);
			}
			return (this.tree.data);
		}

		public void remove () {
			throw new UnsupportedOperationException();
		}
	}

	
	public boolean putCursorAtRoot() {
		this.cursor = this.root;

	}
	
	public boolean putCursorAtLeftSon() {
		this.cursor = this.leftSubtree;
	}
	
	public boolean putCursorAtRightSon() {
		this.cursor = this.rightSubtree;
	}
	
	
	public boolean putCursorAtFather() {
		this.cursor = this.fatherSubtree;
	}
	
	public boolean attachLeftSonAtCursor(Object obj) {
		return this.leftSubtree != null;
	}
	
	public boolean attachRightSonAtCursor(Object obj)  {
		return this.rightSubtree != null;		
	}
	
	public boolean pruneFromCursor() {
		
	}
	
	public class Node {

		private Object o;

		public Node( Node leftSubtree, Object o, Node rightSubtree ) {
			this.leftSubtree = leftSubtree;
			this.o = o;
			this.rightSubtree = rightSubtree;
		}

		public boolean hasLeft () {
			return this.leftSubtree != null;
		}

		public boolean hasRight () {
			return this.rightSubtree != null;
		}
		public Node getLeft() {
			return this.leftSubtree;
		}

		public Node getRight() {
			return this.rightSubtree;
		}

		public Object getO() {
			return this.o;
		}

		public void setLeft( Node leftSubtree ) {
			this.left = leftSubtree;
		}

		public void setRight( Node rightSubtree ) {
			this.right = rightSubtree;
		}

		public void setO( Object o ) {
			this.o = o;
		}
	}
}
