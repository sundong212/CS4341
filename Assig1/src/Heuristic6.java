
public class Heuristic6 {
	
	public int heu6(Terrain current, Terrain goal){
		
		if(goal.isGoal == false){
			return -1; //report error when goal is not goal
		}
		
		if(current.isUnNav == true){
			return -1; //drive into wall
		}
		
		
		return 3*(Math.abs(goal.col_num-current.col_num)+Math.abs(goal.row_num-current.row_num)+1/3*findDirection(current, goal));
	}
	
	private int findDirection(Terrain current, Terrain goal){
		
		//return a number from 
		
		int x = goal.col_num-current.col_num;
		int y = goal.row_num-current.row_num;
		int result = 0;
		
		int degree = (int) Math.toDegrees(Math.atan(y/x));
		if(current.equals("north")){
			result = 90;
		}
		else if(current.equals("west")){
			result = 180;
		}
		else if(current.equals("south")){
			result = -90;
		}
		else{
			result = 0;
		}
		
		
		return ((int)(Math.abs(result-degree)/90));
	}

}
