import java.io.File;
import java.io.IOException;
import java.util.*;

public class Maze {
	Square[][] maze;
	Square start;
	Square exit;
	
	public static void main(String[] args) {
		Maze test = new Maze();
		System.out.println(test.loadMaze("maze-2"));
		Square square = new Square(0, 0, 3);
		System.out.println(test.getExit());
		System.out.println(test.getStart());
		System.out.println(test.getNeighbors(square));
		System.out.println(test.toString());
		test.exit.reset();
	}
	
	public Maze() {
		
	}
	
	@SuppressWarnings("resource")
	public boolean loadMaze(String fileName) {
		Scanner console = null;
        try {
            console = new Scanner(new File (fileName));
        }
        catch (IOException e) {
            System.out.println("Can't find the file!");
            return false;
        }
        
        maze = new Square[console.nextInt()][console.nextInt()];
        console.nextLine();
        
        for (int r = 0; r < maze.length; r++) {
        	for (int c = 0; c < maze[0].length; c++) {
        		Square square = new Square(r, c, console.nextInt());
        		maze[r][c] = square;
        		if (maze[r][c].getType() == 2) {
        			start = maze[r][c];
        		} else if (maze[r][c].getType() == 3) {
        			exit = maze[r][c];
        		}
        	}
        	console.nextLine();
        }
        return true;
	}
	
	public List<Square> getNeighbors(Square s) {
		ArrayList<Square> list = new ArrayList<>(); 
		if(s.getRow()-1 >= 0)
			list.add(maze[s.getRow()-1][s.getCol()]);
        if(s.getCol()+1 < maze[0].length)
        	list.add(maze[s.getRow()][s.getCol()+1]);
        if(s.getRow()+1 < maze.length)
        	list.add(maze[s.getRow()+1][s.getCol()]);
        if(s.getCol() - 1 >= 0)
        	list.add(maze[s.getRow()][s.getCol()-1]);
        return list;
	}
	
	public Square getStart() {
		return start;
	}
	
	public Square getExit() {
		return exit;
	}
	
	public void reset() {
		for (int r = 0; r < maze.length; r++) {    
            for (int c = 0; c < maze[0].length; c++) {  
            	maze[r][c].reset();
            }
		}
	}
	
	public String toString() {
		String ret = "";
		for (int r = 0; r < maze.length; r++) {    
            for (int c = 0; c < maze[0].length; c++) {  
            	ret += maze[r][c].toString() + " ";
            }
            ret += "\n";
		}
		return ret;
	}
}
