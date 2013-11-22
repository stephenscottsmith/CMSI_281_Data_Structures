
/**
   An object of this class represents a binary tree. 
   Nodes may be decorated (labeled) with arbitrary objects (the default is null).
*/

public class BinaryTree implements java.util.Collection {

   private int size;
   private Object object;
   private BinaryTree parent;
   private BinaryTree leftSon;
   private BinaryTree rightSon;


   /** Constructs an empty binary tree. */
   public BinaryTree (Object object, BinaryTree parent, BinaryTree leftSon, BinaryTree rightSon) {
      this.object = object;
      this.parent = parent;
      this.leftSon = leftSon;
      this.rightSon = rightSon;
   }
   
   public Object getObject () {
      return this.object;
   }

   /**
      Returns a string that represents this binary tree. 
	  (Some possible formats will be discussed in class.)
   */
   
   public String toString () {
      throw new UnsupportedOperationException();
   }
   
   /**
      Adds a node, decorated with obj, to this binary tree.
	  The new node becomes the root of the tree; the former tree becomes the left subtree 
	  of the root; the right subtree of the root will be empty.
   */

   public boolean add ( Object obj ) {
      throw new UnsupportedOperationException();
   }
   
 	
   /**
      Adds a node, decorated with obj, to this binary tree.
	  The new node becomes the root of the tree; the left subtree of the root will be empty; 
	  the former tree becomes the right subtree of the root.
   */

   public boolean alternateAdd ( Object obj ) {
      throw new UnsupportedOperationException();
   }
   
   /**
      Static factory for constructing new binary trees.
	  The root of the new tree will be decorated with obj; leftSubtree and rightSubtree, respectively, 
	  will become the left and right subtrees of the root.
   */

   public static BinaryTree newFromRootAndTwoTrees ( Object obj, BinaryTree leftSubtree, BinaryTree rightSubtree ) {
      throw new UnsupportedOperationException();
   }
   
		  	
   /** Returns a hashcode for this binary tree. */

   public int hashCode () {
      throw new UnsupportedOperationException();
   }

	
   /** Throws an UnsupportedOperationException(). */
   public boolean addAll ( java.util.Collection c ) {
      throw new UnsupportedOperationException();
   }

	
   /** Re-initializes this to an empty binary tree. */	
   public void clear () {
      throw new UnsupportedOperationException();
   }

   /**
      Returns true iff this binary tree contains (at least) one example
      of obj.
   */

   public boolean contains ( Object obj ) {
      throw new UnsupportedOperationException();
   }

   /**
      Returns true iff this binary tree contains at least one example of each DIFFERENT
      object in Collection c. Note that c may contain several examples of some 
      (same) object, but this binary tree is only required to contain one such example.
   */

   public boolean containsAll ( java.util.Collection c ) {
      throw new UnsupportedOperationException();
   }

   /**
      Returns true iff this binary tree is equivalent, with respect to both structure and content, 
	  as Object obj.
   */

   public boolean equals ( Object obj ) { // overrides Collection
      throw new UnsupportedOperationException();
   }
   
	
   /** Returns true iff this binary tree is empty. */
   public boolean isEmpty () {
      throw new UnsupportedOperationException();
   }

	
   /** Returns a preorder iterator for this binary tree. All bets are off if the tree changes during the traversal. */
   public java.util.Iterator iterator () {
      throw new UnsupportedOperationException();
   }


	
   /** Returns an inorder iterator for this binary tree. All bets are off if the tree changes during the traversal. */
   public java.util.Iterator inorderIterator () {
      throw new UnsupportedOperationException();
   }

   /** Returns a postorder iterator for this binary tree. All bets are off if the tree changes during the traversal. */
   public java.util.Iterator postorderIterator () {
      throw new UnsupportedOperationException();
   }	

   /**
      Removes a matching object from this binary tree, and returns true,  
      provided that the matching object is at a leaf; if there is no matching leaf,
	  then the method returns false.
   */
   public boolean remove ( Object obj ) {
      throw new UnsupportedOperationException();
   }

	
   /** Throws an UnsupportedOperationException. */
   public boolean removeAll (  java.util.Collection c ) {
      throw new UnsupportedOperationException ();
   }

	
   /** Throws an UnsupportedOperationException(). */
   public boolean retainAll ( java.util.Collection c ) { // overrides Collection
      throw new UnsupportedOperationException ();
   }

	
   /** Returns the number of nodes in this binary tree. */
   public int size () {
      throw new UnsupportedOperationException ();
   }

   /** Throws an UnsupportedOperationException(). */
   public Object[] toArray () {
      throw new UnsupportedOperationException ();
   }

 
   /** Throws an UnsupportedOperationException(). */
   public Object[] toArray ( Object[] a ) {
      throw new UnsupportedOperationException ();
   }

   public class Node {
      private Object object;
      private Node parentNode;
      private Node leftChildNode;
      private Node rightChildNode;
      
      public Node (Object object, Node parentNode, Node leftChildNode, Node rightChildNode) {
         this.object = object;
         this.parentNode = parentNode;
         this.leftChildNode = leftChildNode;
         this.rightChildNode = rightChildNode;
      }
   }

}











