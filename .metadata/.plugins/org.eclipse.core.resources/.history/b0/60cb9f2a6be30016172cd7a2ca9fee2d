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
			
			createFrontier(current, goal);
			frontier.remove(current);
			new_world.all_terrains.get(current.row_num).get(current.col_num).heuristic = current.heuristic;
			new_world.all_terrains.get(current.row_num).get(current.col_num).time_consumed = current.time_consumed;
			new_world.all_terrains.get(current.row_num).get(current.col_num).action = current.action;
			new_world.all_terrains.get(current.row_num).get(current.col_num).from = current.from;
			new_world.all_terrains.get(current.row_num).get(current.col_num).isClosed = current.isClosed;
			new_world.all_terrains.get(current.row_num).get(current.col_num).action = current.action;
			
		}
			
		
	}
	
	private static void createFrontier(Terrain current, Terrain goal) {
		
		Cost cost = new Cost();
		Heuristic heu = new Heuristic();
		
		if(current.up != null){
			if(!(current.up.isClosed) && !(current.up.isUnNav)){
				current.up.time_consumed = cost.findCost(current, current.up).action_cost+current.time_consumed;
				current.up.from = current;
				current.up.action = cost.findCost(current, current.up);
				current.up.heuristic = heu.findHeuristic(4, current.up, goal);
				current.up.direction = "north";
				frontier.add(current.up);
			}
			
			if(current.up.up != null){				
				if(current.up.up.up != null){
					if(!(current.up.up.up.isClosed) && !(current.up.up.up.isUnNav)){
						current.up.up.up.time_consumed = cost.findCost(current, current.up.up.up).action_cost+current.time_consumed;
						current.up.up.up.from = current;
						current.up.up.up.action = cost.findCost(current, current.up.up.up);
						current.up.up.up.heuristic = heu.findHeuristic(4, current.up.up.up, goal);
						current.up.up.up.direction = "north";		
						frontier.add(current.up.up.up);
					}
					
				}
			}
			
		}if(current.down != null){
			if(!(current.down.isClosed) && !(current.down.isUnNav)){
				current.down.time_consumed = cost.findCost(current, current.down).action_cost+current.time_consumed;
				current.down.from = current;
				current.down.action = cost.findCost(current, current.down);
				current.down.heuristic = heu.findHeuristic(4, current.down, goal);
				current.down.direction = "south";
				frontier.add(current.down);
			}
			
			if(current.down.down != null){				
				if(current.down.down.down != null){
					if(!(current.down.down.down.isClosed) && !(current.down.down.down.isUnNav)){
						current.down.down.down.time_consumed = cost.findCost(current, current.down.down.down).action_cost+current.time_consumed;
						current.down.down.down.from = current;
						frontier.add(current.down.down.down);
					}
					
				}
			}
			
		}if(current.left != null){
			if(!(current.left.isClosed) && !(current.left.isUnNav)){
				current.left.time_consumed = cost.findCost(current, current.left).action_cost+current.time_consumed;
				current.left.from = current;
				frontier.add(current.left);
			}
			
			if(current.left.left != null){				
				if(current.left.left.left != null){
					if(!(current.left.left.left.isClosed) && !(current.left.left.left.isUnNav)){
						current.left.left.left.time_consumed = cost.findCost(current, current.left.left.left).action_cost+current.time_consumed;
						current.left.left.left.from = current;
						frontier.add(current.left.left.left);
					}
				}
			}
			
		}if(current.right != null){
			if(!(current.right.isClosed) && !(current.right.isUnNav)){
				current.right.time_consumed = cost.findCost(current, current.right).action_cost+current.time_consumed;
				current.right.from = current;
				frontier.add(current.right);
			}
			
			if(current.right.right != null){				
				if(current.right.right.right != null){
					if(!(current.right.right.right.isClosed) && !(current.right.right.right.isUnNav)){
						current.right.right.right.time_consumed = cost.findCost(current, current.right.right.right).action_cost+current.time_consumed;
						current.right.right.right.from = current;
						frontier.add(current.right.right.right);
					}
					
				}
			}
			
		}		
		
		return;
	}


}
