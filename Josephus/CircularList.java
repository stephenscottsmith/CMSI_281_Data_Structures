import java.util.Iterator;

/** WORDS WORDS WORDS */
public class CircularList implements Iterable {
	int size;
	Node firstNode;
	Node lastNode;
	
	public CircularList () {
		this.size = 0;
		// this.numberOfPeople = numberOfPeople;
		// this.firstNode = new Node(numberOfPeople, null, null);
		// this.currentNode = this.firstNode;
		// Node previousNode = firstNode;
		// for (int i = (numberOfPeople - 1); i >= 1; i--) {
		// 	System.out.println("You shouldn't be here if there is only 1 person!");
		// 	Node nodeToAdd = new Node(i, null, previousNode);
		// 	previousNode.next = nodeToAdd;
		// 	previousNode = nodeToAdd;
		// }
		// if (numberOfPeople > 1) {
		// 	previousNode.next = fistNode;
		// 	firstNode.previous = previousNode;
		// }
		
	}

	public boolean add (Object o) {
		if (this.size == 0) {
			this.firstNode = new Node(o, null, null);
			this.lastNode = this.firstNode;
		} else {
			Node previousNode = this.lastNode;
			this.lastNode = new Node(o, this.firstNode, previousNode);
			previousNode.next = this.lastNode;
			this.firstNode.previous = this.lastNode;
		}
		this.size++;
		return true;
	}

	public int size () {
		return this.size;
	}

	public Iterator iterator () {
		return new ObjIterator(this);
	}

	public ObjIterator objIterator () {
		return new ObjIterator(this);
	}

	public class Node {
		private Object object;
		private Node next;
		private Node previous;
		
		public Node (Object object, Node next, Node previous) {
			this.object = object;
			this.next = next;
			this.previous = previous;
		}
	}

	public class ObjIterator implements Iterator {
		private CircularList c;
		private Node currentNode;
		
		public ObjIterator (CircularList c) {
			this.c = c;
			this.currentNode = c.firstNode;
		}

		public Object next () {
			this.currentNode = this.currentNode.next;
			return this.currentNode.object;
		}

		public boolean hasNext () {
			if (c.size != 1 && this.currentNode.next != null) {
				return true;
			} 
			return false;
		}

		public void remove () {
			this.currentNode.previous.next = this.currentNode.next;
			this.currentNode.next.previous = this.currentNode.previous;
			c.size--;
		}

		// Added new method to go in reverse order on the linked list
		public Object previous () {
			this.currentNode = this.currentNode.previous;
			return this.currentNode.object;
		}

		public Object getCurrent () {
			return this.currentNode.object;
		}
	}
}