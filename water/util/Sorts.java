package water.util;

/**
 * @author Jacob Watters
 * Created on 21 August 2019
 * 
 * This class allows for generic objects to be sorted using common sorting algorithms.
 * Each sorting method is overloaded to also sort integers. This is the best way to ensure
 * numbers are sorted in a way the user would expect
 */


public class Sorts implements Sorting  {
	
	/**
	 * Sorts integers using bubble sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Exchanging,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	public int[] bubble(int[] arr) {
		boolean swapped = false;
		
		for(int i = 0; i < arr.length-1; i++) {		
			swapped = false;
			
			for(int j = 0; j <  arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					arr = swap(arr, j, j+1);
					swapped = true;
				}
			}
			
			if(!swapped) {
				break;
			}
		}
		
		return arr;
	}

	
	/**
	 * Sorts strings lexicographically using bubble sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Exchanging,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	public String[] bubble(String[] arr) {
		boolean swapped = false;
		
		for(int i = 0; i < arr.length-1; i++) {		
			
			
			for(int j = 0; j < arr.length-1; j++) {
				swapped = false;
				
				if(arr[j].compareTo(arr[j+1]) > 0) {
					arr = swap(arr, j, j+1);
					swapped = true;
				}
				
				if(!swapped) {
					break;
				}
			}
		}
		
		return arr;
	}

	
	/**
	 * Sorts integers using selection sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n^2).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Selection,
	 * Class: 	Comparison Sort,
	 * Stable: 	No.
	 * 
	 * @return sorted arr
	 */
	public int[] selection(int[] arr) {
		
		int minIndex; 
		
		for(int i = 0; i < arr.length-1; i++) {
			
			minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) { 
					minIndex = j;
				}
			}
			
			arr = swap(arr, minIndex, i);	
		}
		
		return arr;
	}

	
	/**
	 * Sorts strings lexicographically using selection sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n^2).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Selection,
	 * Class: 	Comparison Sort,
	 * Stable: 	No.
	 * 
	 * @return sorted arr
	 */
	public String[] selection(String[] arr) {
		int minIndex; 
		
		for(int i = 0; i < arr.length-1; i++) {
			
			minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j].compareTo(arr[minIndex]) < 1) { 
					minIndex = j;
				}
			}
			
			arr = swap(arr, minIndex, i);	
		}
		
		return arr;
	}

	
	/**
	 * Sorts integers using insertion sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Insertion,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	public int[] insertion(int[] arr) {
		int key, j;
		
        for (int i = 1; i < arr.length; i++) { 
            key = arr[i]; 
            j = i - 1; 
  
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            
            arr[j + 1] = key; 
        } 
		
		return arr;
	}

	
	/**
	 * Sorts strings lexicographically using insertion sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(n^2),
	 * 		Average Case -  O(n^2),
	 * 		Best Case - O(n).
	 * 
	 * Space:
	 * 		O(1).
	 * 
	 * Method: 	Insertion,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	public String[] insertion(String[] arr) {
		
		for (int i = 1; i < arr.length; i++) { 
            String key = arr[i]; 
            int j = i - 1; 
  
            while (j >= 0 && arr[j].compareTo(key) > 1) { 
                arr[j + 1] = arr[j]; 
                j--; 
            } 
            
            arr[j + 1] = key; 
        } 
		
		return arr;
	}

	
	/**
	 * Sorts integers using merge sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(nlog(n)),
	 * 		Average Case -  O(nlog(n)),
	 * 		Best Case - O(nlog(n)).
	 * 
	 * Space:
	 * 		O(n).
	 * 
	 * Method: 	Merging,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	private int[] merge(int arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        
        int i = 0, j = 0; 
        int k = l; 
        
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
        return arr;
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    private int[] merge(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            arr = merge(arr, l, m); 
            arr = merge(arr , m+1, r); 
  
            // Merge the sorted halves 
            arr = merge(arr, l, m, r); 
        } 
        
        return arr;
    } 
    
    public int[] merge(int[] arr) {
    		return merge(arr, 0, arr.length-1);
    }
    
	/**
	 * Sorts strings lexicographically using merge sort.
	 * 
	 * Time: 
	 * 		Worst Case - O(nlog(n)),
	 * 		Average Case -  O(nlog(n)),
	 * 		Best Case - O(nlog(n)).
	 * 
	 * Space:
	 * 		O(n).
	 * 
	 * Method: 	Merging,
	 * Class: 	Comparison Sort,
	 * Stable: 	Yes.
	 * 
	 * @return sorted arr
	 */
	private String[] merge(String arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        String L[] = new String[n1]; 
        String R[] = new String[n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1 + j]; 
        
        int i = 0, j = 0; 
        int k = l; 
        
        while (i < n1 && j < n2) { 
            if (L[i].compareTo(R[j]) < 1) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
        return arr;
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    private String[] merge(String arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            arr = merge(arr, l, m); 
            arr = merge(arr , m+1, r); 
  
            // Merge the sorted halves 
            arr = merge(arr, l, m, r); 
        } 
        
        return arr;
    } 
    
    
    /**
     * 
     * 
     * @param arr - array to be sorted
     */
    public String[] merge(String[] arr) {
    		return merge(arr, 0, arr.length-1);
    }
	
    
    /**
     * Partitions array int to sub arrays
     * 
     * @param arr
     * @param low
     * @param high
     * @return
     */
	private int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                swap(arr, i, j);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        swap(arr, i+1, high);
  
        return i+1; 
    } 
	
	
	/**
	 * 
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
    public int[] quick(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pivot = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // Partition and after partition 
            quick(arr, low, pivot-1); 
            quick(arr, pivot+1, high); 
        } 
        
        return arr;
    } 
    
    public int[] quick(int[] arr) {
    		return quick(arr, 0, arr.length-1);
    }

	
	private int partition(String arr[], int low, int high) 
    { 
        String pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j].compareTo(pivot) < 1) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                String temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        String temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
	
	
	/**
	 * Sorts strings lexicographically using quick sort.
	 * 
	 * Time: 
	 * 		Worst Case - ???
	 * 		Average Case -  ???
	 * 		Best Case - ???
	 * 
	 * Space:
	 * 		???.
	 * 
	 * Method: 	???,
	 * Class: 	???,
	 * Stable: 	???.
	 * 
	 * @return sorted list
	 */
    public String[] quick(String arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pivotIndex = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // Partition and after partition 
            quick(arr, low, pivotIndex-1); 
            quick(arr, pivotIndex+1, high); 
        } 
        
        return arr;
    } 
    
    public String[] quick(String[] arr) {
    		return quick(arr, 0, arr.length-1);
    }
	
	
    /**
     * Swaps items at indexOne and indexTwo in arr
     * 
     * @param arr
     * @param indexOne
     * @param indexTwo
     * @return
     */
	public int[] swap(int[] arr, int indexOne, int indexTwo) {
		int temp = arr[indexOne];
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = temp;
		
		return arr;
	}
	
	
    /**
     * Swaps items at indexOne and indexTwo in arr
     * 
     * @param arr
     * @param indexOne
     * @param indexTwo
     * @return
     */
	public String[] swap(String[] arr, int indexOne, int indexTwo) {
		String temp = arr[indexOne];
		arr[indexOne] = arr[indexTwo];
		arr[indexTwo] = temp;
		
		return arr;
	}

	
	/**
	 * Sorts integer array in ascending order.
	 */
	// ** TODO: Allow for sorting in descending ** //
	public int[] sort(int[] arr, String... args) {
		
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("merge")) {
				arr = merge(arr);
			}
			else if(args[0].equalsIgnoreCase("quick")) {
				arr = quick(arr);
			}
			else if(args[0].equalsIgnoreCase("selection")) {
				arr = selection(arr);
			}
			else if(args[0].equalsIgnoreCase("insertion")) {
				arr = insertion(arr);
			}
			else if(args[0].equalsIgnoreCase("bubble")) {
				arr = bubble(arr);
			}
		}
		else {
			arr = quick(arr); // Default sorting method
		}
		
		return arr;
	}

	
	/**
	 * Sorts String array lexicographically in ascending order.
	 */
	// ** TODO: Allow for sorting in descending ** //
	public String[] sort(String[] arr, String... args) {
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("merge")) {
				arr = merge(arr);
			}
			else if(args[0].equalsIgnoreCase("quick")) {
				arr = quick(arr);
			}
			else if(args[0].equalsIgnoreCase("selection")) {
				arr = selection(arr);
			}
			else if(args[0].equalsIgnoreCase("insertion")) {
				arr = insertion(arr);
			}
			else if(args[0].equalsIgnoreCase("bubble")) {
				arr = bubble(arr);
			}
		}
		else {
			arr = quick(arr); // Default sorting method
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		Sorts s1 = new Sorts();
		String output = "";
		
		String[] arr = {"c", "b", "a", "e", "d"};
		//int[] arr = {2, 10, 6, 9, 4, 1, 7, 3, 5, 8};
		   
		// arr = s1.bubble(arr);
		// arr = s1.selection(arr);
		arr = s1.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			output += arr[i] + ", ";
		}
		
		output = output.substring(0, output.length()-2);
		System.out.printf("List: %s", output);
	}
}
