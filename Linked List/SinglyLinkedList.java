public class SinglyLinkedList {
	
	// Declaring a head node for the linkedlist
	Node head = null;

	// This is a class inside a class ("Node" class inside "SinglyLinkedList" class).
	// This "Node" class can be declared separately in separate class.
	public class Node {
		
		int value;
		Node next;

		// Creating node using constructor
		Node(int value) {
			this.value = value;
			next = null;
		}
	}

	// Method for inserting new value to the linkedlist
	public SinglyLinkedList insert(SinglyLinkedList list, int value) {
		// Creating a new node using the provided value
		Node newNode = new Node(value);
		
		// Checking if there is already a head node
		// If not, then make the newly created node as the head node
		// If there is already a head node, then insert the newly created node at the end of the linkedlist
		if(list.head == null) {
			list.head = newNode;
		} else {
			Node lastNode = list.head;
			
			while(lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
		}
		
		// Return the updated linkedlist
		return list;
	}
	
	// Method to  print the whole linkedlist
	public void printList(SinglyLinkedList list) {
		// Create a node for traversal, and assign the head node to it
		// So that our traversal starts from the head node  
		Node currentNode = list.head;
		
		// Loop through the whole linkedlist 
		while(currentNode != null) {
			// Print the value of currently traversed node
			System.out.println(""+currentNode.value);
			
			// Move the current node to the next node
			currentNode = currentNode.next;
		}
	}
	
	// Method to remove node by value/key
	public SinglyLinkedList remove(SinglyLinkedList list, int value) {
		// Declare two node, one for traversing between nodes
		// And one for storing the information of previous node
		Node currentNode = null;
		Node previousNode = null;
		
		// Assign head node to the current node
		// So that traversal starts from the head node
		currentNode = list.head;
		
		// If the head node carries the value to be deleted
		if(currentNode != null && currentNode.value == value) {
			// Move the head to the next node, this will result in removal of the head node
			list.head = currentNode.next;
			
			System.out.println("Removed value is : "+currentNode.value);
			
			// Return the updated linkedlist
			return list;
		}
		
		// If the value to be deleted is somewhere else other than at head
		// The loop will continue until it finds the node containing the value to be deleted
		// Or until it reaches the end of linkedlist
		while(currentNode != null && currentNode.value != value) {
			// Store the information of previous node
			previousNode = currentNode;
			
			// Move the traversal node to the next node 
			currentNode = currentNode.next;
		}
		
		// If the value to be deleted is found after executing the above while loop
		if(currentNode != null) {
			System.out.println("Removed value is : "+currentNode.value);
			
			// Connect the previous node of the node that we are going to remove
			// To the next node of node that we are going to remove
			// This  will result in removal of the node that contains the value to be deleted
			previousNode.next = currentNode.next;
			
			// Return the updated linkedlist
			return list;
		}
		
		// If the value to be deleted if not found after executing the above while loop
		if(currentNode == null) {
			System.out.println("The value is not found");
		}
		
		// Return the updated linkedlist
		return list;
	}
	
	// Main method to run and test the code
	public static void main(String[] args) {
		// Creating a instance of the SinglyLinkedList class
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		// Inserting some value
		linkedList.insert(linkedList, 101);
		linkedList.insert(linkedList, 202);
		linkedList.insert(linkedList, 303);
		linkedList.insert(linkedList, 404);
		linkedList.insert(linkedList, 505);
		
		// Printing the linkedlist
		linkedList.printList(linkedList);
		
		// Deleting some values from the linkedlist
		linkedList.remove(linkedList, 101);
		linkedList.remove(linkedList, 303);
		linkedList.remove(linkedList, 505);
		
		// Printing the linkedlist to view the result of value deletion
		linkedList.printList(linkedList);
	}
}
