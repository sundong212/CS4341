import java.util.PriorityQueue;

public class DeleteQueueType {
	public void delete(PriorityQueue<QueueType> queue, int row, int col) {
		
		QueueComparator comparator = new QueueComparator();
		PriorityQueue<QueueType> final_queue = new PriorityQueue<QueueType>(11,comparator);
		
		
		for(QueueType e : queue) {
			if ((e.terrain_inside.col_num != col) && (e.terrain_inside.row_num != row)) {
				final_queue.add(e);
			}else{
				e.terrain_inside.isClosed = true;
			}
		}
		
		queue = final_queue;

	}
}
