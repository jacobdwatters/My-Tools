/**
 * @author Jacob Watters
 */

package water.util.linkedlist;

import water.util.Node;

public class DoublyCircular<T extends Comparable<T>> implements LinkedList<T>{

	private Node<T> current = null;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	
	// ** TODO: If index is in second half of list, start from tail ** //
	public T get(int index) {
		int count = 0;
		boolean error = false;
		String message = "Index Out Of Bounds";
		
		current = head;
		
		if(index == 0) {
			if(current == null) { //Shows that list is empty.
				error = true;
				message += " (List Tmpty)";
			} //If the index is zero and the list is NOT empty, then we do nothing (current already equals head).
			
		} else if(index > 0) {
			
			while(count < index) { //Walks to tail of list. Will wrap around to head if index is larger than list length
				count++;
				current = current.getNext();
			}
			
			if(current == null) { // Node does not exist
				error = true;
			}
			
		} else {
			error = true;
		}
		
		if(error) {
			throw new NullPointerException(message);
		}
		
		return current.getData();
	}
	
	public void insert(T data) { //Inserts new node at end of the list
		Node<T> newNode = new Node<T>(data);
		
		if(head == null) { //Indicates empty list
			head = tail = newNode;
			head.setNext(tail); 
			head.setPrevious(tail);
			tail.setPrevious(head);
			tail.setNext(head);
		}
		else { //List is not empty
			current = tail;
			current.setNext(newNode);
			tail = newNode;
			tail.setPrevious(current);
			tail.setNext(head);
		}
	}
	
	
	// ** TODO: If index is in second half of list, start from tail ** //
	public void insert(T data, int index) { //Inserts new node at specified index within the list
		int count = 0;
		boolean error = false;
		Node<T> newNode = new Node<T>(data);
		
		if(index == 0) { //Inserting at Head
			if(head != null) {
				head.setPrevious(newNode);
				newNode.setNext(head);
				head = newNode;
				head.setPrevious(tail);
				tail.setNext(head);
			} else { //Empty List
				head = tail = newNode;
				head.setNext(tail);
				tail.setPrevious(head);
			}
			
		} else if(index > 0) {
			current = head;
			
			while(count < index-1 && current != tail) { //walks to specified index in list
				count++;
				current = current.getNext();
			}
			
			if (current != tail) {
				newNode.setNext(current.getNext());
				current.setNext(newNode);
				newNode.setPrevious(current);
			}
			else if(current == tail) {
				current.setNext(newNode);
				tail = newNode;
				tail.setNext(head);
				tail.setPrevious(current);
				head.setPrevious(tail);
			}
			else {
				error = true;
			}
		}	 else { //Position not valid (Negative).
			error = true;
		}
		
		if(error) {
			throw new NullPointerException("Invalid Position. Out of bounds");
		}
	}
	
	/**
	 * Allows for bulk insertion
	 * 
	 * @param data - data to be inserted
	 */
	public void insert(T[] data) {
		for(int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}
	
	
	// ** TODO: If index is in second half of list, start from tail ** //
	public void delete(int index) {
		int count = 0;
		boolean error = false;
		
		if(index == 0) {
			if(head != null) {
				head = head.getNext();
				tail.setNext(head);
				head.setPrevious(tail);
			} else {
				error = true;
			}
			
		} else if(index > 0) {
			
			current = head;
			
			while(count < index-1) { // Walks to node one index before specified index
				count++;
				current = current.getNext();
			}
			
			if(current.getNext() != tail && current.getNext() != head) {
				if(current.getNext() != tail) { //Delete node in middle of list
					current.setNext(current.getNext().getNext());
					current = current.getNext().getNext();
					current.setPrevious(current.getPrevious().getPrevious());
				}
			} 
			else if(current.getNext() == tail) { // Then we delete tail
				tail = tail.getPrevious();
				tail.setNext(head);
				head.setPrevious(tail);
			} 
			else if(current.getNext() == head) { // Wrapped around and now delete from the head
				head = head.getNext();
				tail.setNext(head);
				head.setPrevious(tail);
			}
			else {
				error = true;
			}
			
		} else {
			error = true;
		}
		
		if(error) {
			throw new NullPointerException("Out of Bounds");
		}
	}
	
	public void clear() {
		head = tail = null;
	}
	
	public int size() {
		int count = 1;
		
		current = head;
		
		if(head == null) {
			count = 0;
		} else {
			
			while(current != tail) {
				count++;
				current = current.getNext();
			}
		}
		
		return count;
	}
	
	public T[] toArray(T[] type, int size) {
		T[] arr = null;
		
		return arr;
	}
	
	public boolean isSorted() {
		return true;
	}
	
	
	public boolean isEmpty() {
		boolean result = false;
		
		if(size() == 0) {
			result = true;
		}
		
		return result;
	}
	
	
	// NEED TO TEST
	public boolean contains(T data) {
		boolean result = false;
		
		if(!isEmpty()) {
			if(head.getData() == data || tail.getData() == data) {
				result = true;
			} else {
				Node<T> currentRight = tail.getPrevious();
				Node<T> currentLeft = head.getNext();
				
				while(currentLeft != currentRight && currentLeft.getNext() != currentRight) {
					if(currentLeft.getData() == data || currentRight.getData() == data) {
						result = true;
						break;
					}
					
					currentLeft.setNext(currentLeft.getNext());
					currentRight.setPrevious(currentLeft.getPrevious());
				}
			}
		}
		
		return result;
	}
	
	public T[] getMatching(String regex) { // Returns node/nodes with data matching regular expression
		T[] matching = null;
		return matching;
	}
	
	
	/**
	 * Inserts item at head
	 * 
	 * @param data item to be inserted
	 */
	public void push(T data) {
		this.insert(data, 0);
	}
	

	/**
	 * Removes item at head
	 * 
	 * @return item at head
	 */
	public T pop() {
		T item = this.get(0);
		this.delete(0);
		
		return item;
	}
	
	
	/**
	 * Inserts item at end of list
	 * 
	 * @param data
	 */
	public void queue(T data) {
		this.insert(data, this.size());
	}
	
	
	/**
	 * @return item at front of list
	 */
	public T dequeue() {
		T item = this.get(0);
		this.delete(0);
		
		return item;
	}
	
	
	public String toStringReverse() {
		String listAsString = "Tail <-> ";
		
		if(head != null) {
			current = tail;
			
			while(current != head) { // Traverses list backwards and generate string
				listAsString += current.getData() + " <-> ";
				current = current.getPrevious();
			}
			
			listAsString += current.getData() + " <-> ";
		}
		
		return listAsString + "Head <-> Tail <-> ...";
	}
	
	
	// TODO
	public void sort() {
			
	}
	
	
	public String toString() {
		String listAsString = "Head <-> ";
		
		if(head != null) {
			current = head;
			
			while(current.getNext() != head) { // Traverses list forwards and generate string
				listAsString += current.getData() + " <-> ";
				current = current.getNext();
			}
			
			listAsString += current.getData() + " <-> ";	
		}
		
		return listAsString + "Tail <-> Head <-> ...";
	}
	
	
	// ** FOR TESTING ONLY **//
	public static void main(String[] args) { 
		DoublyCircular<Double> list = new DoublyCircular<>();
		
		list.insert(0.0);
		list.insert(1.3);
		list.insert(2.2);
		list.insert(3.5);
		list.insert(4.6);
		list.insert(5.8);
		System.out.println(list.toStringReverse() + "\nSize: " + list.size());
		
		list.clear();
		System.out.println("\n\n" + list + "\nSize: " + list.size());
		
		list.insert(1.2, 0);
		list.insert(4.6, 1);
		list.insert(0.5, 0);
		list.insert(2.1, 2);
		list.insert(3.8, 3);
		list.insert(5.9);	
		System.out.println("\n\n" + list + "\nSize: " + list.size());
		
		list.delete(3);
		System.out.println("\n\n" + list + "\nSize: " + list.size());
	}
}
