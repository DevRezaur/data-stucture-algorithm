/* This code shows how to manually implement queue data structure
 * using ArrayList in Java
 */

import java.util.ArrayList;
import java.util.List;

public class ManualQueue {

	private List<Object> queue = new ArrayList<Object>();

	public int size() {
		return queue.size();
	}

	public Boolean isEmpty() {
		if (queue.isEmpty()) {
			return true;
		} else
			return false;
	}

	public void enqueue(Object value) {
		queue.add(value);
	}

	public Object dequeue() {
		Object value = null;

		if (queue.isEmpty()) {
			System.out.println("The Queue Is Empty");
		} else {
			value = queue.get(0);
			queue.remove(0);
		}
		return value;
	}

	public static void main(String[] args) {
		ManualQueue manualQueue = new ManualQueue();

		manualQueue.enqueue("ABCD");
		manualQueue.enqueue("XYZ");
		manualQueue.enqueue(2020);
		manualQueue.enqueue(10.55);
		manualQueue.enqueue("Hellow");
		manualQueue.enqueue("World");

		while (!manualQueue.isEmpty()) {
			System.out.println("" + manualQueue.dequeue());
		}
	}
}
