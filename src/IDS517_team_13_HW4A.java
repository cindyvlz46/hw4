import java.io.*;
import java.util.Arrays;
import java.util.Scanner;



public class IDS517_team_13_HW4A {


    public static void main(String[] args) throws IOException {
        //reads in csv file
        SchoolDataset[] schoolDatasetList = {};
        //user input
        String command = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select your user input: " + "\n" + "1. student" + "\n" + "2. employee");
        command = sc.nextLine();
        //setting boolean if it's a student or employee before you go in while loop so the program remembers if you're a student or employee
        boolean student = command.equals("1");
        boolean employee = command.equals("2");

        while (!student && !employee) {
            System.out.println("Please select your user input: " + "\n" + "1. student" + "\n" + "2. employee");
            command = sc.nextLine();
            //setting boolean if it's a student or employee before you go in while loop so the program remembers if you're a student or employee
            student = command.equals("1");
            employee = command.equals("2");
        }
        //keep this because the while loop allows the user to select other options unless the user types in 0 for exit
        while (!command.equals("0")) {
            if (student) {
                System.out.println("1. List out all the universities provided UI/UX programs in 2023");
                System.out.println("2. Search by GRE score requirement");
                System.out.println("3. Search by your TOEFL score");
                System.out.println("4. Search by Program Name");
                System.out.println("5. Search by Portfolio");
                System.out.println("6. Search by Location");
                System.out.println("7. Search by Deadline");
                System.out.println("0. Exit out of program");
                System.out.print("Enter a selection: ");
                command = sc.nextLine();

                switch (command) {
                    case "1":
                        schoolDatasetList = SchoolDatasetSearcher.printAllPrograms();
                    
                        //System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "2":
                        System.out.println("Do you have a GRE score? (yes/no)");
                        command = sc.nextLine();
                        if (command.equals("yes") || command.equals("y")) {
                            schoolDatasetList = SchoolDatasetSearcher.getByGRE("Y");
                        } else if (command.equals("no") || command.equals("n")) {
                            schoolDatasetList = SchoolDatasetSearcher.getByGRE("N");
                        }
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "3":
                        System.out.print("Please provide your TOEFL score: ");
                        command = sc.nextLine();
                        schoolDatasetList = SchoolDatasetSearcher.getByToeflScore(command);
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "4":
                        System.out.println("Enter program name: ");
                        command =sc.nextLine();
                        schoolDatasetList = SchoolDatasetSearcher.getByProgramName(command);
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "5":
                        System.out.println("Do you have a portfolio? (1. Require 2. Optional) ");
                        command = sc.nextLine();
                        if (command.equals("1")) {
                            schoolDatasetList = SchoolDatasetSearcher.getByPortfolio("Require");
                        } else if (command.equals("2")) {
                            schoolDatasetList = SchoolDatasetSearcher.getByPortfolio("Optional");
                        }
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "6":
                        System.out.println("Please choose the school location: " + "\n" + "Here are all the school located (Please type use UpperCase): " + "\n" + "PA, WA, CA, GA, MA, NY, MI, IN, MD, AZ, TX, IL");
                        command = sc.nextLine();
                        schoolDatasetList = SchoolDatasetSearcher.getByLocation(command);
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "7":
                        System.out.println("The last application deadline is in June and the earlier application deadline is in December." + "\n" + "When do you plan to apply schools?" + "\n" + "Dec, Jan, Feb, Mar, Apr, May, Jun");
                        command = sc.nextLine();
                        schoolDatasetList = SchoolDatasetSearcher.getByDeadline(command);
                        System.out.println("These are your options: ");
                        printInfo(schoolDatasetList);
                        break;
                    case "0":
                        System.out.println("Bye!!");
                        break;
                    default: 
                    {
                    	System.out.println("\nPlease enter a valid entry\n");
                    }
                }


                // displays employee menu, which allows update/delete /change
            } else if (employee) {
                System.out.println("1. Add School Information");
                System.out.println("2. Delete School Information");
                System.out.println("3. Update School Information by the ");
                System.out.println("0. Exit out of program");
                command = sc.nextLine();

                switch (command) {
                    case "1":
                        System.out.println("Please provide the update data: School_ID, Ranking, School, Program, Length Of Program, Total Tuition ($), Location, TOEFL score, GRE score, Portfolio Required (Required/ Optional), Application Deadline (Month Date, Year)");
                        System.out.println("All the above specified fields are required\n");
                        System.out.println("Enter the School ID");
                        String school_id = sc.nextLine();
                        System.out.println("Enter the Ranking");
                        String school_ranking = sc.nextLine();
                        System.out.println("Enter the School Name");
                        String school_name = sc.nextLine();
                        System.out.println("Enter the Program Name");
                        String program_name = sc.nextLine();
                        System.out.println("Length of the program");
                        String length = sc.nextLine();
                        System.out.println("Total Tution of the program");
                        String tuition = sc.nextLine();
                        if (!tuition.contains("$")) {
                            tuition = "$ " + tuition;
                        }
                        System.out.println("Location of the college");
                        String location = sc.nextLine();
                        System.out.println("Enter the minimum TOEFL Score of the program");
                        String toefl = sc.nextLine();
                        System.out.println("Is GRE Score mandatory (Y/N)");
                        String gre = sc.nextLine();
                        System.out.println("Is Portfolio mandatory (Required/ Not Required)");
                        String portfolio = sc.nextLine();
                        System.out.println("Enter the deadline date");
                        String deadline_date = sc.nextLine();
                        SchoolDatasetMaintainer SchoolDatasetMaintain = new SchoolDatasetMaintainer();
                        schoolDatasetList = SchoolDatasetMaintain.addProgram(school_id,school_ranking,school_name,program_name,length,tuition,location,toefl,gre,portfolio,deadline_date);
                        printInfo(schoolDatasetList);
                        break;
                    
                    case "2":
                        System.out.println("1. Delete the most recent data");
                        System.out.println("2. Delete by ranking");

                        command = sc.nextLine();
                        switch(command) {
                            case "1":
                                SchoolDatasetMaintainer schoolDatasetMaintainer = new SchoolDatasetMaintainer();
                                schoolDatasetMaintainer.deleteMostRecent();
                                break;
                            case "2":
                                System.out.println("What rank would you like to delete?");
                                command = sc.nextLine();
                                SchoolDatasetMaintainer.deleteProgramByRank(command);
                                break;
                        }
                    case "0":
                    	System.out.println("Bye!!");
                        break;
                        
                    case "3":
                    	System.out.println("Update the data by School_Id:");
                    	System.out.println("Please enter the School ID:");
                    	school_id = sc.nextLine();
                    	System.out.println("\nWhat do you want to update");
                    	//System.out.println("\n");
                    	System.out.println("1. Ranking");
                    	System.out.println("2. School Name");
                    	System.out.println("3. Program Name");
                    	System.out.println("4. Length of Program");
                    	System.out.println("5. Total Tuition Fees");
                    	System.out.println("6. Minimum TOEFL Score");
                    	System.out.println("7. Is GRE Score Required or Not");
                    	System.out.println("8. Portfolio Required");
                    	System.out.println("9. Application Deadline");
                    	String command1 = sc.nextLine();
                    	
                    	
                    	switch(command1) {
                    	case "1": 
                    		System.out.println("Please enter the ranking that you want to update");
                    		String ranks = sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByRank(school_id,ranks);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                    		break;
                    	
                    	case "2": 
                    		System.out.println("Please enter the SchoolName that you want to update");
                    		String schoolname = sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateBySchoolName(school_id,schoolname);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                    		
                    	case "3":
                    		System.out.println("Please enter the Program Name that you want to update");
                    		String programname= sc.nextLine();
                    		
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByProgramName(school_id, programname);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                    	case "4":
                    		System.out.println("Please enter the Length of Program that you want to update");
                    		String lengthofProgram= sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByLengthProgram(school_id,lengthofProgram);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                             
                    	case "5":
                    		System.out.println("Please enter the tuition that you want to update");
                    		String tuition1= sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateBytuition(school_id,tuition1);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                    		break;
                    	case "6":
                    		System.out.println("Please enter the TOEFL that you want to update");
                    		String toefl1= sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByTOEFL(school_id,toefl1);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                    	case "7":
                    		System.out.println("Please enter the GRE Requirement that you want to update\n");
                    		String gre1 = sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByGRE(school_id,gre1);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                    	case "8":
                    		System.out.println("Please enter the Portfolio Requirement that you want to update\n");
                    		String portfolio1 = sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByPortfolio(school_id,portfolio1);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                    		 break;
                    	case "9":
                    		System.out.println("Please enter the Application Deadline that you want to update\n");
                    		String applicationdeadline = sc.nextLine();
                    		// SchoolDatasetMaintainer SchoolDatasetMaintain1 = new SchoolDatasetMaintainer();
                             schoolDatasetList = SchoolDatasetMaintainer.UpdateByApplicationDeadline(school_id,applicationdeadline);
                             System.out.println("\n-------------------------------------------\n");
                             System.out.println("The updated school data list\n");
                        
                             printInfo(schoolDatasetList);
                             
                             break;
                    	}
                        	default:
                        		System.out.println("\nPlease enter a valid entry\n");

                    }
                	
                		
                		//System.out.println("\nPlease enter a valid entry\n");
            		}
            }

//            else{
//                System.out.println("Invalid command, please try again");
            }
        
       
        //System.out.println();
    
    //this method displays all school information
    public static void printInfo(SchoolDataset[] schoolDatasetList) {

        System.out.println("School ID" + "\t" + "Ranking" + "\t\t" +  "School" + "\t\t\t\t\t " + "Program" + "\t\t\t\t\t\t\t\t\t" +  "Length Of Program" + "\t" +  "Total Tuition" + "\t\t"+  "Location" + "\t\t" +  "TOEFL" + "\t\t" +  "GRE" + "\t\t" +  "Portfolio Required" + "\t" +  "Application Deadline" + "\t\t");
        if(schoolDatasetList.length == 0){
            System.out.println("No data found!");
        }else{
            for (SchoolDataset schoolDataset : schoolDatasetList) {
                System.out.println(schoolDataset);
            }
        }
    }
}



