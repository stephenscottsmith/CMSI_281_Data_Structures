import java.util.Iterator;
public class BinaryTreeTester {
	public static void main(String[] args) {
			
		String output = "";
		
		// 1. This tests to make sure that you can construct a BinaryTree with or without passing in an object
		BinaryTree tree = new BinaryTree();
		
		output = (tree.getObject() == null) ? "PASS 1.0 - NULL OBJECT CONSTRUCTOR" : "XXXXXXXXXX FAIL 1.0 XXXXXXXXXX";
		System.out.println(output);
		output = (tree.size() == 0) ? "PASS 1.1 - NULL CONSTRUCTOR SIZE IS 0" : "XXXXXXXXXX FAIL 1.1 XXXXXXXXXX";
		System.out.println(output);

		// 2. This tests to make sure that adding an object to an empty BinaryTree will result in the object field being redefined and the size 
		//    incrementing by 1
		tree.add(8);
		
		output = (tree.getObject() == 8) ? "PASS 2.0 - NULL OBJECT CONSTRUCTOR ADD OBJECT IS 8" : "XXXXXXXXXX FAIL 2.0 XXXXXXXXXX";
		System.out.println(output);
		output = (tree.size() == 1) ? "PASS 2.1 - NULL OBJECT CONSTRUCTOR ADD OBJECT SIZE IS 1" : "XXXXXXXXXX FAIL 2.1 XXXXXXXXXX";
		System.out.println(output);

		// 3. This tests the add() function (left add)
		tree.add("hello");
		
		output = (tree.getObject() == "hello") ? "PASS 3.0 - LEFT ADD" : "XXXXXXXXXX FAIL 3.0 XXXXXXXXXX";
		System.out.println(output);
		output = (tree.size() == 2) ? "PASS 3.1 - LEFT ADD MAKES SIZE 2" : "XXXXXXXXXX FAIL 3.0 XXXXXXXXXX";
		System.out.println(output);

		// 4. This tests the alternateAdd() function (right add)
		tree = new BinaryTree("HI");
		
		tree.alternateAdd("HELLO");
		output = (tree.getObject() == "HELLO") ? "PASS 4.0 - ALTERNATE ADD" : "XXXXXXXXXX FAIL 4.0 XXXXXXXXXX";
		System.out.println(output);
		output = (tree.size() == 2) ? "PASS 4.1 - RIGHT ADD MAKES 2" : "XXXXXXXXXX FAIL 4.1 XXXXXXXXXX";
		System.out.println(output);

		tree.alternateAdd("BINGO");
		output = (tree.getObject() == "BINGO") ? "PASS 4.2 - ALTERNATE ADD" : "XXXXXXXXXX FAIL 4.2 XXXXXXXXXX";
		System.out.println(output);
		output = (tree.size() == 3) ? "PASS 4.3 - RIGHT ADD MAKES 3" : "XXXXXXXXXX FAIL 4.3 XXXXXXXXXX";
		System.out.println(output);

		output = (tree.getObject() == "BINGO") ? "PASS 4.4 - TOP IS BINGO" : "XXXXXXXXXX FAIL 4.4 XXXXXXXXXX";
		System.out.println(output);
		
		output = (tree.rightSubtree.getObject() == "HELLO") ? "PASS 4.5 - TOP RIGHT IS HELLO" : "XXXXXXXXXX FAIL 4.5 XXXXXXXXXX";
		System.out.println(output);

		output = (tree.rightSubtree.rightSubtree.getObject() == "HI") ? "PASS 4.6 - TOP RIGHT RIGHT IS HI" : "XXXXXXXXXX FAIL 4.6 XXXXXXXXXX";
		System.out.println(output);

		System.out.println("PARENT: " + tree.rightSubtree.rightSubtree.parentTree.object);

		// 5. This tests the newFromRootAndTwoTrees() function using all 3 types of iterators
		BinaryTree tree1 = new BinaryTree("E");
		BinaryTree tree2 = new BinaryTree("C");
		BinaryTree tree3 = BinaryTree.newFromRootAndTwoTrees("D", tree2, tree1);
		BinaryTree tree4 = new BinaryTree("A");
		BinaryTree tree5 = BinaryTree.newFromRootAndTwoTrees("B", tree4, tree3);

		BinaryTree tree6 = new BinaryTree("H");
		System.out.println("Tree6 (problem?): " + tree6.toString());
		tree6.add("I");
		System.out.println(tree6.toString());
		System.out.println(tree6.leftSubtree.parentTree == tree6);
		tree6.alternateAdd("G");
		System.out.println(tree6.toString());
		System.out.println(tree6.rightSubtree.leftSubtree.parentTree == tree6.rightSubtree);

		System.out.println("fasdfasdfasdfasdf");

		System.out.println(tree6.rightSubtree.object);
		System.out.println(tree6.rightSubtree.parentTree.object);
		System.out.println(tree6.rightSubtree.leftSubtree.parentTree.object);
		System.out.println(tree6.rightSubtree.leftSubtree.object);

		BinaryTree tree7 = BinaryTree.newFromRootAndTwoTrees("F", tree5, tree6);

		System.out.println("SHOULD GET G: " + tree7.rightSubtree.rightSubtree.parentTree.object);

		// 6. Iterator Tests
		Iterator it = tree7.iterator();
		System.out.println(it.hasNext());
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Iterator it2 = tree7.postorderIterator();
		System.out.println(it2.hasNext());
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}

		Iterator it3 = tree7.inorderIterator();
		System.out.println(it3.hasNext());
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}



		System.out.println(tree7.toString());
		System.out.println(tree7.hashCode());
		System.out.println(tree7.contains("J"));

		BinaryTree tree8 = new BinaryTree("E");
		BinaryTree tree9 = new BinaryTree("C");
		BinaryTree tree10 = BinaryTree.newFromRootAndTwoTrees("D", tree9, tree8);
		BinaryTree tree11 = new BinaryTree("A");
		BinaryTree tree12 = BinaryTree.newFromRootAndTwoTrees("B", tree11, tree10);

		BinaryTree tree13 = new BinaryTree("H");
		tree13.add("I");
		tree13.alternateAdd("G");

		BinaryTree tree14 = BinaryTree.newFromRootAndTwoTrees("F", tree12, tree13);
		System.out.println(tree14.toString());
		System.out.println(tree14.toString().equals(tree7.toString()));
		System.out.println(tree14.size());
		System.out.println(tree14.remove("H"));
		System.out.println(tree14.size());
		System.out.println(tree14.contains("H"));
		//System.out.println("PLEASE" + tree14.equals(tree7));
	}
}