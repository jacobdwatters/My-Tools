/**
 * @author Jacob Watters
 */

package water.util.linkedlist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import water.util.Node;

public class Singly<T extends Comparable<T>> extends Node<T> implements LinkedList<T> {
	
	private final String NULL_POINTER_EXEPTION_MESSAGE = "Invalid Position. Out of bounds";
	private Node<T> current = null;
	private Node<T> head = null;
	
	
	/**
	 * Gets node from specified index
	 * 
	 * @param index
	 */
	public T get(int index) {
		int count = 0;
		boolean error = false;
		String message = "";
		
		
		if(head == null) {
			error = true;
			message = " (List Empty)";
		}
		else if(index >= size()) {
			message = " (Given index " + index + " while  list Size is )" + size() ;
		}
		else if(index == 0) {
			return head.getData();
		}
		else {
			
			current = head;
			
			while(count < index) {
				count++;
				current = current.getNext();
			}
			
			if(current == null) { // Node does not exist
				error = true;
				message = " (Item does not exist)";
			}
			
		}
		
		if(error) {
			throw new NullPointerException(NULL_POINTER_EXEPTION_MESSAGE + message);
		}
		
		return current.getData();
	}
	
	/**
	 * Inserts new Node at end of list
	 * 
	 * @param data
	 */
	public void insert(T data) {
		
		if(head == null) {
			head = new Node<T>(data);
		}
		else {
			current = head;
			
			while(current.getNext() != null) { //Walks to end of list
				current = current.getNext();
			}
			
			current.setNext(new Node<T>(data));
		}
	}
	
	/**
	 * Inserts new node at specified index (Beginning with 0).
	 * 
	 * @param data - content to be inserted
	 * @param index - index for content to be inserted at
	 */
	public void insert(T data, int index) {
		int count = 0;
		boolean error = false;
		
		current = head;
		
		if(index == 0) {
			Node<T> newNode = new Node<T>(data);
			
			if(head.getNext() != null) {
				newNode.setNext(head);
				head = newNode;
			}
			else {
				head = newNode;
			}
		}
		else if(index > 0) {
			while(count < index-1) { //walks to specified index in list
				count++;
				current = current.getNext();
			}
			
			if (current != null) {
				Node<T> newNode = new Node<T>(data);
				
				if(current.getNext() != null) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
				}
				else {
					current.setNext(newNode);
				}	
			}
			else {
				error = true;
			}
		}	
		else {
			error = true;
		}
		
		if (error){
			throw new NullPointerException(NULL_POINTER_EXEPTION_MESSAGE);
		}
	}
	
	/**
	 * Allows for bulk insertion
	 * 
	 * @param dataArr
	 */
	public void insert(T[] data) {
		for(int i = 0; i < data.length; i++) {
			insert(data[i]);
		}
	}
	
	/**
	 * Removes node at specified index
	 * 
	 * @param index
	 */
	public void delete(int index) {
		int count = 0;
		boolean error = false;	
		
		if(index == 0) {
			if(head == null) {
				error = true;
			}
			else {
				if(head.getNext() == null) {
					head = null;
				}
				else {
					head = head.getNext();
				}
			}
		}
		else if(index > 0) {
			current = head;
			
			while(count < index-1) { // Walks to specified index in list
				count++;
				current = current.getNext();
			}
			
			if(current.getNext() != null) {
				if(current.getNext().getNext() == null) {
					current.setNext(null);
				}
				else {
					current.setNext(current.getNext().getNext());
				}
			}
			else {
				error = true;
			}
		}
		else {
			error = true;
		}
		
		if(error) {
			throw new NullPointerException(NULL_POINTER_EXEPTION_MESSAGE);
		}
	}
	
	/**
	 * Clears all items from list
	 */
	public void clear() {
		head = null;
	}

	/**
	 * @return int - number of elements in list
	 */
	public int size() {
		int count = 0;
		
		if(head != null) {
			current = head;
			
			while(current != null) { //Walks list
				current = current.getNext();
				count++;
			}
		}

		return count;
	}
	
	
	/**
	 * Converts list to array of type T
	 * 
	 * @param data
	 * @param size
	 * 
	 * @return T[] - array of items in list
	 */
	public T[] toArray(T[] data, int size) { 
		
		@SuppressWarnings("unchecked")
		final T[] arr = (T[]) Array.newInstance(data.getClass().getComponentType(), size);
		
		for(int i = 0; i < size; i++) {
			arr[i] = get(i);
		}
		
		return arr;
	}
	
	
	/**
	 * Checks if list is sorted.
	 * 
	 * @return boolean - if list is sorted
	 */
	public boolean isSorted() {
		boolean result = true;
		
		if(head == null || head.getNext() == null) {
			result = true;
		}
		else {
			current = head;
			
			while(current.getNext() != null) {
				if(current.getData().compareTo(current.getNext().getData()) >= 0) {
					result = false;
					break;
				}
				
				current = current.getNext();
			}
		}
		
		return result;
	}
	
	
	/**
	 * gets items in list matching a regular expression
	 * 
	 * @param regex - regular expression
	 * @return T[] - items matching regex
	 */
	@SuppressWarnings("unchecked")
	public T[] getMatching(String regex) {
		ArrayList<T> matching = new ArrayList<>();
		
		current = head;
		
		while(current.getNext() != null) { //Walks to end of list
			if(current.getData().toString().matches(regex)) {
				matching.add(current.getData());
			}
			
			current = current.getNext();
		}
		
		return (T[]) matching.toArray();
	}
	
	
	/**
	 * 
	 * 
	 * @param type
	 * @return boolean - if item is contained in list
	 */
	public boolean contains(T data) {
		
		if(head.getData().toString().equals(data.toString())) {
			return true;
		}
		
		current = head;
		
		while(current.getNext() != null) { //Walks to end of list
			current = current.getNext();
			
			if(current.getData().toString().equals(data.toString())) {
				return true;
			}
		}
		
		return false;
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
	
	
	/**
	 * @return String - linked list as string
	 */
	public String toString() {
		String listAsString = "Head -> ";
		
		if(head != null) {
			current = head;
			
			while(current != null) { //Walks to end of list
				listAsString += current.getData() + " -> ";
				current = current.getNext();
			}
		}
		
		return listAsString + "NULL";
	}
	
	
	// ** FOR TESTING ONLY ** //
	public static void main(String[] args) {
		Character[] arr2, arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		Singly<Character> list = new Singly<>();
		Singly<Integer> list1 = new Singly<>();
		
		System.out.println("Running Tests...\n\n");
		
		list.insert('a');
		list.insert('b');
		list.insert('c');
		list.insert('d');
		list.insert('e');
		list.insert('f');
		list.insert('g');
		list.insert('h', 7);
		System.out.println(list + "\nSize: " + list.size() + "\n\n");
		
		list.clear();
		System.out.println(list + "\nSize: " + list.size() + "\n\n");
		
		list.insert(arr);
		System.out.println(list + "\nSize: " + list.size() + "\n\n");
		
		System.out.println("Deleteing from 7...");
		list.delete(7);
		System.out.println(list + "\nSize: " + list.size() + "\n\n");
		
		System.out.println("Value at Node 6: " + list.get(6) + "\n\n"); 
		
		arr2 = list.toArray(new Character[list.size()], list.size());
		
		System.out.print("List as Array: [");
		
		//Prints array
		for(int i = 0; i < arr2.length; i++) {
			
			if(i != arr2.length-1) {
				System.out.print(arr2[i] + ", ");
			}
			else {
				System.out.print(arr2[i] + "]");
			}
		}
		
		System.out.println("\n\nIs the list sorted: " + ((list.isSorted()) ? "Yes" : "No"));
		
		for(int i = 0; i < 5; i++) {
			list1.insert(Integer.valueOf(i));
		}
		
		System.out.println("\n\n" + list1);
		System.out.println("Pop: " + list1.pop() + "\tDequeue: " + list1.dequeue());
		System.out.println(list1);
		list1.push(Integer.valueOf(1));
		list1.queue(Integer.valueOf(5));
		System.out.println("Push: 1 \tQueue: 5 ");
		System.out.println(list1);
		
		System.out.println("Contains 3: " + list1.contains(3) + "\nContains 0: " + list1.contains(0));
	}
}