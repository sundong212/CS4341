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
			Terrain up = new Terrain();
			up = current.up;
			if(!(up.isClosed) && !(up.isUnNav)){
				up.time_consumed = cost.findCost(current, up).action_cost+current.time_consumed;
				up.from = current;
				up.action = cost.findCost(current, up);
				up.heuristic = heu.findHeuristic(4, up, goal);
				up.direction = "north";
				QueueType qup = new QueueType(up,(up.heuristic));
				frontier.add(qup);
			}
			
			if(current.up.up != null){				
				if(current.up.up.up != null){
					Terrain upleap = new Terrain();
					upleap = current.up.up.up;
					if(!(upleap.isClosed) && !(upleap.isUnNav)){
						upleap.time_consumed = cost.findCost(current, upleap).action_cost+current.time_consumed;
						upleap.from = current;
						upleap.action = cost.findCost(current, upleap);
						upleap.heuristic = heu.findHeuristic(4, upleap, goal);
						upleap.direction = "north";		
						QueueType qupleap = new QueueType(upleap,(upleap.heuristic));
						frontier.add(qupleap);
					}
					
				}
			}
			
		}if(current.down != null){
			Terrain down = new Terrain();
			down = current.down;
			if(!(down.isClosed) && !(down.isUnNav)){
				down.time_consumed = cost.findCost(current, down).action_cost+current.time_consumed;
				down.from = current;
				down.action = cost.findCost(current, down);
				down.heuristic = heu.findHeuristic(4, down, goal);
				down.direction = "south";
				QueueType qdown = new QueueType(down,(down.heuristic));
				frontier.add(qdown);
			}
			
			if(current.down.down != null){				
				if(current.down.down.down != null){
					Terrain downleap = new Terrain();
					downleap = current.down.down.down;
					if(!(downleap.isClosed) && !(current.down.down.down.isUnNav)){
						downleap.time_consumed = cost.findCost(current, downleap).action_cost+current.time_consumed;
						downleap.from = current;
						downleap.action = cost.findCost(current, downleap);
						downleap.heuristic = heu.findHeuristic(4, downleap, goal);
						downleap.direction = "south";
						QueueType qdownleap = new QueueType(downleap,(downleap.heuristic));
						frontier.add(qdownleap);
					}
					
				}
			}
			
		}if(current.left != null){
			Terrain left = new Terrain();
			
			if(!(current.left.isClosed) && !(current.left.isUnNav)){
				current.left.time_consumed = cost.findCost(current, current.left).action_cost+current.time_consumed;
				current.left.from = current;
				current.left.action = cost.findCost(current, current.left);
				current.left.heuristic = heu.findHeuristic(4, current.left, goal);
				current.left.direction = "west";
				frontier.add(current.left);
			}
			
			if(current.left.left != null){				
				if(current.left.left.left != null){
					if(!(current.left.left.left.isClosed) && !(current.left.left.left.isUnNav)){
						current.left.left.left.time_consumed = cost.findCost(current, current.left.left.left).action_cost+current.time_consumed;
						current.left.left.left.from = current;
						current.left.left.left.action = cost.findCost(current, current.left.left.left);
						current.left.left.left.heuristic = heu.findHeuristic(4, current.left.left.left, goal);
						current.left.left.left.direction = "west";
						frontier.add(current.left.left.left);
					}
				}
			}
			
		}if(current.right != null){
			if(!(current.right.isClosed) && !(current.right.isUnNav)){
				current.right.time_consumed = cost.findCost(current, current.right).action_cost+current.time_consumed;
				current.right.from = current;
				current.right.action = cost.findCost(current, current.right);
				current.right.heuristic = heu.findHeuristic(4, current.right, goal);
				current.right.direction = "east";
				frontier.add(current.right);
			}
			
			if(current.right.right != null){				
				if(current.right.right.right != null){
					if(!(current.right.right.right.isClosed) && !(current.right.right.right.isUnNav)){
						current.right.right.right.time_consumed = cost.findCost(current, current.right.right.right).action_cost+current.time_consumed;
						current.right.right.right.from = current;
						current.right.right.right.action = cost.findCost(current, current.right.right.right);
						current.right.right.right.heuristic = heu.findHeuristic(4, current.right.right.right, goal);
						current.right.right.right.direction = "east";
						frontier.add(current.right.right.right);
					}
					
				}
			}
			
		}		
		
		return;
	}


}
