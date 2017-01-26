import java.util.PriorityQueue;


public class AStar {
	
	static PriorityQueue frontier = new PriorityQueue<Terrain>();	
	
	public static void main(String[] args) {
		
		World new_world = new World(args);
		
		ConstructWorld constructed_world = new ConstructWorld(new_world);
		constructed_world.constructWorld(new_world);
		
		// till now new_world is completely constructed
		
		Terrain start = new_world.startTerrain;
		Terrain goal = new_world.goalTerrain;
		Terrain current = start;
		
		
		frontier.add(start);
		
		while(current.equals(goal)) {
			
			createFrontier(current);
			
			

		}
			
		
	}
	
	private static void createFrontier(Terrain current) {
		
		Cost cost = new Cost();
		
		if(current.up != null){
			
						
			current.up.time_consumed = cost.findCost(current, current.up).action_cost;
			current.up.from = current;
			frontier.add(current.up);
			
			if(current.up.up != null){
				
				if(current.up.up.up != null){
					
					current.up.up.up.time_consumed = cost.findCost(current, current.up.up.up).action_cost;
					current.up.up.up.from = current;
					frontier.add(current.up.up.up);
					
				}
			}
			
		}if(current.down != null){
			
			current.down.time_consumed = cost.findCost(current, current.down).action_cost;
			current.down.from = current;
			frontier.add(current.down);
			
			if(current.down.down != null){
				
				if(current.down.down.down != null){
					
					current.down.down.down.time_consumed = cost.findCost(current, current.down.down.down).action_cost;
					current.down.down.down.from = current;
					frontier.add(current.down.down.down);
					
				}
			}
			
		}if(current.left != null){
			
			current.left.time_consumed = cost.findCost(current, current.left).action_cost;
			current.left.from = current;
			frontier.add(current.left);
			
			if(current.left.left != null){
				
				if(current.left.left.left != null){
					
					current.left.left.left.time_consumed = cost.findCost(current, current.left.left.left).action_cost;
					current.left.left.left.from = current;
					frontier.add(current.left.left.left);
					
				}
			}
			
		}if(current.right != null){
			
			current.right.time_consumed = cost.findCost(current, current.right).action_cost;
			current.right.from = current;
			frontier.add(current.right);
			
			if(current.right.right != null){
				
				if(current.right.right.right != null){
					
					current.right.right.right.time_consumed = cost.findCost(current, current.right.right.right).action_cost;
					current.right.right.right.from = current;
					frontier.add(current.right.right.right);
					
				}
			}
			
		}		
		
		return;
	}


	
	
	
	
}
