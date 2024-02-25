import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

@SuppressWarnings("unused")
public class MyStack implements StackADT {
	Square[] stack;
	int size; 
	
	MyStack() {
		stack = new Square[1];
	}
	
	MyStack(int initCap) {
		this.size = initCap;
		stack = new Square[size];
		
	}
	
	public Square peek() {
		if (this.isEmpty() == true) {
			throw new EmptyStackException();
		} else {
			return stack[size - 1];
		}
	}

	public Square pop() {
		if (this.isEmpty() == true) {
			throw new EmptyStackException();
		} else {
			Square temp = stack[size - 1];
			stack[size - 1] = null;
			size--;
			return temp;
	    }
	}
	
	public void push(Square item) {
		if (size >= stack.length) {
			doubleCapacity();
		}
		stack[size] = item;
		size++;
	}
	
	private void doubleCapacity() {
		Square[] newList = new Square[size * 2];
		for(int i = 0; i < size; i++) {
			newList[i] = stack[i];
		}
		stack = newList;
	}
	
    public int size() {
    	return size;
    }
    
    public boolean isEmpty() {
    	if (size == 0) {
    		return true;
    	}
    	return false;
    }

    public void clear() {
    	for(int i = 0; i < size; i++) {
			stack[i] = null;
		}
    }

	@Override
	public String toString() {
		String result = "";
		if (size == 0) {
			return result;
		}
		for (int i = size - 1; i >= 0; i--) {
			if (i == size - 1) {
				result = result + stack[i] + "	<----- TOP\n";
			} else {
				result = result + stack[i] + "\n";
			}
		}
		result += "¯¯¯¯¯¯¯";
		return result;
	}
}
