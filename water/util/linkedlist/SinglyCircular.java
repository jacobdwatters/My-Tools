/**
 * @author Jacob Watters
 */

package water.util.linkedlist;

import water.util.Node;

public class SinglyCircular<T extends Comparable<T>> extends Node<T> implements LinkedList<T>{
	
	private Node<T> current = null;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	
	public T get(int index) {
		int count = 0;
		boolean error = false;
		String message = "Index Out Of Bounds";
		
		current = head;
		
		if(index == 0) {
			if(current == null) { //Shows that list is empty.
				error = true;
				message += " (List Empty)";
			} //If the index is zero and the list is NOT empty, then we do nothing (current already equals head).
			
		} else if(index > 0) {
			
			while(count < index) { //Walks to tail of list. Will wrap around to head if index is larger than list length
				count++;
				current = current.getNext();
			}
			
			if(current == null) { //Node does not exist
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
	
	public void insert(T data) { //inserts new Node at end of list
		
		if(head == null) {
			head = new Node<T>(data);
			tail = head;
			tail.setNext(head);
		}
		else {
			Node<T> newNode = new Node<T>(data);
			
			tail.setNext(newNode);
			tail = newNode;
			newNode.setNext(head);
		}
	}
	
	
	public void insert(T data, int index) { //inserts new node at specified index (Beginning with 0).
		int count = 0;
		boolean error = false;
		Node<T> newNode = new Node<T>(data);
		
		current = head;
		
		if(index == 0) {
			if(head == null) {
				head = tail = newNode;
				head.setNext(tail);
				tail.setNext(head);
			}
			else {
				newNode.setNext(head);
				head = newNode;
				tail.setNext(newNode);
			}
		}
		else if(index > 0) {
			while(count < index-1 && current != tail) { // Walks to index 1 before the specified index
				count++;
				current = current.getNext();
			}
			
			if (current != tail) {
				if(current.getNext() != tail) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
				} else {
					current.setNext(newNode);
					tail = newNode;
					tail.setNext(head);
				}	
			} else if(current == tail) {
				current.setNext(newNode);
				tail = newNode;
				tail.setNext(head);
			} else { // Node does not exist
				error = true;
			}
		} else { // Position is not a positive integer
			error = true;
		}
		
		if (error){ 
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
	
	
	/* When deleting, If the user enters a index greater than the number of nodes, it will
	 * wrap around to the beginning of the list and continue walking up the list.
	 *  **NOTE: This is only true for circular linked lists**
	 */
	public void delete(int index) { // Deletes node at specified index (Starting from 0).
		int count = 0;
		boolean error = false;
		
		current = head;
		
		if(index == 0) {
			if(head == null) { // Specified node does not exist. List is empty.
				error = true;
			} else if(head.getNext() != head) { 
				head = current.getNext();
				tail.setNext(head);
			} else {	 // The head is the only node in the list
				head = null;
			}
		}
		else if(index > 0) {
			while(count < index-1) { // Walks to index 1 before specified index.
				count++;
				current = current.getNext();
			}
			if(current == tail) { // Then we delete head
				if(head == null) {
					error = true;
				} else {
					head = current.getNext();
					tail.setNext(head);
				}
			} else if(current.getNext() == tail) { // Then we delete tail
				current.setNext(head);
				tail = current;
			} else {
				current.setNext(current.getNext().getNext());
			}
		} else {
			error = false;
		}
		
		if(error) {
			throw new NullPointerException("Invalid Position. Out of bounds");
		}
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
	
	
	// TODO
	public T[] toArray(T[] type, int size) {
		T[] arr = null;
		
		return arr;
	}
	
	
	// TODO
	public boolean isSorted() {
		return true;
	}
	
	
	public void clear() { // Clears entire list
		head = tail = null;
	}
	
	
	public String toStringReverse() {
		return null;
	}
	
	
	public T[] getMatching(String regex) { // Returns node(s) with data matching 
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

	
	public boolean contains(T data) {
		boolean result = false;
		
		if(!isEmpty()) {
			if(head.getData() == data) {
				result = true;
			} else {
				current = head.getNext();
				
				while(current != head) {
					if(current.getData() == data) {
						result = true;
						break;
					}
					
					current = current.getNext();
				}
			}
		}
		
		return result;
	}
	
	
	public boolean isEmpty() {
		boolean result = false;
		
		if(size() == 0) {
			result = true;
		}
		
		return result;
	}
	
	
	// TODO
	public void sort() {
		
	}
	
	
	public String toString() {
		String listAsString = "Head -> ";
		
		if(head != null) {
			current = head;
			
			while(current.getNext() != head) { // Walks to tail of list
				listAsString += current.getData() + " -> ";
				current = current.getNext();
			}
			listAsString += current.getData() + " -> ";
		}
		
		return listAsString + "Tail -> Head -> ...";
	}
	
	
	// ** FOR TESTING ONLY ** //
	public static void main(String[] args) {	
		SinglyCircular<String> list = new SinglyCircular<>();

		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.insert("d");
		list.insert("e");
		list.insert("f");
		list.insert("g");
		System.out.println(list);
		System.out.println("List Size: " + list.size());
		
		System.out.println("Data At Position 4: " + list.get(4));
		
		list.clear();
		System.out.println(list);
		System.out.println("List Size: " + list.size());
		
		
		list.insert("3", 0);
		list.insert("2", 0);
		list.insert("1", 0);
		System.out.println(list);
		
		list.delete(1);
		System.out.println(list);
		
		System.out.println("List Size: " + list.size());
		
		System.out.println("list contains 3: " + list.contains("3"));
		System.out.println("list contains 2: " + list.contains("2"));
	}
}
