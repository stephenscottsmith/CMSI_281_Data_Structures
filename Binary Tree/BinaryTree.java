
// 6. remove
// FIX FOR EMPTY TREES ALL ITERATORS AND METHODS

import java.util.Iterator;
import java.util.Stack;
import java.util.Collection;

/**
   An object of this class represents a binary tree. 
   Nodes may be decorated (labeled) with arbitrary objects (the default is null).
*/

public class BinaryTree implements Collection {

   private Object object;
   private int size;
   private BinaryTree leftSubtree;
   private BinaryTree rightSubtree;
   private BinaryTree parentTree;

   /** 
   Constructs an empty binary tree. 
   */
   public BinaryTree () {
      this.object = null;
      this.size = 0;
      this.leftSubtree = null;
      this.rightSubtree = null;
      this.parentTree = null;
   }
   
   /** 
   Constructs a binary tree with the root node's object being set to the parameter of this constructor. 
   */
   public BinaryTree (Object object) {
      this.object = object;
      this.size = 1;
      this.leftSubtree = null;
      this.rightSubtree = null;
      this.parentTree = null;
   }

   /**
      Returns a string that represents this binary tree. 
	  (Some possible formats will be discussed in class.)
   */
   public String toString () {
      if (this.size == 0) {
         return "";
      }

      String startStr = "";
      String leftPointerStr = "";
      String rightPointerStr = "";

      if (this.object != null) { 
         startStr = this.object.toString();
      }

      if (this.leftSubtree != null) { 
         leftPointerStr = this.leftSubtree.toString();
      }

      if (this.rightSubtree != null) { 
         rightPointerStr = this.rightSubtree.toString();
      }

      return startStr + " (" + leftPointerStr +") (" + rightPointerStr + ")";
   }
   
   /**
      Adds a node, decorated with obj, to this binary tree.
	  The new node becomes the root of the tree; the former tree becomes the left subtree 
	  of the root; the right subtree of the root will be empty.
   */
   public boolean add ( Object obj ) {
      return this.supremeAdd(obj, true);
   }
 	
   /**
      Adds a node, decorated with obj, to this binary tree.
	  The new node becomes the root of the tree; the left subtree of the root will be empty; 
	  the former tree becomes the right subtree of the root.
   */
   public boolean alternateAdd ( Object obj ) {
      return this.supremeAdd(obj, false);
   }
   
   /**
      Static factory for constructing new binary trees.
	  The root of the new tree will be decorated with obj; leftSubtree and rightSubtree, respectively, 
	  will become the left and right subtrees of the root.
   */
   public static BinaryTree newFromRootAndTwoTrees ( Object obj, BinaryTree leftSubtree, BinaryTree rightSubtree ) {
      BinaryTree newTree = new BinaryTree(obj);
      int x = 1 + leftSubtree.size() + rightSubtree.size();
      newTree.leftSubtree = leftSubtree;
      newTree.leftSubtree.parentTree = newTree;
      newTree.rightSubtree = rightSubtree;
      newTree.rightSubtree.parentTree = newTree;
      newTree.setSize(x);
      return newTree;
   }
   
	private void setSize (int x) {
      this.size = x;
   }	
   /** Returns a hashcode for this binary tree. */
   public int hashCode () {
      int result = 0;
      int counter = 1001;
      for(Object o : this){
         result += o.hashCode() % counter;
         counter ++;
      }
      return result;
   }

	
   /** Throws an UnsupportedOperationException(). */
   public boolean addAll ( Collection c ) {
      throw new UnsupportedOperationException();
   }

	
   /** Re-initializes this to an empty binary tree. */	
   public void clear () {
      this.object = null;
      this.size = 0;
      this.leftSubtree = null;
      this.rightSubtree = null;
      this.parentTree = null;

      System.gc();
   }

   /**
      Returns true iff this binary tree contains (at least) one example
      of obj.
   */

   public boolean contains ( Object obj ) {
      for (Object o : this) {
         if (o.equals(obj)) {
            return true;
         }
      }
      return false;
   }

   /**
      Returns true iff this binary tree contains at least one example of each DIFFERENT
      object in Collection c. Note that c may contain several examples of some 
      (same) object, but this binary tree is only required to contain one such example.
   */

   public boolean containsAll ( Collection c ) {
      throw new UnsupportedOperationException();
   }

   /**
      Returns true iff this binary tree is equivalent, with respect to both structure and content, 
	  as Object obj.
   */

   public boolean equals ( Object obj ) {
      if(!(obj instanceof BinaryTree) || this.size != ((BinaryTree)obj).size) {
         return false;
      } else {
         BinaryTree compareTree = (BinaryTree)obj;
         
         return treeObjectsAreEqual(this.object, compareTree.object) &&
                treeObjectsAreEqual(this.leftSubtree, compareTree.leftSubtree) &&
                treeObjectsAreEqual(this.rightSubtree, compareTree.rightSubtree);  
      }
   }
   
	private boolean treeObjectsAreEqual (Object one, Object two) {
      if (one == null && two == null) {
         return true;
      } else if (one != null) {
         return one.equals(two);
      }
      return false;
   }

   /** Returns true iff this binary tree is empty. */
   public boolean isEmpty () {
      return (this.size == 0);
   }


	
   /** Returns a preorder iterator for this binary tree. All bets are off if the tree changes during the traversal. */
   public Iterator iterator () {
      return new PreorderIterator(this);
   }

   private class PreorderIterator implements Iterator {
      private Stack<BinaryTree> stack;
      private BinaryTree b;
      private BinaryTree currentTree;

      private PreorderIterator (BinaryTree b) {
         this.stack = new Stack<BinaryTree>();
         this.b = b;
         this.currentTree = null;
      }

      public boolean hasNext () {
         if (b.size == 0) {
            return false;
         }
         if (this.currentTree == null || this.currentTree.leftSubtree != null || this.currentTree.rightSubtree != null || !this.stack.empty()) {
            return true;
         } 

         return false;
      }

      public Object next () {
         if (this.currentTree == null) {
            this.currentTree = this.b;
         } else {
            if (this.currentTree.rightSubtree != null) {
               this.stack.push(this.currentTree.rightSubtree);
            }

            if (this.currentTree.leftSubtree != null) {
               this.currentTree = this.currentTree.leftSubtree;
            } else if (this.currentTree.leftSubtree == null) {
               this.currentTree = this.stack.pop();
            } else if (this.currentTree.leftSubtree == null && this.currentTree.rightSubtree == null) {
               this.currentTree = this.stack.pop();
            } 
         }
         
         return this.currentTree.object;
      }

      public void remove () {

      }
   }

   public Iterator postorderIterator () {
      return new PostorderIterator(this);
   }

   private class PostorderIterator implements Iterator {
      private Stack<BinaryTree> stack;
      private BinaryTree currentTree;
      private BinaryTree lastVisited;

      private PostorderIterator (BinaryTree b) {
         this.stack = new Stack<BinaryTree>();
         this.stack.push(b);
         this.lastVisited = b;
      }

      public Object next () {
         
         this.currentTree = this.stack.pop();
         while (this.currentTree.rightSubtree != lastVisited &&
               ((this.currentTree.leftSubtree != null && this.currentTree.leftSubtree.size != 0 && this.currentTree.leftSubtree != lastVisited) ||
               (this.currentTree.rightSubtree != null && this.currentTree.rightSubtree.size != 0))) {
               if (this.currentTree.leftSubtree != null &&
                  this.currentTree.leftSubtree != lastVisited &&
                  this.currentTree.leftSubtree.size != 0) {
                  this.stack.push(this.currentTree);
                  this.currentTree = this.currentTree.leftSubtree;
                } else {
                  this.stack.push(this.currentTree);
                  this.currentTree = this.currentTree.rightSubtree;
               }
            }

            this.lastVisited = this.currentTree;
            return this.currentTree.object;
        }

        public void remove () {
            //BinaryTree.removeTree(this.currentTree);
        }

        public boolean hasNext () {
            return !this.stack.empty();
        }
   }

   //* Returns an inorder iterator for this binary tree. All bets are off if the tree changes during the traversal. 
   public Iterator inorderIterator () {
      return new InorderIterator(this);
   }

   public class InorderIterator implements Iterator {
      private Stack<BinaryTree> stack;
      private BinaryTree currentTree;
      private BinaryTree b;

      public InorderIterator (BinaryTree b) {
         this.stack = new Stack<BinaryTree>();
         this.b = b;
         this.currentTree = b;
      }

      public boolean hasNext () {
         if (b.size == 0) {
            return false;
         }
         if (this.currentTree != null || !this.stack.empty()) {
            return true;
         } 

         return false;
      }

      public Object next () {
         while (this.currentTree != null) {
            this.stack.push(this.currentTree);
            this.currentTree = this.currentTree.leftSubtree;
         }

         this.currentTree = this.stack.pop();
         Object result = this.currentTree.object;
         this.currentTree = this.currentTree.rightSubtree;
         return result;
      }

      public void remove () {

      }
   }

   /**
      Removes a matching object from this binary tree, and returns true,  
      provided that the matching object is at a leaf; if there is no matching leaf,
	   then the method returns false.
   */
   public boolean remove ( Object obj ) {
      BinaryTree.PreorderIterator it = new PreorderIterator(this);
      while (it.hasNext()) {
         Object tempObj = it.next();
         if (tempObj.equals(obj)) {
            if (BinaryTree.setParentTreeToRemoveSon(it.currentTree, obj)) {
               this.size--;
               return true;
            }
         }
      }
      return false;
   }

   private static boolean setParentTreeToRemoveSon (BinaryTree b, Object obj) {
      BinaryTree parent = b.parentTree;
      if (parent.leftSubtree.object.equals(obj) &&  
          BinaryTree.isLeaf(parent.leftSubtree)) {

         parent.leftSubtree = null;
         return true;

      } else if (parent.rightSubtree.object.equals(obj) && 
                 BinaryTree.isLeaf(parent.rightSubtree)) {
         
         parent.rightSubtree = null;
         return true;

      }

      return false;
   }

   private static boolean isLeaf (BinaryTree b) {
      return b.leftSubtree == null && b.rightSubtree == null;
   }
	
   /** Throws an UnsupportedOperationException. */
   public boolean removeAll ( Collection c ) {
      throw new UnsupportedOperationException ();
   }

	
   /** Throws an UnsupportedOperationException(). */
   public boolean retainAll ( Collection c ) { // overrides Collection
      throw new UnsupportedOperationException ();
   }

	
   /** Returns the number of nodes in this binary tree. */
   public int size () {
      return this.size;
   }

   /** Throws an UnsupportedOperationException(). */
   public Object[] toArray () {
      throw new UnsupportedOperationException ();
   }

   /** Throws an UnsupportedOperationException(). */
   public Object[] toArray ( Object[] a ) {
      throw new UnsupportedOperationException ();
   }

   /** 
   Adds a node, decorated with obj, to this binary tree. If the second parameter is true, the former tree 
   becomes the left subtree. If the second parameter is false, the former tree becomes the right subtree. 
   THIS always refers to the top most root.
   */
   private boolean supremeAdd (Object obj, boolean addToLeft) {
      if (this.size == 0) {
         this.object = obj;
      } else {
         BinaryTree duplicateTree = new BinaryTree(this.object);
         duplicateTree.leftSubtree = this.leftSubtree;
         if (duplicateTree.leftSubtree != null) {
            duplicateTree.leftSubtree.parentTree = duplicateTree;
         }
         duplicateTree.rightSubtree = this.rightSubtree;
         if (duplicateTree.rightSubtree != null) {
            duplicateTree.rightSubtree.parentTree = duplicateTree;
         }

         if (addToLeft) {
            this.leftSubtree = duplicateTree;
            this.rightSubtree = null;
         } else {
            this.leftSubtree = null;
            this.rightSubtree = duplicateTree;
         }
         duplicateTree.parentTree = this;
         this.object = obj;
      }
      this.size++;

      return true;
   }
}











