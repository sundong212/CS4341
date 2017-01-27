import java.util.Stack;

public class PrintAction {
	public void printPath(Stack<Terrain> stack) {
		Terrain temp_terrain = stack.pop();
		ActionToTake temp_action = temp_terrain.action;
		
		if (temp_action.orient_move != null) {
			if (temp_action.orient_move.equals("left")) {
				System.out.println("Turn Left");
			} else if (temp_action.orient_move.equals("right")) {
				System.out.println("Turn right");
			} else if (temp_action.orient_move.equals("left-left")) {
				System.out.println("Turn left");
				System.out.println("Turn left");
			} else {
				
			}
		}
		
		if (temp_action.straight_move != null) {
			if (temp_action.straight_move.equals("forward")) {
				System.out.println("Forward");
			} else {
				System.out.println("Leap");
			}
		}

	}
}
