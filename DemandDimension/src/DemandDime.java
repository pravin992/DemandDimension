import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;  
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



public class DemandDime {

    public static void main(String[] args) {

    	BufferedReader br = null;
    	
        String csvFile = "MA_SchedulingSimulation.csv";
        String line = "";
        String cvsSplitBy = ",";
        
        List<Double[]> locationArr = new ArrayList<Double[]>(); 	//lat_lang
        List<String> jobID = new ArrayList<String>();				//Row_label
        List<Integer> weight = new ArrayList<Integer>();			//Sum_of_net
        List<Integer> lines = new ArrayList<Integer>();				//Count of SKU7_CODE
        
        JSONObject obj = new JSONObject();
     
        //Read csv file and Initialize respective list
         try {
        		br = new BufferedReader(new FileReader(csvFile));
        		
	            while ((line = br.readLine()) != null) 
	            {
	            	// use comma as separator
	                String[] latlang = line.split(cvsSplitBy);
	                //System.out.println("latlang [lat= " + latlang[5] + " , lang=" + latlang[6] + "]");
	             
	                jobID.add(new String(latlang[1]));
	                lines.add(new Integer(latlang[2]));
	                weight.add(new Integer(Math.round(Float.parseFloat(latlang[3]))));
	                locationArr.add(new Double[] {Double.valueOf(latlang[5]),Double.valueOf(latlang[6])});

	            }

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally 
        {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
       /* for( int i = 0; i < locationArr.size(); i++ ) {
            for( int j = 0; j < locationArr.get(i).length; j++ ) {
                System.out.print(" " + locationArr.get(i)[j]);
            }
            System.out.println();

        }
        
        Iterator<Integer> itr = lines.iterator();
        while(itr.hasNext()) {
        	System.out.println(" "+itr.next());
        }
        */
        
        //Load Property file 
        Properties prop = new Properties();
     	InputStream input = null;
		
     	try {
     		input = new FileInputStream("config.properties");

    		// load a properties file
    		prop.load(input);
     	} 
     	catch (IOException ex) {
    		ex.printStackTrace();
    	}

         
         JSONArray list = new JSONArray();
       
        obj.put("jobIds",jobID);
        
        
        obj.put("timeBackToDepot",prop.getProperty("timeBackToDepot"));
        obj.put("speed",prop.getProperty("speed"));
        obj.put("timeFactor",prop.getProperty("timeFactor"));
        obj.put("horizon",prop.getProperty("horizon"));
        obj.put("startLocationFlag",prop.getProperty("startLocationFlag"));
        obj.put("searchTimeLimit",prop.getProperty("searchTimeLimit"));
        obj.put("numberOfVehicles",prop.getProperty("numberOfVehicles"));
        obj.put("jobDuration",prop.getProperty("jobDuration"));
        obj.put("serviceTime",prop.getProperty("serviceTime"));
        obj.put("numberOfLoadingBay",prop.getProperty("numberOfLoadingBay"));
        obj.put("loadingTimeAtBay",prop.getProperty("loadingTimeAtBay"));
        obj.put("maxJobsPerVehicle",prop.getProperty("maxJobsPerVehicle"));
        obj.put("maxValidDistanceBtwnTwoPoints",prop.getProperty("maxValidDistanceBtwnTwoPoints"));
        obj.put("isStartAnywhere",prop.getProperty("isStartAnywhere"));
        obj.put("synchronusFlag",prop.getProperty("synchronusFlag"));
     
        
        try (FileWriter file = new FileWriter("f:\\test.json")) {

            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }

}