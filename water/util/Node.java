package water.util;

public class Node<T extends Comparable <T>> {
	
	private T data;
	private Node<T> next;
	private Node<T> previous;
	
	/**
	 * Constructor for Node object
	 * 
	 * @param data
	 */
	public Node(T data) {	
		this.data = data;
	}
	
	public Node() {
		this.data = null;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void set(T data) {
		this.data = data;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node<T> getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
}
