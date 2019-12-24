/**
 * @author Jacob Watters
 */

package water.util.linkedlist;

import water.util.Node;

public class Doubly<T extends Comparable<T>> extends Node<T> implements LinkedList<T>{
	
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
	
	public void insert(T data) { //Inserts new node at end of the list
		Node<T> newNode = new Node<T>(data);
		
		if(head == null) { //Indicates empty list
			head = tail = newNode;
		}
		else { //List is not empty
			current = tail;
			current.setNext(newNode);
			tail = newNode;
			tail.setPrevious(current);
			tail.setNext(null);
		}
	}
	

	public void insert(T[] data) {
		for(int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}
	
	
	// ** TODO: If index is in second half of list, start from tail ** //
	public void insert(T data, int index) { // Inserts new node at specified index within the list
		int count = 0;
		boolean error = false;
		String errorMessage = "";
		Node<T> newNode = new Node<T>(data);
		
		if(index == 0) { // Inserting at head
			if(head != null) {
				head.setPrevious(newNode);
				newNode.setNext(head);
				head = newNode;
			} else { // Empty List
				head = tail = newNode;
			}
			
		} else if(index > 0) {
			current = head;
			
			while(count < index-1) { //walks to specified index in list
				count++;
				current = current.getNext();
			}
			
			if (current != null) {
				if(current.getNext() != null) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					newNode.setPrevious(current);
				} else {
					current.setNext(newNode);
					current.setPrevious(tail);
					tail = newNode;
				}	
			} else {
				error = true;
				errorMessage = "Index Out Of Bounds";
			}
		} else { //Position not valid (Negative).
			error = true;
			errorMessage = "Index Can Not Be Negative";
		}
		
		if(error) {
			throw new NullPointerException(errorMessage);
		}
	}
	
	
	// ** TODO: If index is in second half of list, start from tail ** //
	public void delete(int index) {
		int count = 0;
		boolean error = false;
		String errorMessage = "";
		
		if(index == 0) {
			if(head != null) {
				head = head.getNext();
			} else {
				error = true;
			}
			
		} else if(index > 0) {
			
			current = head;
			
			while(count < index-1) { // Walks to node one index before specified index
				count++;
				current = current.getNext();
			}
			
			if(current.getNext() != null) {
				if(current.getNext().getNext() != null) { // Delete node in middle of list
					current.setNext(current.getNext().getNext());
					current = current.getNext().getNext();
					current.setPrevious(current.getPrevious().getPrevious());
				}
				else { //Delete tail
					tail = tail.getPrevious();
					tail.setNext(null);
				}
			} else {
				error = true;
				errorMessage = "Out Of Bounds";
			}
			
		} else {
			error = true;
			errorMessage = "Index Can Not Be Negative";
		}
		
		if(error) {
			throw new NullPointerException(errorMessage);
		}
	}
	
	
	/**
	 * Clears all items in list
	 */
	public void clear() {
		head = tail = null;
	}
	
	
	/**
	 * @return int - number of elements in list
	 */
	public int size() {
		int count = 0;
		
		if(head != null) {
			current = head;
			
			while(current.getNext() != null) { // Walks list
				current = current.getNext();
				count++;
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
	
	
	public boolean inList(T data) {
		return true;
	}
	
	
	public T[] getMatching(String regex) { // Returns node with data matching 
		T[] matching = null;
		return matching;
	}
	
	
	public String toStringReverse() {
		String listAsString = "Tail <-> ";
		
		current = tail;
		
		while(current != null) { // Traverses list backwards and generate string
			listAsString += current.getData() + " <-> ";
			current = current.getPrevious();
		}
		
		return listAsString + "Head";
	}
	
	
	/**
	 * Inserts item at head
	 * 
	 * @param data item to be inserted
	 */
	public void push(T data) {
		insert(data, 0);
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
		// TODO Auto-generated method stub
		return false;
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
		String listAsString = "Head <-> ";
		
		current = head;
		
		while(current != null) { // Traverses list forwards and generate string
			listAsString += current.getData() + " <-> ";
			current = current.getNext();
		}
		
		return listAsString + "Tail";
	}
	
	
	// ** FOR TESTING ONLY ** //
	public static void main(String[] args) { 
		Doubly<Integer> list = new Doubly<>();
		
		list.insert(0);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		System.out.println(list.toStringReverse() + "\nSize: " + list.size());
		
		list.clear();
		System.out.println(list+ "\nSize: " + list.size());
		
		list.insert(1, 0);
		list.insert(4, 1);
		list.insert(0, 0);
		list.insert(2, 2);
		list.insert(3, 3);
		list.insert(5);
		System.out.println(list+ "\nSize: " + list.size());
		
		list.delete(1);
		System.out.println(list+ "\nSize: " + list.size());
		
		System.out.println("Item at index 3: " + list.get(3));
	}
}