import java.util.Stack;

public class MyStackTester {
	public static void main(String[] args) {
		MyStack mine = new MyStack();
		Stack<Square> javas = new Stack<>();
		Square a = new Square(1,2,1);
		mine.push(a);
		javas.push(a);
		Square ab = new Square(2,3,2);
		mine.push(ab);
		javas.push(ab);
		Square c = new Square(3,1,1);
		mine.push(c);
		javas.push(c);
		Square d = new Square(1,3,2);
		mine.push(d);
		javas.push(d);
		Square e = new Square(0,0,1);
		mine.push(e);
		javas.push(e);

        System.out.println(mine.isEmpty());
		System.out.println(javas.isEmpty());
		System.out.println(mine.pop());
		System.out.println(javas.pop());
		System.out.println(mine.peek());
		System.out.println(javas.peek());
		System.out.println(mine.size());
		System.out.println(javas.size());
		mine.clear();
		System.out.println(mine);
		javas.clear();
		System.out.println(javas);
	}
}
