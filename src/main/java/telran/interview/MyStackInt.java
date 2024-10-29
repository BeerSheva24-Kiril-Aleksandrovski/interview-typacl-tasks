package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

//All methods should have complexity O[1]
public class MyStackInt {
	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> listMax = new LinkedList<>();

	public void push(int num) {
		list.push(num);

		if (listMax.isEmpty() || listMax.peek() <= num) {
			listMax.push(num);
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		if (listMax.peek().equals(list.peek())) {
			listMax.pop();
		}
		return list.pop();
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return list.peek();

	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int getMaxElement() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return listMax.peek();
	}
}
