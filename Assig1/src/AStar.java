import java.util.PriorityQueue;
import java.util.Stack;

//import java.util.Stack;

public class AStar {
	
	static QueueComparator comparator = new QueueComparator();
	
	static PriorityQueue<QueueType> frontier = new PriorityQueue<QueueType>(11,comparator);	
	static int expended = 0;
	static int heur = 4;
	
	public static void main(String[] args) {
		
		World new_world = new World(args);
		
		ConstructWorld constructed_world = new ConstructWorld(new_world);
		constructed_world.constructWorld(new_world);
		
		// till now new_world is completely constructed
		
		Terrain start = new_world.startTerrain;
		Terrain goal = new_world.goalTerrain;
		start.complexity = 1;
		Terrain current = start;
		current.direction = "north";
		Heuristic heu = new Heuristic(); 
		QueueType strt = new QueueType(start, heu.findHeuristic(heur, start, goal));
		frontier.add(strt);
		
//System.out.println(frontier.size());	
		
		System.out.println("Start");
		
		
		while(new_world.goalTerrain.from == null) {

			createFrontier(current, goal);


			
			
			QueueType qcurrent = frontier.peek();
			DeleteQueueType temp = new DeleteQueueType();
			
//System.out.println(frontier.peek().terrain_inside.col_num + " " + frontier.peek().terrain_inside.row_num);
			
//System.out.println("queuesize  "+frontier.size());
			
			
			temp.delete(frontier, qcurrent.terrain_inside.row_num, qcurrent.terrain_inside.col_num);

			new_world.all_terrains.get(current.row_num).get(current.col_num).heuristic = current.heuristic;
			new_world.all_terrains.get(current.row_num).get(current.col_num).time_consumed = current.time_consumed;
			new_world.all_terrains.get(current.row_num).get(current.col_num).action = current.action;
			new_world.all_terrains.get(current.row_num).get(current.col_num).from = current.from;
			new_world.all_terrains.get(current.row_num).get(current.col_num).isClosed = true;
			new_world.all_terrains.get(current.row_num).get(current.col_num).action = current.action;
			
			
			current = frontier.poll().terrain_inside;			
			
		}

//System.out.println(frontier.size());		
		
		Stack<Terrain> path = new Stack<Terrain>();
		Terrain pathpoint = new Terrain();
		pathpoint = goal;
		path.push(pathpoint);
		
		
		
		while(!pathpoint.equals(start)){
			Terrain temp = new Terrain();
			temp = pathpoint.from;
			path.push(temp);			
			
			pathpoint = temp;
			
//System.out.println("push seccuess: " + temp.col_num + "" + temp.row_num);


		}
		
		int action_take = 0;
		
		while (path.isEmpty() == false) {
			Terrain temp = path.pop();
			ActionToTake temp_action = temp.action;
			
			if (temp_action.orient_move != null) {
				if (temp_action.orient_move.equals("left")) {
					System.out.println("Turn Left");
					action_take++;
				} else if (temp_action.orient_move.equals("right")) {
					System.out.println("Turn right");
					action_take++;
				} else if (temp_action.orient_move.equals("left-left")) {
					System.out.println("Turn left");
					action_take++;
					System.out.println("Turn left");
					action_take++;
				} else {
					
				}
			}
			
			if (temp_action.straight_move != null) {
				if (temp_action.straight_move.equals("forward")) {
					System.out.println("Forward");
					action_take++;
				} else {
					System.out.println("Leap");
					action_take++;
				}
			}
			
			//System.out.println("row: " + temp.row_num + " " + "col: " + temp.col_num);
			//System.out.println(temp.action);
			
		}
		
		System.out.println("Score:"+(500-goal.time_consumed));
		System.out.println("Number of nodes expanded:"+expended);
		System.out.println("Action to take:"+action_take);
		double branch = Math.pow(expended, 1/(action_take+1));
		System.out.println(branch);
		
		
		
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
				up.heuristic = heu.findHeuristic(heur, up, goal);
				up.direction = "north";
				
				QueueType qup = new QueueType(up,(up.heuristic+up.time_consumed));
				frontier.add(qup);
				expended++;
//System.out.println(up.time_consumed-current.time_consumed);
			}
			
			if(current.up.up != null){				
				if(current.up.up.up != null){
					Terrain upleap = new Terrain();
					upleap = current.up.up.up;
					if(!(upleap.isClosed) && !(upleap.isUnNav)){
						upleap.time_consumed = cost.findCost(current, upleap).action_cost+current.time_consumed;
						upleap.from = current;
						upleap.action = cost.findCost(current, upleap);
						upleap.heuristic = heu.findHeuristic(heur, upleap, goal);
						upleap.direction = "north";		
						QueueType qupleap = new QueueType(upleap,(upleap.heuristic+upleap.time_consumed));
						frontier.add(qupleap);
						expended++;
//System.out.println(upleap.time_consumed-current.time_consumed);
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
				down.heuristic = heu.findHeuristic(heur, down, goal);
				down.direction = "south";
				QueueType qdown = new QueueType(down,(down.heuristic+down.time_consumed));
				frontier.add(qdown);
				expended++;
//System.out.println(down.time_consumed-current.time_consumed);
			}
			
			if(current.down.down != null){				
				if(current.down.down.down != null){
					Terrain downleap = new Terrain();
					downleap = current.down.down.down;
					if(!(downleap.isClosed) && !(downleap.isUnNav)){
						downleap.time_consumed = cost.findCost(current, downleap).action_cost+current.time_consumed;
						downleap.from = current;
						downleap.action = cost.findCost(current, downleap);
						downleap.heuristic = heu.findHeuristic(heur, downleap, goal);
						downleap.direction = "south";
						QueueType qdownleap = new QueueType(downleap,(downleap.heuristic+downleap.time_consumed));
						frontier.add(qdownleap);
						expended++;
//System.out.println(downleap.time_consumed-current.time_consumed);
					}
					
				}
			}
			
		}if(current.left != null){
			Terrain left = new Terrain();
			left = current.left;
			if(!(left.isClosed) && !(left.isUnNav)){
				left.time_consumed = cost.findCost(current, left).action_cost+current.time_consumed;
				left.from = current;
				left.action = cost.findCost(current, left);
				left.heuristic = heu.findHeuristic(heur, left, goal);
				left.direction = "west";
				QueueType qleft = new QueueType(left,(left.heuristic+left.time_consumed));
				frontier.add(qleft);
				expended++;
//System.out.println(left.time_consumed-current.time_consumed);			
			}
			
			if(current.left.left != null){				
				if(current.left.left.left != null){
					Terrain leftleap = new Terrain();
					leftleap = current.left.left.left;
					if(!(leftleap.isClosed) && !(leftleap.isUnNav)){
						leftleap.time_consumed = cost.findCost(current, leftleap).action_cost+current.time_consumed;
						leftleap.from = current;
						leftleap.action = cost.findCost(current, leftleap);
						leftleap.heuristic = heu.findHeuristic(heur, leftleap, goal);
						leftleap.direction = "west";
						QueueType qleftleap = new QueueType(leftleap,(leftleap.heuristic+leftleap.time_consumed));
						frontier.add(qleftleap);
						expended++;
//System.out.println(leftleap.time_consumed-current.time_consumed);
					}
				}
			}
			
		}if(current.right != null){
			Terrain right = new Terrain();
			right = current.right;
			if(!(right.isClosed) && !(right.isUnNav)){
				right.time_consumed = cost.findCost(current, right).action_cost+current.time_consumed;
				right.from = current;
				right.action = cost.findCost(current, right);
				right.heuristic = heu.findHeuristic(heur, right, goal);
				right.direction = "east";
				QueueType qright = new QueueType(right,(right.heuristic+right.time_consumed));
				frontier.add(qright);
				expended++;
//System.out.println(right.time_consumed-current.time_consumed);
			}
			
			if(current.right.right != null){				
				if(current.right.right.right != null){
					Terrain rightleap = current.right.right.right;
					if(!(rightleap.isClosed) && !(rightleap.isUnNav)){
						rightleap.time_consumed = cost.findCost(current, rightleap).action_cost+current.time_consumed;
						rightleap.from = current;
						rightleap.action = cost.findCost(current, rightleap);
						rightleap.heuristic = heu.findHeuristic(heur, rightleap, goal);
						rightleap.direction = "east";
						QueueType qrightleap = new QueueType(right,(rightleap.heuristic+rightleap.time_consumed));
						frontier.add(qrightleap);
						expended++;
//System.out.println(rightleap.time_consumed-current.time_consumed);
					}
					
				}
			}
			
		}		
		
		return;
	}


}
