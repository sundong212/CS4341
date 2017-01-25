public class Terrain {
	boolean isStart;
	boolean isGoal;
	boolean isUnNav;
	boolean isClosed;
	int complexity;
	int row_num;
	int col_num;
	int time_consumed;
	int heuristic;
	String direction;
	Terrain up;
	Terrain down;
	Terrain left;
	Terrain right;
	Terrain from;
	Terrain to;
	ActionToTake action;
	
	public Terrain() {
		this.isStart = false;
		this.isGoal = false;
		this.isUnNav = false;
		this.isClosed = false;
		this.complexity = -1;
		this.row_num = -1;
		this.col_num = -1;
		this.time_consumed = -1;
		this.heuristic = -1;
		this.direction = null;
		this.up = null;
		this.down = null;
		this.left = null;
		this.right = null;
		this.from = null;
		this.to = null;
		this.action = new ActionToTake();
	}
	
}
