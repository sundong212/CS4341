
public class ActionToTake {
	String orient_move; // "left" "right" "none" "left-left" 
	String straight_move; // "forward" or "leap"
	int action_cost;
	
	public ActionToTake() {
		this.orient_move = null;
		this.straight_move = null;
		this.action_cost = -1;
	}
}
