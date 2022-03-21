import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvReader {
    public static SchoolDataset[] read() throws IOException {
        // initialize array
        SchoolDataset[] schoolDatasetList = {};

        // CSV reader for dataset
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\UIC\\IDS 517 Enterprise Application Development\\IDS517_team_13_HW4A\\UIUX_school_dataset_2.tsv"))) {
            String line;
            // read line to skip the header
            br.readLine();
            while ((line = br.readLine()) != null) {
                //Initialize a new SchoolDataset class to hold the column values per row
                SchoolDataset schoolDataset = new SchoolDataset();
                //Split each line by commas to be able to access the columns directly
                String[] values = line.split("\t");
                schoolDataset.schoolID = values[0];
                schoolDataset.ranking = values[1];
                schoolDataset.school = values[2];
                schoolDataset.program = values[3];
                schoolDataset.lengthOfProgram = values[4];
                schoolDataset.totalTuition = values[5];
                schoolDataset.location = values[6];
                schoolDataset.toefl = values[7];
                schoolDataset.gre = values[8];
                schoolDataset.portfolio = values[9];
                schoolDataset.deadline = values[10];

                //Initialize a temporary school data set list to process the schoolDatasetList
                SchoolDataset[] tempSchoolDatasetList = new SchoolDataset[schoolDatasetList.length + 1];
                //Create a new index to keep track of where we are within the array
                int index = 0;
                //Run the code in the while loop until you get to the end of schoolDatasetList
                while (index < schoolDatasetList.length) {
                    //Assign each index from schoolDatasetList to the same index on tempSchoolDatasetList
                    tempSchoolDatasetList[index] = schoolDatasetList[index];
                    //Increment the index, so the while loop will end when the index reaches the end of schoolDatasetList
                    index++;
                }
                //Assign the new schoolDataset we just loaded from the csv line to the last index. At this point, the index will be the value of the last position of the array.
                tempSchoolDatasetList[index] = schoolDataset;
                //Assign the tempSchoolDatasetList to the schoolDatasetList to replace the old schoolDatasetList that does not have the latest model we just built.
                schoolDatasetList = tempSchoolDatasetList;
                //System.out.println(line);
            }
        }
        return schoolDatasetList;
    }

}
