
public class Heuristic {
	
	public int findHeuristic(int version, Terrain current, Terrain goal) {
		
		int x = goal.col_num-current.col_num;
		int y = goal.row_num-current.row_num;
		int result = 0;
		int direction;
		int degree;
		if(x == 0){
			if(y>0){
				degree = 0;
			}else if(y<0){
				degree = 180;
			}else{
				return 0;
			}
			
		}else{		
		
			degree = (int) Math.toDegrees(Math.atan(y/x));
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
		}
		
		
		direction = ((int)(Math.abs(result-degree)/90.0));
		
		switch (version) {
		case 1:
			
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			return 0;
			
		case 2:
			
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			return Math.min(Math.abs(goal.col_num-current.col_num), Math.abs(goal.row_num-current.row_num));
			
		case 3:
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			return Math.max(Math.abs(goal.col_num-current.col_num), Math.abs(goal.row_num-current.row_num));
			
		case 4:
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			
			return Math.abs(goal.col_num-current.col_num)+Math.abs(goal.row_num-current.row_num);
			
		case 5:
			
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			return (int) (Math.abs(goal.col_num-current.col_num)+Math.abs(goal.row_num-current.row_num)+direction*Math.ceil(current.complexity/3.0));
			

		default: // case 6
			
			if(goal.isGoal == false){
				return -1; //report error when goal is not goal
			}
			
			if(current.isUnNav == true){
				return -1; //drive into wall
			}
			
			
			return 3*(int) (Math.abs(goal.col_num-current.col_num)+Math.abs(goal.row_num-current.row_num)+direction*Math.ceil(current.complexity/3.0));
		}
	}
}
