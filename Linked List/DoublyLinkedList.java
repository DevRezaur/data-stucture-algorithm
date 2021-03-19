public class DoublyLinkedList {

	// Declaring a head node and a tail node for the linked list
	Node head = null;
	Node tail = null;

	// This is a class inside a class ("Node" class inside "DoublyLinkedList" class).
	// This "Node" class can be declared separately in separate class.
	public class Node {

		int value;
		Node next;
		Node previous;

		// Creating node using constructor
		Node(int value) {
			this.value = value;
		}
	}

	// Method for inserting new value to the linked list
	public DoublyLinkedList insert(DoublyLinkedList list, int value) {
		// Creating a new node using the provided value
		Node newNode = new Node(value);

		// Checking if there is already a head node or tail node
		// If not, then make the newly created node as the head node and tail node
		// If there is already a head node or tail node, then insert the newly created node at the end of the linked list
		if (list.head == null && list.tail == null) {
			newNode.previous = null;
			newNode.next = null;

			list.head = newNode;
			list.tail = newNode;
		} else {
			newNode.next = null;
			newNode.previous = list.tail;
			list.tail.next = newNode;
			list.tail = newNode;
		}

		// Return the updated linked list
		return list;
	}

	// Method to print the whole linked list
	public void printList(DoublyLinkedList list) {
		// Create a node for traversal, and assign the head node to it
		// So that our traversal starts from the head node
		Node currentNode = list.head;

		// Loop through the whole linked list
		while (currentNode != null) {
			// Print the value of currently traversed node
			System.out.println("" + currentNode.value);

			// Move the current node to the next node
			currentNode = currentNode.next;
		}
	}

	// Method to reverse print the whole linked list
	public void reversePrintList(DoublyLinkedList list) {
		// Create a node for traversal, and assign the tail node to it
		// So that our traversal starts from the tail node
		Node currentNode = list.tail;

		// Loop through the whole linked list
		while (currentNode != null) {
			// Print the value of currently traversed node
			System.out.println("" + currentNode.value);

			// Move the current node to the previous node
			currentNode = currentNode.previous;
		}
	}

	// Method to remove node by value/key
	public DoublyLinkedList remove(DoublyLinkedList list, int value) {
		// Declare three node, one for traversing between nodes
		// One for storing the information of previous node
		// One for storing the information of next node
		Node currentNode = null;
		Node previousNode = null;
		Node nextNode = null;

		// Assign head node to the current node
		// So that traversal starts from the head node
		currentNode = list.head;

		// If the head node carries the value to be deleted
		if (currentNode != null && currentNode.value == value) {
			// Move the head to the next node, this will result in removal of the head node
			currentNode.previous = null;
			list.head = currentNode.next;
			list.head.previous = null;

			System.out.println("Removed value is : " + currentNode.value);

			// Return the updated linked list
			return list;
		}

		// If the value to be deleted is somewhere else other than at head
		// The loop will continue until it finds the node containing the value to be deleted
		// Or until it reaches the end of linked list
		while (currentNode != null && currentNode.value != value) {
			// Move the traversal node to the next node
			currentNode = currentNode.next;
		}

		// If the value to be deleted is found after executing the above while loop
		// And if it is tail node
		if (currentNode != null && currentNode == list.tail) {
			System.out.println("Removed value is : " + currentNode.value);

			// Make the previous node of tail node new tail node
			previousNode = currentNode.previous;
			previousNode.next = null;
			tail = previousNode;

			return list;
		}

		// If the value to be deleted is found after executing the above while loop
		// And if it is not head node not tail node
		if (currentNode != null) {
			System.out.println("Removed value is : " + currentNode.value);

			// Connect the previous node of the node that we are going to remove
			// To the next node of node that we are going to remove
			// Also connect vice versa for two way connection
			// This will result in removal of the node that contains the value to be deleted
			previousNode = currentNode.previous;
			nextNode = currentNode.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			// Return the updated linkedlist
			return list;
		}

		// If the value to be deleted if not found after executing the above while loop
		if (currentNode == null) {
			System.out.println("The value is not found");
		}

		// Return the updated linked list
		return list;
	}

	// Main method to run and test the code
	public static void main(String[] args) {
		// Creating a instance of the DoublyLinkedList class
		DoublyLinkedList linkedList = new DoublyLinkedList();

		// Inserting some value
		linkedList.insert(linkedList, 101);
		linkedList.insert(linkedList, 202);
		linkedList.insert(linkedList, 303);
		linkedList.insert(linkedList, 404);
		linkedList.insert(linkedList, 505);

		// Printing the linked list
		System.out.println("The linked list in straigt order:");
		linkedList.printList(linkedList);

		System.out.println("The linked list in reverse order:");
		linkedList.reversePrintList(linkedList);

		// Deleting some values from the linked list
		linkedList.remove(linkedList, 101);
		linkedList.remove(linkedList, 303);
		linkedList.remove(linkedList, 505);

		// Printing the linked list to view the result of value deletion
		System.out.println("The linked list in straigt order after deletion:");
		linkedList.printList(linkedList);

		// Printing the linked list in reverse order to view the result of value
		// deletion
		System.out.println("The linked list in reverse order after deletion:");
		linkedList.reversePrintList(linkedList);
	}
}
