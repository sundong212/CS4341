import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;

public class World {
	
	int row;
	int col;
	Hashtable<Integer, Hashtable<Integer, Terrain>> all_terrains = new Hashtable<Integer, Hashtable<Integer, Terrain>>();
	Terrain startTerrain;
	Terrain goalTerrain;
	
	public World(String[] args) {
		
		try{
			String file = args[0];
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String buf_line = null;
            String[] wordsArray;
            int current_line = 0;

            while(true){
            	buf_line = buf.readLine();
                if(buf_line == null){ 
                    break; 
                }else{
                	int current_col = 0;
                	current_line++;
                    wordsArray = buf_line.split("\t");
                    Hashtable<Integer, Terrain> terrains_oneline = new Hashtable<Integer, Terrain>();
                    
                    for(String each : wordsArray){
                    	
                    	current_col++;
                    	
                        if(!"".equals(each)){
                        	
                        	Terrain temp = new Terrain();
                        	
                        	if (each.equals("S")) {
								temp.isStart = true;
								temp.row_num = current_line;
	                        	temp.col_num = current_col;
								this.startTerrain = temp;
							}
                        	else if (each.equals("G")) {
								temp.isGoal = true;
								temp.row_num = current_line;
	                        	temp.col_num = current_col;
	                        	this.goalTerrain = temp;
							}
                        	else if (each.equals("#")) {
								temp.isUnNav = true;
								temp.row_num = current_line;
	                        	temp.col_num = current_col;
							}
                        	else {
                        		temp.complexity = Integer.parseInt(each);
                        		temp.row_num = current_line;
                            	temp.col_num = current_col;
                        	}
                        	
                        	terrains_oneline.put(current_col, temp);
                        }
                         
                    }
                    this.all_terrains.put(current_line, terrains_oneline);
                    
                    this.col = current_col;
                }
            }
            
            this.row = current_line;

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
		
	}

}
