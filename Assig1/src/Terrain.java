public class Terrain {
	boolean isStart;
	boolean isGoal;
	boolean isUnNav;
	boolean isClosed;		//change
	int complexity;		
	int row_num;
	int col_num;
	int time_consumed;		//change
	int heuristic;			//change
	String direction;		//change
	Terrain up;
	Terrain down;
	Terrain left;
	Terrain right;
	Terrain from;			//change

	ActionToTake action;	//change
	
	public Terrain() {
		this.isStart = false;
		this.isGoal = false;
		this.isUnNav = false;
		this.isClosed = false;
		this.complexity = 0;
		this.row_num = -1;
		this.col_num = -1;
		this.time_consumed = 0;
		this.heuristic = -1;
		this.direction = null;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
		this.from = null;
		this.action = new ActionToTake();
	}
	
	private boolean isEqual(int row, int col) {
		if ((this.row_num == row) && (this.col_num == col)) {
			return true;
		} else {
			return false;
		}

	}
	
}
