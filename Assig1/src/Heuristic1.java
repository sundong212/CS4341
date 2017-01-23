
public class Heuristic1 {
	
	public int heu1(Terrain current, Terrain goal){
		
		if(goal.isGoal == false){
			return -1; //report error when goal is not goal
		}
		
		if(current.isUnNav == true){
			return -1; //drive into wall
		}
		
		return 0;		
	}

}
