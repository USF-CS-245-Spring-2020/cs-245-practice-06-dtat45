
public class LinkedList<T> implements List<T> {

	protected int size;
	Node head=null;
	
	class Node {
		
		T data;
		Node next;
		Node prev;
		
		// Constructor
		Node(T item) {
			
			data=item;
			next=null;
			prev=null;
		}
	}

	// Adds a node to the end of the linked list
	public void add(T item) {
		
		Node currNode=head;
		Node newNode=new Node(item);
		
		// Sets the new node as the head of the linked list
		// if the list size is zero
		if(size==0)
			head=newNode;
		else {
			
			// Moves to the end of the linked list to add the new node
			while(currNode.next!=null)
				currNode=currNode.next;
			
			currNode.next=newNode;
			newNode.prev=currNode;
		}
		size++;
	}

	// // Adds the given element to a specific point in the linked list
	public void add(int pos, T item) {
		
		Node prevNode=null;
		Node currNode=head;
		Node newNode=new Node(item);
		
		if(head==null)
			head=newNode;
		else {
			for(int i=0;i<pos;i++) {
				
				prevNode=currNode;
				currNode=currNode.next;
			}
			
			if(prevNode!=null)
				prevNode.next=newNode;
			newNode.prev=prevNode;
			newNode.next=currNode;
			if(currNode!=null)
				currNode.prev=newNode;
		}
		size++;
	}

	// Returns the data held in the node at pos index
	public T get(int pos) {
		
		Node currNode=head;
		
		for(int i=0;i<pos;i++)
			currNode=currNode.next;
		
		return currNode.data;
	}

	// Removes the node at pos index
	public T remove(int pos) {
		
		Node currNode=head;
		
		for(int i=0;i<pos;i++)
			currNode=currNode.next;
		
		Node prevNode=currNode.prev;
		Node nextNode=currNode.next;
		
		if(prevNode!=null)
			prevNode.next=nextNode;
		if(nextNode!=null)
			nextNode.prev=prevNode;
		size--;
		
		return currNode.data;
	}

	// Returns the size of the linked list
	public int size() {
		
		return size;
	}
	
	
}
