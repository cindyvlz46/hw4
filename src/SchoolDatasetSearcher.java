import java.io.IOException;
import java.util.Locale;

public class SchoolDatasetSearcher {

    // In this class we should:
    // create static methods that will take in array and will take in what were trying to search for
    //search by program name , and so on

    // print all programs
    public static SchoolDataset[] printAllPrograms() throws IOException {
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        return schoolDatasetList;
    }
    // gets list for gre field if user enters yes or no
    public static SchoolDataset[] getByGRE(String greRequired) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read(); // read again
        SchoolDataset[] schoolDatasetListForReturn = {};
        // new schoolDataset
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(schoolDataset.gre.equals(greRequired)){
                SchoolDataset[] tempSchoolDatasetByGre = new SchoolDataset[schoolDatasetListForReturn.length+1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByGre[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByGre[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByGre;
            }
        }
        return schoolDatasetListForReturn;
    }

    //fetches list from the csv and compares to each record to identify the matching schools by toefl score
    public static SchoolDataset[] getByToeflScore(String toefl) throws IOException {
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetByToeflList = {};
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(Integer.parseInt(schoolDataset.toefl) <= Integer.parseInt(toefl)){
                SchoolDataset[] tempSchoolDatasetByToefl = new SchoolDataset[schoolDatasetByToeflList.length+1];
                int index = 0;
                for(SchoolDataset schoolDatasetByToefl : schoolDatasetByToeflList) {
                    tempSchoolDatasetByToefl[index] = schoolDatasetByToefl;
                    index++;
                }
                tempSchoolDatasetByToefl[index] = schoolDataset;
                schoolDatasetByToeflList = tempSchoolDatasetByToefl;
            }

        }
        return schoolDatasetByToeflList;
    }

    public static SchoolDataset[] getByProgramName(String programName) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetListForReturn = {};
        for(SchoolDataset schoolDataset : schoolDatasetList){
            if(schoolDataset.program.toLowerCase().contains(programName)){
                SchoolDataset[] tempSchoolDatasetByProgramName = new SchoolDataset[schoolDatasetListForReturn.length+1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByProgramName[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByProgramName[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByProgramName;
            }
        }
        return schoolDatasetListForReturn;
    }

    //fetches list from the csv and compares to each record to identify the matching schools by program name
    public static SchoolDataset[] getByPortfolio(String portfolio) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetListForReturn = {};
        for(SchoolDataset schoolDataset : schoolDatasetList){
            //this if statement lowercases program name for each record and checks if the program name provided by user is contained in the program name for the row
            if(schoolDataset.portfolio.contains(portfolio)){
                SchoolDataset[] tempSchoolDatasetByPortfolio = new SchoolDataset[schoolDatasetListForReturn.length+1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByPortfolio[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByPortfolio[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByPortfolio;
            }
        }
        return schoolDatasetListForReturn;
    }

    public static SchoolDataset[] getByLocation(String location) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetListForReturn = {};
        for(SchoolDataset schoolDataset : schoolDatasetList) {
            if(schoolDataset.location.contains(location)) {
                SchoolDataset[] tempSchoolDatasetByLocation = new SchoolDataset[schoolDatasetListForReturn.length+1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByLocation[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByLocation[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByLocation;
            }
        }
        return schoolDatasetListForReturn;
    }

    public static SchoolDataset[] getByDeadline(String deadline) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetListForReturn = {};
        for(SchoolDataset schoolDataset : schoolDatasetList) {
            if(schoolDataset.deadline.toLowerCase().contains(deadline.toLowerCase())){
                SchoolDataset[] tempSchoolDatasetByDeadline = new SchoolDataset[schoolDatasetListForReturn.length + 1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByDeadline[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByDeadline[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByDeadline;
            }
        }
        return schoolDatasetListForReturn;
    }
    public static SchoolDataset[] getByRanking(String ranking) throws IOException{
        SchoolDataset[] schoolDatasetList = CsvReader.read();
        SchoolDataset[] schoolDatasetListForReturn = {};
        for(SchoolDataset schoolDataset : schoolDatasetList) {
            if(schoolDataset.ranking.contentEquals(ranking)){
                SchoolDataset[] tempSchoolDatasetByRanking = new SchoolDataset[schoolDatasetListForReturn.length + 1];
                int index = 0;
                for(SchoolDataset schoolDatasetForReturn : schoolDatasetListForReturn) {
                    tempSchoolDatasetByRanking[index] = schoolDatasetForReturn;
                    index++;
                }
                tempSchoolDatasetByRanking[index] = schoolDataset;
                schoolDatasetListForReturn = tempSchoolDatasetByRanking;
            }
        }
        return schoolDatasetListForReturn;
    }

}




