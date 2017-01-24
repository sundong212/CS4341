import java.util.Hashtable;

public class ConstructWorld {
	
	int row;
	int col;
	Hashtable<Integer, Hashtable<Integer, Terrain>> all_terrains;
	
	public ConstructWorld(World world) {
		this.row = world.row;
		this.col = world.col;
		this.all_terrains = world.all_terrains;
	}
	
	public void constructWorld(World world) {
		
		int temp_row;
		
		// iterate through all rows(only applies for 3x3 or more)
		for (temp_row = 1; temp_row <= this.row; temp_row++) {
			
			if (temp_row == 1) { // if it's the first row
				for (int i = 1; i <= this.col; i++) {
					
					if (i == 1) { // if it's the first in a row
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);
					} else if (i == this.col) { // if it's the last in a row
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);
					} else { // if it's the middle in a row
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);
					}
				}
				
			} else if (temp_row == row) { // if it's the last row
				
				for (int i = 1; i < this.col; i++) {
					
					if (i == 1) { // if it's the first in last row
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
					} else if (i == this.col) { // if it's the last in last row
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
					} else { // if it's middle in last row
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
					}
				}

			} else { // if it's the middle rows
				
				for (int i = 1; i <= this.col; i++) {
					
					if (i == 1) { // if first in middle rows
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);
					} else if (i == this.col) { // if last in middle rows
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);						
					} else { // if middle in middle rows
						all_terrains.get(temp_row).get(i).left = all_terrains.get(temp_row).get(i-1);
						all_terrains.get(temp_row).get(i).right = all_terrains.get(temp_row).get(i+1);
						all_terrains.get(temp_row).get(i).up = all_terrains.get(temp_row-1).get(i);
						all_terrains.get(temp_row).get(i).down = all_terrains.get(temp_row+1).get(i);							
					}
				}				
				
				
			}
			
		}	
		

	}
}
