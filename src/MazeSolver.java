import java.util.List;

public abstract class MazeSolver {
	
	Maze maze;
	boolean solved = false;
	boolean solvable = true;
	
	public MazeSolver() {}

	public static void main(String[] args) {}
	
	public MazeSolver(Maze maze) {
		this.maze = maze;
		makeEmpty();
		add(maze.getStart());
	}
	
	public abstract void makeEmpty();

    public abstract boolean isEmpty();

    public abstract void add(Square s);

    public abstract Square next();
    
    public boolean isSolved() {
    	if(solved == true)
    		return true;
    	return false;
    }

   public void step() {
    	if (isEmpty() == true ) {
    		solvable = false;
    	} else {
    		Square next = next();
    		if (next.equals(maze.getExit())) {
    			solved = true;
    		}
    		List<Square> neighbors = maze.getNeighbors(next);
    		for (int i = 0; i < neighbors.size(); i++) {
    			if (neighbors.get(i).getType() != Square.WALL && neighbors.get(i).getType() != Square.EXIT && neighbors.get(i).getStatus() != Square.EXPLORED) {
    				add(neighbors.get(i));
    				neighbors.get(i).setStatus(Square.WORKING);
    			} else if (neighbors.get(i).getType() == Square.EXIT) {
    				neighbors.get(i).setStatus(Square.WORKING);
    				next = neighbors.get(i);
    				break;
    			}
    		}
    		if (next.getStatus() != Square.EXIT) {
    			next.setStatus(Square.EXPLORED);
    		}
    		if (next.equals(maze.getExit())) {
    			solved = true;
    		}
    	}
    }
    
    public String getPath() {
    	 if(isSolved() == true) { 
    		 return "Maze is solved";
    	 } else if (solvable == true) {
    		 return "Maze not yet solved";
    	 }
         return "Maze is unsolvable";
    }
 
    public void solve() {
    	while(isSolved() == false) {
            step();
        }
    }
}
