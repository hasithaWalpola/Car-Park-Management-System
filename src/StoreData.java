import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StoreData {

	   public void writeFile(Car c, DateTime d, char type){
		   
		 String fwType;
		 
		 if(type=='c'){
			 fwType = "car";
		 }else if(type=='v'){
			 fwType="van";
		 }else{
			 fwType = "motorbike";
		 }
		   
		String writeString =fwType+";"+c.getIdPlate() + ";" + c.getVehicleBrand()+ ";" +d.toString()+ ";" +c.getColor() + ";" + c.getNumDoors();
    	String path = System.getProperty("user.dir") + "\\files\\park.txt";
    	
    	try {
    		File file = new File(path);
        	
        	if(!file.exists()){
        		file.createNewFile();
        	}
        	
        	FileWriter fw = new FileWriter(file,true); //write students details to the file
        	BufferedWriter bw  = new BufferedWriter(fw);
        	
			bw.write(writeString);
			bw.newLine();
			bw.flush();
	    	fw.close();
	    	bw.close();
	    	System.out.println("Car Entered !\n");
	    
	    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        
	   }
	   public void writeFile(Van v, DateTime d, char type){
		   

		   
			String writeString ="Van;"+ v.getIdPlate() + ";" + v.getVehicleBrand()+ ";" +d.toString()+ ";" +v.getCargoVolume();
		    	String path = System.getProperty("user.dir") + "\\files\\park.txt";
		    	
		    	try {
		    		File file = new File(path);
		        	
		        	if(!file.exists()){
		        		file.createNewFile();
		        	}
		        	
		        	FileWriter fw = new FileWriter(file,true); //write students details to the file
		        	BufferedWriter bw  = new BufferedWriter(fw);
		        	
					bw.write(writeString);
					bw.newLine();
					bw.flush();
			    	fw.close();
			    	bw.close();
			    	System.out.println("Van Entered !\n");
			    	//Menu();
			    	
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		        
			   }
	   public void writeFile(MotorBike m, DateTime d, char type){
		   

		   
			String writeString ="Motorbike;"+ m.getIdPlate() + ";" + m.getVehicleBrand()+ ";" +d.toString()+ ";" +m.getEngineCapacity();
		    	String path = System.getProperty("user.dir") + "\\files\\park.txt";
		    	
		    	try {
		    		File file = new File(path);
		        	
		        	if(!file.exists()){
		        		file.createNewFile();
		        	}
		        	
		        	FileWriter fw = new FileWriter(file,true); //write students details to the file
		        	BufferedWriter bw  = new BufferedWriter(fw);
		        	
					bw.write(writeString);
					bw.newLine();
					bw.flush();
			    	fw.close();
			    	bw.close();
			    	System.out.println("Motorbike Entered !\n");
			    	//Menu();
			    	
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		        
			   }
}
