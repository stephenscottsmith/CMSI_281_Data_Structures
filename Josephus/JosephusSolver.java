
import java.util.Iterator;

public class JosephusSolver {
	public static void main(String[] args) {
		// Test the input
		int numberOfPeople;
		int skipFactor;
		try {
			numberOfPeople = Integer.parseInt(args[0]);
			skipFactor = Integer.parseInt(args[1]);
		} catch (Exception e) {
			throw new IllegalArgumentException("The input values should be 2 integers!\n" +
											   "The first number should be greater than or equal to 1.\n" +
											   "The second number should be greater than or equal to 0.\n");
		}
		
		// Create list and add the number of people as individual node objects
		CircularList list = new CircularList();
		for (int i = 1; i <= numberOfPeople; i++) {
			list.add(new Integer(i));
		}


		// Create an iterator object, remove by 
		CircularList.ObjIterator it = list.objIterator();
		while (list.size() > 1) {
			for (int i = 1; i <= skipFactor; i++) {
				it.previous();
			}
			it.remove();
			it.previous();
		}
		System.out.println((Integer)it.getCurrent());
	}
}