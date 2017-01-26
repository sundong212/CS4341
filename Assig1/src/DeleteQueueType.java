import java.util.PriorityQueue;

public class DeleteQueueType {
	public void delete(PriorityQueue<QueueType> queue, int row, int col) {
		
		for(QueueType e : queue) {
			if ((e.terrain_inside.col_num == col) && (e.terrain_inside.row_num == row)) {
				queue.remove(e);
			}
		}

	}
}
