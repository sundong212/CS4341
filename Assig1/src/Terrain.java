public class Terrain {
	boolean isStart = false;
	boolean isGoal = false;
	boolean isUnNav = false;
	int complexity = -1;
	int row_num = -1;
	int col_num = -1;
	int cost = -1;
	String direction = null;
	Terrain up = null;
	Terrain down = null;
	Terrain left = null;
	Terrain right = null;
	Terrain parent = null;
	Terrain child = null;
}
