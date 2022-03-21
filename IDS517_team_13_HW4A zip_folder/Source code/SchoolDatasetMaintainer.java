import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;


public class SchoolDatasetMaintainer {
	
	public SchoolDataset[] schoolDatasetList;
	
	public SchoolDatasetMaintainer() throws IOException {
	 schoolDatasetList = CsvReader.read();
	}
    
	public  SchoolDataset[] addProgram(String schoolID , String ranking, String school, String program, String lengthOfProgram, String totalTuition, String location, String toefl, String gre, String portfolio, String deadline) throws IOException {
		
		
//		for(int i = 0; i < schoolDatasetList.length; i++) {
//			//newschoolDataset[i] = new SchoolDataset(schoolDatasetList[i].schoolID, schoolDatasetList[i].ranking, schoolDatasetList[i].school, schoolDatasetList[i].program, schoolDatasetList[i].lengthOfProgram, schoolDatasetList[i].totalTuition, schoolDatasetList[i].location, schoolDatasetList[i].toefl, schoolDatasetList[i].gre, schoolDatasetList[i].portfolio, schoolDatasetList[i].deadline);
//			System.out.println(schoolDatasetList[i]);
//		}
		
		SchoolDataset[] newschoolDataset = new SchoolDataset[schoolDatasetList.length + 1];
		
		for(int i = 0; i < schoolDatasetList.length; i++) {
			newschoolDataset[i] = new SchoolDataset(schoolDatasetList[i].schoolID, schoolDatasetList[i].ranking, schoolDatasetList[i].school, schoolDatasetList[i].program, schoolDatasetList[i].lengthOfProgram, schoolDatasetList[i].totalTuition, schoolDatasetList[i].location, schoolDatasetList[i].toefl, schoolDatasetList[i].gre, schoolDatasetList[i].portfolio, schoolDatasetList[i].deadline);
		}
		newschoolDataset[newschoolDataset.length -1] = new SchoolDataset(schoolID, ranking, school, program, lengthOfProgram, totalTuition, location, toefl, gre, portfolio, deadline);
		
//		File file = new File("UIUX school dataset.tsv");
//	        // create FileWriter object with file as parameter
//	        FileWriter outputfile = new FileWriter(file);
//	  
//	        // create CSVWriter object filewriter object as parameter
//	      //  CSVWriter writer = new CSVWriter(outputfile);
//	       
//	        
//	        
//	        CSVWriter writer = new CSVWriter(outputfile, '\t', CSVWriter.NO_QUOTE_CHARACTER,
//                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                    CSVWriter.DEFAULT_LINE_END);
//	  
//	        //adding header to csv
//	        String[] header = { "schoolID", "ranking", "school", "program", "lengthOfProgram", "totalTuition", "location", "toefl", "gre", "portfolio", "deadline" };
//	        writer.writeNext(header);
//	  
//	        for (int i = 0; i < newschoolDataset.length; i++) {
//	        	String[] data1 = {newschoolDataset[i].schoolID,newschoolDataset[i].ranking, newschoolDataset[i].school, newschoolDataset[i].program,newschoolDataset[i].lengthOfProgram, newschoolDataset[i].totalTuition, newschoolDataset[i].location, newschoolDataset[i].toefl, newschoolDataset[i].gre, newschoolDataset[i].portfolio, newschoolDataset[i].deadline };
//	        	writer.writeNext(data1);
//	        }
//	        writer.flush();
//	        writer.close();
	        
	    schoolDatasetList = newschoolDataset;
	    return schoolDatasetList;
	}
	
	public void deleteMostRecent() throws IOException{
		SchoolDataset[] newschoolDataset = new SchoolDataset[schoolDatasetList.length - 1];
		for(int i = 0; i < schoolDatasetList.length - 1; i++) {
			newschoolDataset[i] = new SchoolDataset(schoolDatasetList[i].schoolID, schoolDatasetList[i].ranking, schoolDatasetList[i].school, schoolDatasetList[i].program, schoolDatasetList[i].lengthOfProgram, schoolDatasetList[i].totalTuition, schoolDatasetList[i].location, schoolDatasetList[i].toefl, schoolDatasetList[i].gre, schoolDatasetList[i].portfolio, schoolDatasetList[i].deadline);
		}
//		File file = new File("/Users/saritayang/Desktop/UIUX school dataset.tsv");
//        // create FileWriter object with file as parameter
//        FileWriter outputfile = new FileWriter(file);
//  
//        // create CSVWriter object filewriter object as parameter
//        CSVWriter writer = new CSVWriter(outputfile, '\t', CSVWriter.NO_QUOTE_CHARACTER,
//                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
//                CSVWriter.DEFAULT_LINE_END);
//  
//        // adding header to csv
//        String[] header = { "schoolID", "ranking", "school", "program", "lengthOfProgram", "totalTuition", "location", "toefl", "gre", "portfolio", "deadline" };
//        writer.writeNext(header);
//  
//        for (int i = 0; i < newschoolDataset.length; i++) {
//        	String[] data1 = {newschoolDataset[i].schoolID,newschoolDataset[i].ranking, newschoolDataset[i].school, newschoolDataset[i].program,newschoolDataset[i].lengthOfProgram, newschoolDataset[i].totalTuition, newschoolDataset[i].location, newschoolDataset[i].toefl, newschoolDataset[i].gre, newschoolDataset[i].portfolio, newschoolDataset[i].deadline };
//        	writer.writeNext(data1);
//        }
//        writer.flush();
//        writer.close();
        
    schoolDatasetList = newschoolDataset;
	}
	
	public void deleteBySchool_ID(String school_ID) throws IOException{
		
		
	}
	public static SchoolDataset[] UpdateByRank(String school_id,String Rank) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(school_id);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(school_id)){
	            	//System.out.println("the school_id is:"+school_id);
	            	System.out.println("The school ID that we are updating is: "+schoolDataset.schoolID);
	            	schoolDataset.ranking = Rank;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	public static SchoolDataset[] UpdateBySchoolName(String schoolid,String schoolname) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(schoolname);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	//System.out.println("the school_id is:"+school_id);
	            	System.out.println("The school ID that we are updating is: "+schoolDataset.school);
	            	schoolDataset.school = schoolname;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	public static SchoolDataset[] UpdateByProgramName(String schoolid,String programname) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(programname);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	//System.out.println("the school_id is:"+school_id);
	            	//System.out.println("The school ID that we are updating is: "+schoolDataset.school);
	            	schoolDataset.program = programname;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	public static SchoolDataset[] UpdateByLengthProgram(String schoolid,String lengthOfProgram) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(lengthOfProgram);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	schoolDataset.lengthOfProgram = lengthOfProgram;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }

	public static SchoolDataset[] UpdateBytuition(String schoolid,String Tuition) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(Tuition);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	schoolDataset.totalTuition = Tuition;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	
	public static SchoolDataset[] UpdateByTOEFL(String schoolid,String TOEFL) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(TOEFL);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	schoolDataset.toefl = TOEFL;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	public static SchoolDataset[] UpdateByLocation(String schoolid,String location) throws IOException {
		System.out.println("The parameters have been passed");
		  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
		  System.out.println(location);// read again
		  
	        
	        for(SchoolDataset schoolDataset : schoolDatasetList){
	            if(schoolDataset.schoolID.equals(schoolid)){
	            	schoolDataset.location = location;
	            		//System.out.println(schoolDataset.ranking);
	                }
	            
	               
	            }
	        return schoolDatasetList;
	        
	        }
	
	

public static SchoolDataset[] UpdateByGRE(String schoolid,String GRE) throws IOException {
	System.out.println("The parameters have been passed");
	  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
	  System.out.println(GRE);// read again
	  
        
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(schoolDataset.schoolID.equals(schoolid)){
            	schoolDataset.gre = GRE;
            		//System.out.println(schoolDataset.ranking);
                }
            
               
            }
        return schoolDatasetList;
        
        }

public static SchoolDataset[] UpdateByPortfolio(String schoolid,String portfolio) throws IOException {
	System.out.println("The parameters have been passed");
	  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
	  System.out.println(portfolio);// read again
	  
        
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(schoolDataset.schoolID.equals(schoolid)){
            	schoolDataset.portfolio = portfolio;
            		//System.out.println(schoolDataset.ranking);
                }
            
               
            }
        return schoolDatasetList;
        
        }

public static SchoolDataset[] UpdateByApplicationDeadline(String schoolid,String applicationdeadline) throws IOException {
	System.out.println("The parameters have been passed");
	  SchoolDataset[] schoolDatasetList = CsvReader.read(); 
	  System.out.println(applicationdeadline);// read again
	  
        
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(schoolDataset.schoolID.equals(schoolid)){
            	schoolDataset.portfolio = applicationdeadline;
            		//System.out.println(schoolDataset.ranking);
                }
            
               
            }
        return schoolDatasetList;
        
        }

}
               
	

	
	




