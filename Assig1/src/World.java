import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class World {
	
	public World(String input_file, String[] args) {
		
		try{
			String file = args[0];
            BufferedReader buf = new BufferedReader(new FileReader(file));
            Hashtable<Location, ArrayList<Terrain>> all_terrains = new Hashtable<Location, ArrayList<Terrain>>();
            String buf_line = null;
            String[] wordsArray;
            int current_line = 0;

            while(true){
            	buf_line = buf.readLine();
                if(buf_line == null){  
                    break; 
                }else{
                	current_line++;
                    wordsArray = buf_line.split("\t");
                    ArrayList<Terrain> terrains_oneline = new ArrayList<Terrain>();
                    
                    for(String each : wordsArray){
                        if(!"".equals(each)){
                        	
                        	Terrain temp = new Terrain();
                        	
                        	if (each.equals("S")) {
								temp.isStart = true;
								temp.row_num = current_line;
								temp.col_num = 
							}
                        	if (each.equals("G")) {
								temp.
							}
                        	if (each.equals("#")) {
								temp.
							}
                        	
                        	
                        	
                        	int complexity = Integer.parseInt(each);
                        	
                        	terrains_oneline.add(temp)
                        	
                        }
                    }
                    
                    
                    
                }
            }

            for(String each : terrains_list){
                System.out.println(each);
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }
		
	}
}
