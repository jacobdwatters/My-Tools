/**
 * @author Jacob Watters
 */

package water.util.linkedlist;


public interface LinkedList<T> {	
	/**
	 * 
	 * @param position
	 * @return
	 */
	public T get(int position);
	
	/**
	 * 
	 * @param data
	 */
	public void insert(T data);
	
	/**
	 * 
	 * @param data
	 */
	public void insert(T[] data);
	
	/**
	 * 
	 * @param data
	 * @param position
	 */
	public void insert(T data, int position);
	
	/**
	 * 
	 * @param position
	 */
	public void delete(int position);
	
	/**
	 * 
	 */
	public void clear();
	
	/**
	 * 
	 * @return
	 */
	public int size();
	
	/**
	 * 
	 * @param data
	 * @param size
	 * @return
	 */
	public T[] toArray(T[] data, int size);
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isSorted();
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	public boolean contains(T data);
	
	/**
	 * 
	 * @param regex
	 * @return
	 */
	public T[] getMatching(String regex);
	
	/**
	 * 
	 * @return
	 */
	public String toString();
	
	/**
	 * 
	 * @param data
	 */
	public void push(T data);
	
	/**
	 * 
	 * @return
	 */
	public T pop();
	
	/**
	 * 
	 * @param data
	 */
	public void queue(T data);
	
	/**
	 * 
	 * @return
	 */
	public T dequeue();
	
	public void sort();
	
	public boolean isEmpty();
}
