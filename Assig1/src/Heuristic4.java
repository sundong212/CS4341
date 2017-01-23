public class Heuristic4 {
	
	public int heu4(Terrain current, Terrain goal){
		
		if(goal.isGoal == false){
			return -1; //report error when goal is not goal
		}
		
		if(current.isUnNav == true){
			return -1; //drive into wall
		}
		
		
		return Math.abs(goal.col_num-current.col_num)+Math.abs(goal.row_num-current.row_num);
	}
	

}
