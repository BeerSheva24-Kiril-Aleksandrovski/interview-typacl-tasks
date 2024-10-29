
package telran.interview;

import java.util.HashMap;
import java.util.Map;

//all methods must have complexity O[1]
public class MyArray<T> {
	T value;
	int size;
	Map<Integer, T> elements = new HashMap<>();

	public MyArray(int size) {
		this.size = size;
	}
	public void setAll(T value) {
			elements = new HashMap<>();
			this.value = value;
	}
	
	public void set(int index, T value) {
		if (index >= size || index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		elements.put(index, value);
	}

	public T get(int index) {
			if (index >= size || index < 0) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return elements.getOrDefault(index, value);
	}
	
	
	
	
}
