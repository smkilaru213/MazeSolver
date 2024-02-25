public class MazeSolverStack extends MazeSolver {
	
	MyStack stack;
	Maze maze;
	public MazeSolverStack(Maze maze) {
		super(maze);
	}

	public void makeEmpty() {
		stack = new MyStack(); 
	}
	
	@Override
	public void add(Square s) {
		stack.push(s);
	}

	@Override
	public boolean isEmpty() {
        if (stack.size() == 0) {
        	return true;
        }
		return false;
	}

	@Override
	public Square next() {
		return stack.pop();
	}

}
