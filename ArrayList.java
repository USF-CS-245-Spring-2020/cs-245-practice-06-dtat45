import java.lang.reflect.Array;

public class ArrayList<T> implements List<T> {

	protected int size;
	protected T[] arr;
	
	public ArrayList() {
		
		arr=(T[]) new Object[10];
		size=0;
	}

	// Adds the given element to the end of the array
	public void add(T item) {
		
		if(size>=arr.length)
			doubleArray();
		
		arr[size]=item;
		size++;
	}

	// Adds the given element to a specific point in the array
	public void add(int pos, T item) {
		
		if(size>=arr.length)
			doubleArray();
		
		for(int i=size;i>pos;i++) 
			arr[i]=arr[i-1];
		
		arr[pos]=item;
		size++;
	}

	// Returns the element at pos index
	public T get(int pos) {
		
		if(pos<0||pos>=size)
			return null;
		return arr[pos];
	}

	// Removes the element at pos index
	public T remove(int pos) {
		
		T temp=arr[pos];
		
		size--;
		for(int i=pos;i<size;i++)
			arr[i]=arr[i+1];
		
		return temp;
	}

	public int size() {
		
		return size;
	}
	
	// Doubles the size of the array
	public void doubleArray() { 
		
		T[] temp=(T[]) new Object[size*2];
		
		// Copies elements from the initial array to a larger array
		for(int i=0;i<size;i++) 
			temp[i]=arr[i];
		arr=temp;
	}
}
