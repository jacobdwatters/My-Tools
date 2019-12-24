/**
 * @author Jacob Watters
 *
 */

package water.util;

public interface Sorting {
	public int[] bubble(int[] list);
	public String[] bubble(String[] list);
	public int[] selection(int[] list);
	public String[] selection(String[] list);	
	public int[] insertion(int[] list);
	public String[] insertion(String[] list);	
	public int[] merge(int[] list);
	public String[] merge(String[] list);	
	public int[] quick(int[] list);
	public String[] quick(String[] list);	
	public int[] sort(int[] list, String... args);
	public String[] sort(String[] list, String... args);
}
