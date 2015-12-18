public class LinkedDeque {
	//private variables:
	private int size;
	private Node left;
	private Node right;
	private Node base;
	
	public LinkedDeque() {
		this.left = null;
		this.right = null;
		this.size = 0;

	}

	public void insertLeft( Object o ) {
		if ( this.size == 0 ) {
			this.left = new Node(null, o, null);
			this.right = this.left;
		} else {
			this.left.setLeft( new Node(null, o, this.left) );	
			this.left = this.left.getLeft();
		}	
		this.size++;
	}

	public void insertRight( Object o ) {
		if ( this.size == 0 ) {
			this.right = new Node(null, o, null);
			this.left = this.right;
		} else {
			this.right.setRight( new Node(right, o, null) );
			this.right = this.right.getRight();
		}
		this.size++;
	}

	public void deleteLeft() {
		if ( this.size < 1 ) {
			throw new UnsupportedOperationException();
		} 
		if ( this.size == 1 ) {
			this.left = null;
			this.right = null;
			this.size = 0;
		} else {
			this.left = this.left.getRight();
			this.left.setLeft( null );
			this.size--;
		}
		
	}

	public void deleteRight() {
		if ( this.size < 1 ) {
			throw new UnsupportedOperationException();
		}
		if ( this.size == 1 ) {
			this.right = null;
			this.left = null;
			this.size = 0;
		} else {
			this.right = this.right.getLeft();
			this.right.setRight( null );
			this.size--;
		}

	}

	public Object left() {
		return this.left.getO();
	}

	public Object right() {
		return this.right.getO();
	}

	public int size() {

		return this.size;
	}

	public String toString() {
		String output = "";
		Node lefty = this.left;
		while ( lefty != null ) {
			output = output + "[" + lefty.getO() + "]";
			lefty = lefty.getRight();
		}
		return output;
	}

	public static void main( String[] args ) {
	
	}

	public class Node {
		private Node left;
		private Node right;
		private Object o;

		public Node( Node left, Object o, Node right ) {
			this.left = left;
			this.o = o;
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public Object getO() {
			return this.o;
		}

		public void setLeft( Node left ) {
			this.left = left;
		}

		public void setRight( Node right ) {
			this.right = right;
		}

		public void setO( Object o ) {
			this.o = o;
		}
	}

}

