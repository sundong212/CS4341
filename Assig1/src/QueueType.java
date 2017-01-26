
public class QueueType {
	Terrain terrain_inside;
	int h_plus_G;
	
	public QueueType(){
		this.terrain_inside = null;
		this.h_plus_G = 0;
	}
	
	public QueueType(Terrain terrain_inside, int h_plus_G) {
		this.terrain_inside = terrain_inside;
		this.h_plus_G = h_plus_G;
	}
}
