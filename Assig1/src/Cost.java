
public class Cost {
	
	public ActionToTake findCost(Terrain current, Terrain target) {
		
		ActionToTake action = new ActionToTake();
		
		if ((current.row_num == target.row_num) && (current.col_num > target.col_num)) { // target is on the left of the current
			
			if ((current.col_num - target.col_num) == 1) { // if it's normal forward
				
				if (current.direction.equals("north")) {
					action.action_cost = (int)Math.ceil(current.complexity / 3.0) + target.complexity;
					action.orient_move = "left";
					action.straight_move = "forward";
				} else if (current.direction.equals("south")) {
					action.action_cost = (int)Math.ceil(current.complexity / 3.0) + target.complexity;
					action.orient_move = "right";
					action.straight_move = "forward";
				} else if (current.direction.equals("west")) {
					action.action_cost = target.complexity;
					action.orient_move = "none";
					action.straight_move = "forward";
				} else {
					action.action_cost = 2*(int)Math.ceil(current.complexity / 3.0) + target.complexity;
					action.orient_move = "left-left";
					action.straight_move = "forward";
				}
				
			} else { // if it's a leap
				if (current.direction.equals("north")) {
					action.action_cost = (int)Math.ceil(current.complexity / 3.0) + 20;
					action.orient_move = "left";
					action.straight_move = "leap";
				} else if (current.direction.equals("south")) {
					action.action_cost = (int)Math.ceil(current.complexity / 3.0) + 20;
					action.orient_move = "right";
					action.straight_move = "leap";
				} else if (current.direction.equals("west")) {
					action.action_cost = 20;
					action.orient_move = "none";
					action.straight_move = "leap";
				} else {
					action.action_cost = 2*(int)Math.ceil(current.complexity / 3.0) + 20;
					action.orient_move = "left-left";
					action.straight_move = "leap";
				}
			}
		
		} else if ((current.row_num == target.row_num) && (current.col_num < target.col_num)) { // target is on the right of the current
			
			if ((target.col_num - current.col_num) == 1) { // if it's normal forward
				
			} else { // if it's a leap
				
			}
		
		} else if ((current.col_num == target.col_num) && (current.row_num > target.row_num)) { // target is on the up of the current
			
			if ((current.row_num - target.row_num) == 1) { // it's a normal forward
				
			} else { // it's a leap
				
			}
			
		} else { // target is on the down of the current
			if ((target.row_num - current.row_num) == 1) { // it's a normal forward
				
			} else { // it's a leap
				
			}			
			
		}
		
		return action;
		
	}

}
