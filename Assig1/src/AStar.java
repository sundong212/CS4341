
public class AStar {
	public static void main(String[] args) {
		
		
		World new_world = new World(args);
		
		ConstructWorld constructed_world = new ConstructWorld(new_world);
		constructed_world.constructWorld(new_world);
		
		// till now new_world is completely constructed
		

		
	}
}