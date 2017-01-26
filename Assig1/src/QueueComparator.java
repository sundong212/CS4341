import java.util.Comparator;

public class QueueComparator implements Comparator<QueueType>{
	
	@Override
	public int compare(QueueType o1, QueueType o2) {
		
		if (o1.h_plus_g == o2.h_plus_g) {
			return 0;
		} else if (o1.h_plus_g < o2.h_plus_g) {
			return -1;
		} else {
			return 1;
		}
	}
	
}
